package main.visitor.nameAnalyzer;

import main.ast.nodes.Program;
import main.ast.nodes.declaration.FunctionDeclaration;
import main.ast.nodes.declaration.MainDeclaration;
import main.ast.nodes.declaration.PatternDeclaration;
import main.ast.nodes.declaration.VarDeclaration;
import main.ast.nodes.expression.*;
import main.ast.nodes.expression.value.FunctionPointer;
import main.ast.nodes.expression.value.ListValue;
import main.ast.nodes.expression.value.primitive.BoolValue;
import main.ast.nodes.expression.value.primitive.FloatValue;
import main.ast.nodes.expression.value.primitive.IntValue;
import main.ast.nodes.expression.value.primitive.StringValue;
import main.ast.nodes.statement.*;
import main.compileError.CompileError;
import main.compileError.nameErrors.*;
import main.symbolTable.SymbolTable;
import main.symbolTable.exceptions.ItemAlreadyExists;
import main.symbolTable.exceptions.ItemNotFound;
import main.symbolTable.item.FunctionItem;
import main.symbolTable.item.PatternItem;
import main.symbolTable.item.VarItem;
import main.visitor.Visitor;

import java.util.ArrayList;

public class NameAnalyzer extends Visitor<Void> {
    public ArrayList<CompileError> nameErrors = new ArrayList<>();
    boolean isFunctionCallId = false;
    boolean isPatternMatchId = false;
    @Override
    public Void visit(Program program){
        SymbolTable.root = new SymbolTable();
        SymbolTable.top = new SymbolTable();

        //addFunctions
        ArrayList<FunctionItem> functionItems = new ArrayList<>();
        int duplicateFunctionId = 0;
        for(FunctionDeclaration functionDeclaration: program.getFunctionDeclarations()){
            FunctionItem functionItem = new FunctionItem(functionDeclaration);
            try {
                SymbolTable.root.put(functionItem);
                functionItems.add(functionItem);
            }catch (ItemAlreadyExists e){
                nameErrors.add(new RedefinitionOfFunction(functionDeclaration.getLine(),
                        functionDeclaration.getFunctionName().getName()));
                duplicateFunctionId += 1;
                String freshName = functionItem.getName() + "#" + String.valueOf(duplicateFunctionId);
                Identifier newId = functionDeclaration.getFunctionName();
                newId.setName(freshName);
                functionDeclaration.setFunctionName(newId);
                FunctionItem newItem = new FunctionItem(functionDeclaration);
                functionItems.add(newItem);
                try {
                    SymbolTable.root.put(newItem);
                }catch (ItemAlreadyExists ignored){}
            }
        }
        //addPatterns
        int duplicatePatternId = 0;
        ArrayList<PatternItem> patternItems = new ArrayList<>();
        for(PatternDeclaration patternDeclaration : program.getPatternDeclarations()){
            PatternItem patternItem = new PatternItem(patternDeclaration);
            try{
                SymbolTable.root.put(patternItem);
                patternItems.add(patternItem);
            }catch (ItemAlreadyExists e){
                nameErrors.add(new RedefinitionOfPattern(patternDeclaration.getLine(),
                        patternDeclaration.getPatternName().getName()));
                duplicatePatternId += 1;
                String freshName = patternItem.getName() + "#" + String.valueOf(duplicatePatternId);
                Identifier newId =  patternDeclaration.getPatternName();
                newId.setName(freshName);
                patternDeclaration.setPatternName(newId);
                PatternItem newItem = new PatternItem(patternDeclaration);
                try{
                    SymbolTable.root.put(newItem);
                }catch (ItemAlreadyExists ignored){}
            }
        }
        //visitFunctions
        int visitingFunctionIndex = 0;
        for(FunctionDeclaration functionDeclaration : program.getFunctionDeclarations()){
            FunctionItem functionItem = functionItems.get(visitingFunctionIndex);
            SymbolTable functionSymboleTable = new SymbolTable();
            functionItem.setFunctionSymbolTable(functionSymboleTable);
            SymbolTable.push(functionSymboleTable);
            functionDeclaration.accept(this);
            SymbolTable.pop();
            visitingFunctionIndex += 1;
        }
        //visitPatterns
        int visitingPatternIndex = 0;
        for(PatternDeclaration patternDeclaration : program.getPatternDeclarations()){
            PatternItem patternItem = patternItems.get(visitingPatternIndex);
            SymbolTable patternSymbolTable = new SymbolTable();
            patternItem.setPatternSymbolTable(patternSymbolTable);
            SymbolTable.push(patternSymbolTable);
            patternDeclaration.accept(this);
            SymbolTable.pop();
            visitingPatternIndex += 1;
        }
        //visitMain
        program.getMain().accept(this);
        return null;
    }
    @Override
    public Void visit(Identifier identifier){
        if(isFunctionCallId){
            try{
                SymbolTable.root.getItem(FunctionItem.START_KEY + identifier.getName());
            }catch (ItemNotFound e){
                nameErrors.add(new FunctionNotDeclared(identifier.getLine(), identifier.getName()));
            }
        } else if (isPatternMatchId) {
            try{
                SymbolTable.root.getItem(PatternItem.START_KEY + identifier.getName());
            }catch (ItemNotFound e){
                nameErrors.add(new PatternNotDeclared(identifier.getLine(), identifier.getName()));
            }

        } else{
            try{
                SymbolTable.top.getItem(VarItem.START_KEY + identifier.getName());
            }catch (ItemNotFound e){
                nameErrors.add(new VariableNotDeclared(identifier.getLine(), identifier.getName()));
            }
        }
        isFunctionCallId = false;
        isPatternMatchId = false;
        return null;
    }
    @Override
    public Void visit(VarDeclaration varDeclaration){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        VarItem varItem = new VarItem(varDeclaration.getName());
        try{
            currentScopeSymbolTable.put(varItem);
        }catch (ItemAlreadyExists ignored){

        }
        return null;
    }
    @Override
    public Void visit(FunctionDeclaration functionDeclaration){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        for(VarDeclaration varDeclaration : functionDeclaration.getArgs()){
            if(varDeclaration.getName().getName().equals(functionDeclaration.getFunctionName().getName())){
                nameErrors.add(new IdenticalArgFunctionName(varDeclaration.getLine(), varDeclaration.getName().getName()));
            }
            VarItem varItem = new VarItem(varDeclaration.getName());
            try{
                currentScopeSymbolTable.put(varItem);
            }catch (ItemAlreadyExists e){
                nameErrors.add(new DuplicateArg(varDeclaration.getLine(), varDeclaration.getName().getName()));
            }
        }
        SymbolTable.push(currentScopeSymbolTable);
        for(Statement statement : functionDeclaration.getBody()){
            statement.accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(PatternDeclaration patternDeclaration){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        if(patternDeclaration.getPatternName().getName().equals(patternDeclaration.getTargetVariable().getName())){
            nameErrors.add(new IdenticalArgPatternName(patternDeclaration.getTargetVariable().getLine(),
                            patternDeclaration.getTargetVariable().getName()));
        }
        VarItem varItem = new VarItem(patternDeclaration.getTargetVariable());
        try{
            currentScopeSymbolTable.put(varItem);
        }
        catch (ItemAlreadyExists ignored){

        }
        SymbolTable.push(currentScopeSymbolTable);
        for(Expression expression : patternDeclaration.getConditions()){
            expression.accept(this);
        }
        for(Expression expression : patternDeclaration.getReturnExp()){
            expression.accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(MainDeclaration mainDeclaration){
        for(Statement statement : mainDeclaration.getBody()){
            statement.accept(this);
        }
        return null;
    }
    @Override
    public Void visit(ReturnStatement returnStatement){
        if(returnStatement.hasRetExpression()){
            returnStatement.getReturnExp().accept(this);
        }
        return null;
    }
    @Override
    public Void visit(IfStatement ifStatement){
        for(Expression expression : ifStatement.getConditions()){
            expression.accept(this);
        }
        for(Statement statement : ifStatement.getThenBody()){
            statement.accept(this);
        }
        for(Statement statement : ifStatement.getElseBody()){
            statement.accept(this);
        }
        return null;
    }
    @Override
    public Void visit(PutStatement putStatement){
        putStatement.getExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(PushStatement pushStatement){
        pushStatement.getInitial().accept(this);
        pushStatement.getToBeAdded().accept(this);
        return null;
    }
    @Override
    public Void visit(LenStatement lenStatement){
        lenStatement.getExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(LoopDoStatement loopDoStatement){
        for(Statement statement : loopDoStatement.getLoopBodyStmts()){
            statement.accept(this);
        }
        for(Expression expression : loopDoStatement.getLoopConditions()){
            expression.accept(this);
        }
        if(loopDoStatement.getLoopRetStmt() != null){
            loopDoStatement.getLoopRetStmt().accept(this);
        }
        return null;
    }
    @Override
    public Void visit(ForStatement forStatement){
        SymbolTable currenctScopeSymbolTable = SymbolTable.top;
        VarItem varItem = new VarItem(forStatement.getIteratorId());
        try{
            currenctScopeSymbolTable.put(varItem);
        }catch (ItemAlreadyExists ignored){

        }
        SymbolTable.push(currenctScopeSymbolTable);
        for(Expression expression : forStatement.getRangeExpressions()){
            expression.accept(this);
        }
        for(Statement statement : forStatement.getLoopBody()){
            statement.accept(this);
        }
        for(Expression expression : forStatement.getLoopBodyExpressions()){
            expression.accept(this);
        }
        if(forStatement.getReturnStatement() != null){
            forStatement.getReturnStatement().accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(FilterStatement filterStatement){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        VarItem varItem = new VarItem(filterStatement.getIteratorId());
        try{
            currentScopeSymbolTable.put(varItem);
        }catch (ItemAlreadyExists ignored){

        }
        SymbolTable.push(currentScopeSymbolTable);
        filterStatement.getFilterExpression().accept(this);
        for(Expression expression : filterStatement.getRangeExpressions()){
            expression.accept(this);
        }
        for(Expression expression : filterStatement.getConditionalExpressions()){
            expression.accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(MatchPatternStatement matchPatternStatement){
        isPatternMatchId = true;
        matchPatternStatement.getPatternId().accept(this);
        matchPatternStatement.getMatchArgument().accept(this);
        return null;
    }
    @Override
    public Void visit(ChompStatement chompStatement){
        chompStatement.getChompExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(ChopStatement chopStatement){
        chopStatement.getChopExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(AssignStatement assignStatement){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        VarItem varItem = new VarItem(assignStatement.getAssignedId());
        try{
            currentScopeSymbolTable.put(varItem);
        }catch (ItemAlreadyExists ignored){

        }
        SymbolTable.push(currentScopeSymbolTable);
        assignStatement.getAssignExpression().accept(this);
        if(assignStatement.isAccessList()){
            assignStatement.getAccessListExpression().accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(ExpressionStatement expressionStatement){
        expressionStatement.getExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(AppendExpression appendExpression){
        appendExpression.getAppendee().accept(this);
        for(Expression expression : appendExpression.getAppendeds()){
            expression.accept(this);
        }
        return null;
    }
    @Override
    public Void visit(BinaryExpression binaryExpression){
        binaryExpression.getFirstOperand().accept(this);
        binaryExpression.getSecondOperand().accept(this);
        return null;
    }
    @Override
    public Void visit(UnaryExpression unaryExpression){
        unaryExpression.getExpression().accept(this);
        return null;
    }
    @Override
    public Void visit(AccessExpression accessExpression){
        int minArgRequired = 0;
        int maxArgRequired = 0;
        if(accessExpression.isFunctionCall()){
            isFunctionCallId = true;
            accessExpression.getAccessedExpression().accept(this);
            Identifier functionName = (Identifier) accessExpression.getAccessedExpression();
            try{
                FunctionItem functionItem = (FunctionItem) SymbolTable.root.getItem(FunctionItem.START_KEY + functionName.getName());
                maxArgRequired = functionItem.getFunctionDeclaration().getArgs().size();
                for(VarDeclaration varDeclaration : functionItem.getFunctionDeclaration().getArgs()){
                    if(varDeclaration.getDefaultVal() != null){
                        minArgRequired += 1;
                    }
                }
                minArgRequired = maxArgRequired - minArgRequired;
            }catch (ItemNotFound ignored){}

        }
        else{
            accessExpression.getAccessedExpression().accept(this);
        }
        int numberOfProvidedArgs = 0;
        for(Expression expression : accessExpression.getArguments()){
            numberOfProvidedArgs += 1;
            expression.accept(this);
        }
        if((numberOfProvidedArgs < minArgRequired) || (numberOfProvidedArgs > maxArgRequired)){
            Identifier functionName = (Identifier) accessExpression.getAccessedExpression();
            nameErrors.add(new ArgMisMatch(accessExpression.getLine(), functionName.getName()));
        }
        for(Expression expression : accessExpression.getDimentionalAccess()){
            expression.accept(this);
        }
        return null;
    }
    @Override
    public Void visit(LambdaExpression lambdaExpression){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        for(VarDeclaration varDeclaration : lambdaExpression.getDeclarationArgs()){
            VarItem varItem = new VarItem(varDeclaration.getName());
            try{
                currentScopeSymbolTable.put(varItem);
            }catch (ItemAlreadyExists e){
                nameErrors.add(new DuplicateArg(varDeclaration.getLine(), varDeclaration.getName().getName()));
            }
        }
        SymbolTable.push(currentScopeSymbolTable);
        for(Statement statement : lambdaExpression.getBody()){
            statement.accept(this);
        }
        for(Expression expression : lambdaExpression.getArgs()){
            expression.accept(this);
        }
        SymbolTable.pop();
        return null;
    }
    @Override
    public Void visit(ListValue listValue){
        for(Expression expression : listValue.getElements()){
            expression.accept(this);
        }
        return null;
    }
    @Override
    public Void visit(FunctionPointer functionPointer){
        SymbolTable currentScopeSymbolTable = SymbolTable.top;
        VarItem varItem = new VarItem(functionPointer.getId());
        try {
            currentScopeSymbolTable.put(varItem);
        }catch (ItemAlreadyExists ignored){

        }
        return null;
    }
    @Override
    public Void visit(BoolValue boolValue){
        return null;
    }
    @Override
    public Void visit(IntValue intValue){
        return null;
    }
    @Override
    public Void visit(StringValue stringValue){return null;}
    @Override
    public Void visit(FloatValue floatValue){return null;}

}
