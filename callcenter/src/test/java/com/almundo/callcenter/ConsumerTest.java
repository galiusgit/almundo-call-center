package com.almundo.callcenter;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.CallModel;

/**
 * The Class ConsumerTest.
 */
public class ConsumerTest implements Runnable {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConsumerTest.class);
	
	/** The dispatcher. */
	private Dispatcher dispatcher;

	/**
	 * Instantiates a new consumer test.
	 *
	 * @param dispatcher the dispatcher
	 */
	public ConsumerTest(Dispatcher dispatcher) {
		super();
		this.dispatcher = dispatcher;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
        try {
            while (true) {
            	long timeProcess = this.dispatcher.buildRandomTime();
                //CallModel currentCall = this.dispatcher.getBlockingQueueCalls().poll(timeProcess, TimeUnit.SECONDS);
                CallModel currentCall = this.dispatcher.getBlockingQueueCalls().take();
                if (currentCall == null) {
                    break;
                }
                logger.debug("<<< Consuming call ", currentCall);
                TimeUnit.SECONDS.sleep(timeProcess);
            }
            logger.debug("- stopped process.");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
		
	}

}
