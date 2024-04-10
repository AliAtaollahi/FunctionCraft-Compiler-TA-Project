package main.compileError;

public class CompileError extends Exception{
    private int line;
    protected String errorMessage;
    public CompileError(int line, String errorMessage){
        this.line = line;
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return "Line " + this.line + " : " + this.errorMessage;
    }
}
