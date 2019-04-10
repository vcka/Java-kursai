package ml.penkisimtai.exceptions;

public class UnauthorizedActionException extends QuizZzException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedActionException() {
		super();
	}

	public UnauthorizedActionException(String message) {
		super(message);
	}
}
