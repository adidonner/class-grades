package app.core.exception;

public class SchoolSystemException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SchoolSystemException() {
	}
	
	public SchoolSystemException(String message) {
		super(message);
	}

	public SchoolSystemException(Throwable cause) {
		super(cause);
	}

	public SchoolSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SchoolSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


}
