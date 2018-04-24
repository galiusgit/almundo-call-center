package com.almundo.callcenter.semaphore;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CallCenterRun.
 * Example call semaphore
 */
public class CallCenterRun {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CallCenterRun.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {
        
        Semaphore quota = new Semaphore(10);
         
        CyclicBarrier standbyMessage = new CyclicBarrier(10, new StandByCall());
        
        logger.debug("quotas: " + quota.availablePermits());
        logger.debug("----------------------------------");
        
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));

		new CallProcess(quota, standbyMessage, "1 Call");
        new CallProcess(quota, standbyMessage, "2 Call");
        new CallProcess(quota, standbyMessage, "3 Call");
        new CallProcess(quota, standbyMessage, "4 Call");
        new CallProcess(quota, standbyMessage, "5 Call");
        new CallProcess(quota, standbyMessage, "6 Call");
        new CallProcess(quota, standbyMessage, "7 Call");
        new CallProcess(quota, standbyMessage, "8 Call");
        new CallProcess(quota, standbyMessage, "9 Call");
        new CallProcess(quota, standbyMessage, "10 Call");
        new CallProcess(quota, standbyMessage, "11 Call");
        new CallProcess(quota, standbyMessage, "12 Call");
        new CallProcess(quota, standbyMessage, "13 Call");
        new CallProcess(quota, standbyMessage, "14 Call");
        new CallProcess(quota, standbyMessage, "15 Call");
    }

}
