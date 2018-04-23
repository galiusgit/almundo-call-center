package com.almundo.callcenter;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.CallModel;

/**
 * The Class ProducerTest.
 * Produces the automatic calls for the threads
 * 
 * @version 0.0.1
 */
public class ProducerTest implements Runnable {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProducerTest.class);

	/** The dispatcher. */
	private Dispatcher dispatcher;
	
	/** The start reference. */
	private Integer startReference;
	
	/** The end refenrece. */
	private Integer endRefenrece;

	/**
	 * Instantiates a new producer test.
	 *
	 * @param dispatcher the dispatcher
	 * @param startReference the start reference
	 * @param endRefenrece the end refenrece
	 */
	public ProducerTest(Dispatcher dispatcher, Integer startReference, Integer endRefenrece) {
		super();
		this.dispatcher = dispatcher;
		this.startReference = startReference;
		this.endRefenrece = endRefenrece;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = this.startReference; i < this.endRefenrece; i++) {
			logger.debug("Init call producere: " + i);
			try {
				//NOTE: sleep the process
				//Thread.sleep(i);
				this.dispatcher.dispatchCall("Call " + i);
			} catch (CallcenterException e1) {
				logger.error("Business exception", e1);
			}
		}
	}

}
