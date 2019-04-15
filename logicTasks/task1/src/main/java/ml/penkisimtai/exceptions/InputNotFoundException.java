package ml.penkisimtai.exceptions;

public class InputNotFoundException extends RuntimeException {
    public InputNotFoundException(Long id) {
        super("Could not find input " + id);
    }
}
