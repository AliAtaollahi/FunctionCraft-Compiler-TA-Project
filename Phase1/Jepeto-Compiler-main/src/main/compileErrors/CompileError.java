package main.compileErrors;

public class CompileError extends Exception {
    private int line;
    protected String message;

    public CompileError(int line) {
        this.line = line;
    }

    public String getMessage() {
        return "Line " + line + ": " + message;
    }
}
