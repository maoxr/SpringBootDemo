/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.exception 
 * @author: ibadboy   
 * @date: 2018年6月27日 上午11:06:39 
 */
package com.momo.springboot.exception;

/**
 * @ClassName: com.momo.springboot.exception.MyException
 * @Description: TODO
 * @author ibadboy
 * @date: 2018年6月27日 上午11:06:39
 */
public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
		super(message);
	}
}
