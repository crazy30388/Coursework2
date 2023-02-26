public class IncorrectArgumentException extends Exception {
    private String argument;

    public IncorrectArgumentException(String message) {
        super(message);
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return  argument;
    }
}
