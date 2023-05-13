package mancalaFnbGaming.mancalaGameFnb.exception;


/**
 * Exception class for game not found case
 */
public class GameNotFoundException extends RuntimeException {

    private String errorCode;
    private String message;
    
    
	public GameNotFoundException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
