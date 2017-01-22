
public enum AnsiEscapeCodes {
    RESET("\u001B[0m"), RED("\u001B[31m"), BLUE("\u001B[34m"), YELLOW("\u001B[33m");

    private String code;

    AnsiEscapeCodes(String code){this.code = code;}
    public String toString(){return code;}
}
