package br.com.teste.patrimonio.exception;

public class UsuarioNotFoundException extends Exception{

	private static final long serialVersionUID = 8690332320059695744L;

	public UsuarioNotFoundException() {
		super();
	}

	public UsuarioNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public UsuarioNotFoundException(String message) {
		super(message);

	}

	public UsuarioNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
