package exception;

public class InvalidContactInputException extends RuntimeException{

    public InvalidContactInputException(String message) {
        super(message);
    }
}
