package com.almundo.callcenter.semaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CallProcess.
 */
public class CallProcess extends Thread{
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CallProcess.class);

    /** The stand by message. */
    CyclicBarrier cyclicBarrier;
    
    /** The quotas. */
    private Semaphore quotas;
 
    /**
     * Instantiates a new call process.
     *
     * @param quotas the quotas
     * @param standByMessage the stand by message
     * @param employeeName the employee name
     */
    public CallProcess(Semaphore quotas, CyclicBarrier cyclicBarrier,
            String employeeName) {
        this.cyclicBarrier = cyclicBarrier;
        this.quotas = quotas;
        this.setName(employeeName);
        this.start();
    }
 
    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        // random 5, 10
        long secondsDuration = ThreadLocalRandom.current().nextLong(5,10);
        try {
 
        	logger.debug("call thread: " + getName());
 
            cyclicBarrier.await();
 
            quotas.acquire();
 
            logger.debug("occupying call thread: " + getName());
                        //using TimeUnit enumeration to make the code more readable
            Thread.sleep(TimeUnit.SECONDS.toMillis(secondsDuration));
             
            logger.debug("release ending" + getName());
            quotas.release();
             
            logger.debug("---> Available quotas: " + quotas.availablePermits());
             
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } 
 
    }
}
