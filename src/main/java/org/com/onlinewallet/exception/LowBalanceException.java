package org.com.onlinewallet.exception;

public class LowBalanceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LowBalanceException(String str) {
		super(str);
	}

}
