package mancalaFnbGaming.mancalaGameFnb.exception;

/**
 * Exception class for custom game api exceptions
 */

public class GameApiException extends RuntimeException {

	private String errorCode;
	private String message;

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
