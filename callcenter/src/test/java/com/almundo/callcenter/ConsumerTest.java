package com.almundo.callcenter;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.model.EmployeeModel;

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
	public synchronized void run() {
        try {
            if (this.dispatcher.getBlockingQueueCalls().size() > 0) {
            	CallModel currentCall = this.dispatcher.getBlockingQueueCalls().take();
                logger.debug("<<< Consuming call ", currentCall);
            	long timeProcess = this.dispatcher.buildRandomTime();
            	Thread.sleep(TimeUnit.SECONDS.toMillis(timeProcess));
            	EmployeeModel employee = currentCall.getEmployeeManager();
            	if(employee != null) {
            		logger.debug(">>> addAvailableEmployee ", currentCall);
            		this.dispatcher.addAvailableEmployee(employee);
            	}
            }
            logger.debug("--> stopped process.");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
		
	}

}
