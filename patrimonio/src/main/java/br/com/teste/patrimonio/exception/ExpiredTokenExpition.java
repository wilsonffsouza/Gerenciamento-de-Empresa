package br.com.teste.patrimonio.exception;

public class ExpiredTokenExpition extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3733376566840343289L;

	public ExpiredTokenExpition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpiredTokenExpition(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExpiredTokenExpition(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExpiredTokenExpition(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExpiredTokenExpition(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
