package com.almundo.callcenter.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class StandByCall.
 */
public class StandByCall implements Runnable {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CallCenterRunTest.class);
	 
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
    	logger.debug("Call waiting...");
    }
 
}