package org.com.onlinewallet.exception;

public class InvalidAccountException extends Exception{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	

	public InvalidAccountException(String str) {
		super(str);
	}
}
