package com.almundo.callcenter.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class SequenceUtil.
 * 
 * @version 0.0.1
 */
public class SequenceUtil {

	/** The Constant counter. */
	private static final AtomicInteger counter = new AtomicInteger();

	/**
	 * Next value.
	 *
	 * @return the integer
	 */
	public static Integer nextValue() {
		return counter.getAndIncrement();
	}

}
