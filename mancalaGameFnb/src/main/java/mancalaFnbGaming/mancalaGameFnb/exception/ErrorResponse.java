package mancalaFnbGaming.mancalaGameFnb.exception;

/**
 * Class for building error response
 */
public class ErrorResponse {
	private String message;
	private String internalErrorCode;

	public ErrorResponse(String message, String internalErrorCode) {
		super();
		this.message = message;
		this.internalErrorCode = internalErrorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInternalErrorCode() {
		return internalErrorCode;
	}

	public void setInternalErrorCode(String internalErrorCode) {
		this.internalErrorCode = internalErrorCode;
	}

}
