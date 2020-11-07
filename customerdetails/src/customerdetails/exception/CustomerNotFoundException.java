package customerdetails.exception;

public class CustomerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -8640609886084977390L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
