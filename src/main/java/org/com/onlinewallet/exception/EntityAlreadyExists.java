package org.com.onlinewallet.exception;

/**
 * 
 * EntityAlreadyExists
 *
 */
public class EntityAlreadyExists extends RuntimeException {
	/**
	 * 
	 * @param msg
	 */

	public EntityAlreadyExists(String msg) {
		super(msg);
	}

}
