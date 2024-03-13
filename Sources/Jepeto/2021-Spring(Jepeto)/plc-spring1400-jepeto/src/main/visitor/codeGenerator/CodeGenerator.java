package main.visitor.codeGenerator;

import main.ast.nodes.*;
import main.ast.nodes.declaration.*;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.operators.BinaryOperator;
import main.ast.nodes.expression.operators.UnaryOperator;
import main.ast.nodes.expression.values.*;
import main.ast.nodes.expression.values.primitive.*;
import main.ast.nodes.statement.*;
import main.ast.types.*;
import main.ast.types.functionPointer.*;
import main.ast.types.list.*;
import main.ast.types.single.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.FunctionSymbolTableItem;
import main.visitor.Visitor;
import main.visitor.type.ExpressionTypeChecker;

import java.io.*;
import java.util.*;

public class CodeGenerator extends Visitor<String> {
    private final String outputPath;
    private FileWriter mainFile;
    private final ExpressionTypeChecker expressionTypeChecker;
    private final Set<String> visited;
    private int numOfUsedTemp = 0;
    private int numOfUsedLabel = 0;
    private FunctionDeclaration curFuncDec;
    private FunctionSymbolTableItem curFuncSTI;

    private Map<String, String> anonymousFunctionsBodies = new LinkedHashMap<>();
    private String curAnonymousFunctionBody = "";
    private boolean isInAnonymousFunctionBody = false;

    public CodeGenerator(ExpressionTypeChecker expressionTypeChecker, Set<String> visited) {
        this.expressionTypeChecker = expressionTypeChecker;
        this.visited = visited;
        outputPath = "./output/";
        prepareOutputFolder();
    }

    private void prepareOutputFolder() {
        String jasminPath = "utilities/jarFiles/jasmin.jar";
        String listClassPath = "utilities/codeGenerationUtilityClasses/List.j";
        String fptrClassPath = "utilities/codeGenerationUtilityClasses/Fptr.j";
        try{
            File directory = new File(this.outputPath);
            File[] files = directory.listFiles();
            if(files != null)
                for (File file : files)
                    file.delete();
             directory.mkdir();
        }
        catch(SecurityException e) {//unreachable
        }
        copyFile(jasminPath, this.outputPath + "jasmin.jar");
        copyFile(listClassPath, this.outputPath + "List.j");
        copyFile(fptrClassPath, this.outputPath + "Fptr.j");

        try {
            String path = outputPath + "Main.j";
            File file = new File(path);
            file.createNewFile();
            mainFile = new FileWriter(path);
        } catch (IOException e) {//unreachable
        }
    }

    private void copyFile(String toBeCopied, String toBePasted) {
        try {
            File readingFile = new File(toBeCopied);
            File writingFile = new File(toBePasted);
            InputStream readingFileStream = new FileInputStream(readingFile);
            OutputStream writingFileStream = new FileOutputStream(writingFile);
            byte[] buffer = new byte[1024];
            int readLength;
            while ((readLength = readingFileStream.read(buffer)) > 0)
                writingFileStream.write(buffer, 0, readLength);
            readingFileStream.close();
            writingFileStream.close();
        } catch (IOException e) {//never reached
        }
    }

    private void addCommand(String command) {
        if(isInAnonymousFunctionBody){
            curAnonymousFunctionBody += command + "\n";
            return;
        }
        try {
            command = String.join("\n\t\t", command.split("\n"));
            if(command.startsWith("Label_"))
                mainFile.write("\t" + command + "\n");
            else if(command.startsWith("."))
                mainFile.write(command + "\n");
            else
                mainFile.write("\t\t" + command + "\n");
            mainFile.flush();
        } catch (IOException e) {//never reached

        }
    }

    private void addStaticMainMethod() {
        addCommand(".method public static main([Ljava/lang/String;)V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("new Main");
        addCommand("invokespecial Main/<init>()V");
        addCommand("return");
        addCommand(".end method");
    }

    private int slotOf(String identifier) {
        int count = 1;
        if (curFuncDec != null){
            for(Identifier arg : curFuncDec.getArgs()){
                if(arg.getName().equals(identifier))
                    return count;
                count++;
            }
        }
        if (identifier.equals("")){
            int temp = numOfUsedTemp;
            numOfUsedTemp++;
            return count + temp;
        }
        return 0;
    }

    private String makeTypeSignature(Type t) {
        if (t instanceof IntType)
            return "java/lang/Integer";
        if (t instanceof BoolType)
            return "java/lang/Boolean";
        if (t instanceof StringType)
            return "java/lang/String";
        if (t instanceof ListType)
            return "List";
        if (t instanceof FptrType)
            return "Fptr";
        return null;
    }

    private String getFreshLabel(){
        String label = "Label_";
        label += numOfUsedLabel;
        numOfUsedLabel++;
        return label;
    }

    private String primitiveToNonPrimitive(Type type){
        String commands = "";
        if(type instanceof IntType)
            commands += "invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;\n";
        if(type instanceof BoolType)
            commands += "invokestatic java/lang/Boolean/valueOf(Z)Ljava/lang/Boolean;\n";
        return commands;
    }

    private String nonPrimitiveToPrimitive(Type type){
        String commands = "";
        if(type instanceof IntType)
            commands += "invokevirtual java/lang/Integer/intValue()I\n";
        if(type instanceof BoolType)
            commands += "invokevirtual java/lang/Boolean/booleanValue()Z\n";
        return commands;
    }

    @Override
    public String visit(Program program) {
        addCommand(".class Main");
        addCommand(".super java/lang/Object");

        addStaticMainMethod();

        program.getMain().accept(this);

        for(FunctionDeclaration funcDec : program.getFunctions()){
            if (! visited.contains(funcDec.getFunctionName().getName()))
                continue;
            funcDec.accept(this);
            numOfUsedTemp = 0;
        }

        for(String key : anonymousFunctionsBodies.keySet()){
            if (! visited.contains(key))
                continue;
            addCommand(anonymousFunctionsBodies.get(key));
        }
        return null;
    }//test

    @Override
    public String visit(FunctionDeclaration funcDeclaration) {
        String searchKey = FunctionSymbolTableItem.START_KEY + funcDeclaration.getFunctionName().getName();
        Map<String, Type> argTypes = new LinkedHashMap<>();
        Type returnType = new VoidType();
        try {
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(searchKey);
            curFuncDec = functionSymbolTableItem.getFuncDeclaration();
            curFuncSTI = functionSymbolTableItem;
            expressionTypeChecker.setCurFunction(functionSymbolTableItem);
            argTypes = functionSymbolTableItem.getArgTypes();
            returnType = functionSymbolTableItem.getReturnType();
        }catch (ItemNotFoundException e){ //unreachable
        }

        String header = "";
        header += ".method public " + funcDeclaration.getFunctionName().getName() + "(";
        for(Identifier arg : funcDeclaration.getArgs()){
            header += "L" + makeTypeSignature(argTypes.get(arg.getName())) + ";";
        }
        if (returnType instanceof VoidType)
            header += ")V";
        else
            header += ")L"  + makeTypeSignature(returnType) + ";";

        addCommand(header);
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");

        funcDeclaration.getBody().accept(this);
//        addCommand("return");
        addCommand(".end method");

        return null;
    } //test

    @Override
    public String visit(MainDeclaration mainDeclaration) {
        addCommand(".method public <init>()V");
        addCommand(".limit stack 128");
        addCommand(".limit locals 128");
        addCommand("aload 0");
        addCommand("invokespecial java/lang/Object/<init>()V");

        mainDeclaration.getBody().accept(this);

        addCommand("return");
        addCommand(".end method");
        return null;
    } //test

    @Override
    public String visit(BlockStmt blockStmt) {
        for (Statement statement: blockStmt.getStatements()) {
            statement.accept(this);
        }
        return null;
    } //test

    @Override
    public String visit(ConditionalStmt conditionalStmt) {
        String labelFalse = getFreshLabel();
        String labelAfter = getFreshLabel();
        addCommand(conditionalStmt.getCondition().accept(this));
        addCommand("ifeq " + labelFalse);
        conditionalStmt.getThenBody().accept(this);
        addCommand("goto " + labelAfter);
        addCommand(labelFalse + ":");
        if (conditionalStmt.getElseBody() != null)
            conditionalStmt.getElseBody().accept(this);
        addCommand(labelAfter + ":");
        return null;
    }

    @Override
    public String visit(FunctionCallStmt funcCallStmt) {
        expressionTypeChecker.setFunctioncallStmt(true);
        addCommand(funcCallStmt.getFunctionCall().accept(this));
        addCommand("pop");
        expressionTypeChecker.setFunctioncallStmt(false);
        return null;
    } //test

    @Override
    public String visit(PrintStmt print) {
        addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
        Type argType = print.getArg().accept(expressionTypeChecker);
        int argSlot = slotOf("");
        String commandsOfArg = print.getArg().accept(this);
        if (argType instanceof ListType){
            addCommand("ldc \"[\"");
            addCommand("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
            int sizeSlot = slotOf("");
            int indexSlot = slotOf("");

            addCommand("ldc 0");
            addCommand("istore " + indexSlot);

            addCommand(commandsOfArg);
            addCommand("astore " + argSlot);
            addCommand("aload " + argSlot);

            addCommand("invokevirtual List/getSize()I\n");
            addCommand("istore " + sizeSlot);

            String labelStart = getFreshLabel();
            String labelAfter = getFreshLabel();

            addCommand(labelStart + ":");
            addCommand("iload " + indexSlot);
            addCommand("iload " + sizeSlot);
            addCommand("if_icmpge " + labelAfter);

            addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
            addCommand("aload " + argSlot);
            addCommand("iload " + indexSlot);
            addCommand("invokevirtual List/getElement(I)Ljava/lang/Object;");
            addCommand("checkcast " + makeTypeSignature(new IntType()));
            addCommand(nonPrimitiveToPrimitive(new IntType()));
            addCommand("invokevirtual java/io/PrintStream/print(I)V");

            addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
            addCommand("ldc \",\"");
            addCommand("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");

            addCommand("ldc 1");
            addCommand("iload " + indexSlot);
            addCommand("iadd");
            addCommand("istore " + indexSlot);


            addCommand("goto " + labelStart);
            addCommand(labelAfter + ":");

            String labelAfter2 = getFreshLabel();
            addCommand("iload " + sizeSlot);
            addCommand("ifeq " + labelAfter2);
            addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
            addCommand("ldc \"\b\"");
            addCommand("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");

            addCommand(labelAfter2 + ":");
            addCommand("getstatic java/lang/System/out Ljava/io/PrintStream;");
            addCommand("ldc \"]\"");
            addCommand("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");

        }
        else{
            addCommand(commandsOfArg);
            if (argType instanceof IntType)
                addCommand("invokevirtual java/io/PrintStream/println(I)V");
            if (argType instanceof BoolType)
                addCommand("invokevirtual java/io/PrintStream/println(Z)V");
            if (argType instanceof StringType)
                addCommand("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
        }
        return null;
    } //test

    @Override
    public String visit(ReturnStmt returnStmt) {
        Type type = returnStmt.getReturnedExpr().accept(expressionTypeChecker);
        if(type instanceof VoidType) {
            addCommand("return");
        }
        else {
            addCommand( returnStmt.getReturnedExpr().accept(this) );
            addCommand(primitiveToNonPrimitive(type));
            addCommand("areturn");
        }
        return null;
    } //test

    @Override
    public String visit(BinaryExpression binaryExpression) {
        BinaryOperator operator = binaryExpression.getBinaryOperator();
        Type operandType = binaryExpression.getSecondOperand().accept(expressionTypeChecker);

        String commands = "";
        if (operator == BinaryOperator.add) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "iadd\n";
        } //test
        else if (operator == BinaryOperator.sub) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "isub\n";
        } //test
        else if (operator == BinaryOperator.mult) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "imul\n";
        } //test
        else if (operator == BinaryOperator.div) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "idiv\n";
        } //test
        else if((operator == BinaryOperator.gt) || (operator == BinaryOperator.lt)) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            if(operator == BinaryOperator.gt)
                commands += "if_icmple " + labelFalse + "\n";
            else
                commands += "if_icmpge " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        } //test
        else if((operator == BinaryOperator.eq) || (operator == BinaryOperator.neq)) {
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += binaryExpression.getSecondOperand().accept(this);
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            if(operator == BinaryOperator.eq){
                if (!(operandType instanceof IntType) && !(operandType instanceof BoolType))
                    commands += "if_acmpne " + labelFalse + "\n";
                else
                    commands += "if_icmpne " + labelFalse + "\n";
            }
            else{
                if (!(operandType instanceof IntType) && !(operandType instanceof BoolType))
                    commands += "if_acmpeq " + labelFalse + "\n";
                else
                    commands += "if_icmpeq " + labelFalse + "\n";

            }
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.and) {
            String labelFalse = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifeq " + labelFalse + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelFalse + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.or) {
            String labelTrue = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += "ifne " + labelTrue + "\n";
            commands += "ldc " + "0\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelTrue + ":\n";
            commands += "ldc " + "1\n";
            commands += labelAfter + ":\n";
        }
        else if(operator == BinaryOperator.append){
            commands += binaryExpression.getFirstOperand().accept(this);
            commands += "dup\n";
            commands += binaryExpression.getSecondOperand().accept(this);
            commands += primitiveToNonPrimitive(operandType);
            commands += "invokevirtual List/addElement(Ljava/lang/Object;)V\n";
        }
        return commands;
    }

    @Override
    public String visit(UnaryExpression unaryExpression) {
        UnaryOperator operator = unaryExpression.getOperator();
        String commands = "";
        commands += unaryExpression.getOperand().accept(this);
        if(operator == UnaryOperator.minus) {
            commands += "ineg\n";
        }
        else if(operator == UnaryOperator.not) {
            String labelTrue = getFreshLabel();
            String labelAfter = getFreshLabel();
            commands +=  "ifne " + labelTrue + "\n";
            commands += "ldc " + "1\n";
            commands += "goto " + labelAfter + "\n";
            commands += labelTrue + ":\n";
            commands += "ldc " + "0\n";
            commands += labelAfter + ":\n";
        }
        return commands;
    }

    @Override
    public String visit(AnonymousFunction anonymousFunction) {
        FunctionDeclaration tempCurFunc = curFuncDec;
        String commands = "";
        String searchKey = FunctionSymbolTableItem.START_KEY + anonymousFunction.getName();
        Map<String, Type> argTypes = new LinkedHashMap<>();
        Type returnType = new VoidType();

        try {
            FunctionSymbolTableItem functionSymbolTableItem = (FunctionSymbolTableItem) SymbolTable.root.getItem(searchKey);
            curFuncDec = functionSymbolTableItem.getFuncDeclaration();
            expressionTypeChecker.setCurFunction(functionSymbolTableItem);
            argTypes = functionSymbolTableItem.getArgTypes();
            returnType = functionSymbolTableItem.getReturnType();
        }catch (ItemNotFoundException e){ //unreachable
        }

        String header = "";
        header += ".method public " + anonymousFunction.getName() + "(";
        for(Identifier arg : anonymousFunction.getArgs()){
            header += "L" + makeTypeSignature(argTypes.get(arg.getName())) + ";";
        }
        if (returnType instanceof VoidType)
            header += ")V";
        else
            header += ")L"  + makeTypeSignature(returnType) + ";";

        commands += header + "\n";
        commands += ".limit stack 128\n";
        commands += ".limit locals 128\n";

        curAnonymousFunctionBody = "";
        isInAnonymousFunctionBody = true;
        anonymousFunction.getBody().accept(this);
        isInAnonymousFunctionBody = false;

        commands += curAnonymousFunctionBody + "\n";
        commands += ".end method\n";
        commands = commands.replace("\n\n", "\n");
        anonymousFunctionsBodies.put(anonymousFunction.getName(), commands);

        commands = "";
        commands += "new Fptr\n";
        commands += "dup\n";
        commands += "aload 0\n";
        commands += "ldc \"" + anonymousFunction.getName() + "\"\n";
        commands += "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";

        curFuncDec = tempCurFunc;
        expressionTypeChecker.setCurFunction(curFuncSTI);
        return commands;
    }

    @Override
    public String visit(Identifier identifier) {
        String commands = "";
        String searchKey = FunctionSymbolTableItem.START_KEY + identifier.getName();
        Type type = identifier.accept(expressionTypeChecker);
        int slotOfArgument;
        try {
            SymbolTable.root.getItem(searchKey);
            commands += "new Fptr\n";
            commands += "dup\n";
            commands += "aload 0\n";
            commands += "ldc \"" + identifier.getName() + "\"\n";
            commands += "invokespecial Fptr/<init>(Ljava/lang/Object;Ljava/lang/String;)V\n";
        }catch (ItemNotFoundException e){
            slotOfArgument = slotOf(identifier.getName());
            commands += "aload " + slotOfArgument + "\n";
            commands += nonPrimitiveToPrimitive(type);
        }
        return commands;
    } //test

    @Override
    public String visit(FunctionCall funcCall) {
        String commands = "";
        int tempIndex = slotOf("");

        FptrType fptrType = (FptrType) funcCall.getInstance().accept(expressionTypeChecker);
        String searchKey = FunctionSymbolTableItem.START_KEY + fptrType.getFunctionName();
        Type retType = new VoidType(); // just for initialize
        ArrayList<Expression> args = new ArrayList<>();
        FunctionSymbolTableItem functionSymbolTableItem = null;

        try {
            functionSymbolTableItem = (FunctionSymbolTableItem)SymbolTable.root.getItem(searchKey);
            retType = functionSymbolTableItem.getReturnType();
        }catch (ItemNotFoundException e){ //unreachable
        }

        if (funcCall.getArgsWithKey().size() > 0){
            for (Identifier argName : functionSymbolTableItem.getFuncDeclaration().getArgs()){
                for (Map.Entry<Identifier,Expression> argsWithKey: funcCall.getArgsWithKey().entrySet()) {
                    if(argsWithKey.getKey().toString().equals(argName.toString())){
                        args.add(argsWithKey.getValue());
                    }
                }
            }
        }
        else{
            args = funcCall.getArgs();
        }

        commands += funcCall.getInstance().accept(this);

        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";
        commands += "astore " + tempIndex + "\n";


        for(Expression arg : args){
            commands += "aload " + tempIndex + "\n";

            Type argType = arg.accept(expressionTypeChecker);

            if(argType instanceof ListType) {
                commands += "new List\n";
                commands += "dup\n";
            }

            commands += arg.accept(this);

            if(argType instanceof ListType) {
                commands += "invokespecial List/<init>(LList;)V\n";
            }
            commands += primitiveToNonPrimitive(argType);
            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }

        commands += "aload " + tempIndex + "\n";
        commands += "invokevirtual Fptr/invoke(Ljava/util/ArrayList;)Ljava/lang/Object;\n";

        if(!(retType instanceof VoidType))
            commands += "checkcast " + makeTypeSignature(retType) + "\n";
        commands += nonPrimitiveToPrimitive(retType);
        return commands;
    } //test

    @Override
    public String visit(ListAccessByIndex listAccessByIndex) {
        String commands = "";
        ListType listType = (ListType)listAccessByIndex.getInstance().accept(expressionTypeChecker);

        commands += listAccessByIndex.getInstance().accept(this);
        commands += listAccessByIndex.getIndex().accept(this);
        commands += "invokevirtual List/getElement(I)Ljava/lang/Object;\n";

        commands += "checkcast " + makeTypeSignature(listType.getType()) + "\n";
        commands += nonPrimitiveToPrimitive(listType.getType());
        return commands;
    }//test

    @Override
    public String visit(ListSize listSize) {
        String commands = "";
        commands += listSize.getInstance().accept(this);
        commands += "invokevirtual List/getSize()I\n";
        return commands;
    }//test


    @Override
    public String visit(ListValue listValue) {
        String commands = "";
        int tempIndex = slotOf("");
        ArrayList<Expression> elements = listValue.getElements();

        commands += "new List\n";
        commands += "dup\n";
        commands += "new java/util/ArrayList\n";
        commands += "dup\n";
        commands += "invokespecial java/util/ArrayList/<init>()V\n";
        commands += "astore " + tempIndex + "\n";
        for (Expression element: elements) {
            Type elementType = element.accept(expressionTypeChecker);
            commands += "aload " + tempIndex + "\n";
            commands += element.accept(this);
            commands += primitiveToNonPrimitive(elementType);
            commands += "invokevirtual java/util/ArrayList/add(Ljava/lang/Object;)Z\n";
            commands += "pop\n";
        }
        commands += "aload " + tempIndex + "\n";
        commands += "invokespecial List/<init>(Ljava/util/ArrayList;)V\n";
        return commands;
    }//test

    @Override
    public String visit(IntValue intValue) {
        String commands = "";
        commands += "ldc " + intValue.getConstant() +"\n";
        return commands;
    }//test

    @Override
    public String visit(BoolValue boolValue) {
        String commands = "";
        if(boolValue.getConstant())
            commands += "ldc " + "1\n";
        else
            commands += "ldc " + "0\n";
        return commands;
    }//test

    @Override
    public String visit(StringValue stringValue) {
        String commands = "";
        commands += "ldc \"" + stringValue.getConstant() + "\"\n";
        return commands;
    }//test

    @Override
    public String visit(VoidValue voidValue) {
        return "";
    }//test
}
