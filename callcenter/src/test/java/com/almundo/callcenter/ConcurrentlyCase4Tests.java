package com.almundo.callcenter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

/**
 * The Class ConcurrentlyCase4Tests.
 */
public class ConcurrentlyCase4Tests {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConcurrentlyCase4Tests.class);
	
	/**
	 * Load the employee list.
	 *
	 * @return the sets the
	 */
	private Set<EmployeeModel> loadTheEmployeeList1() {
		Set<EmployeeModel> employeeListResult = new HashSet<>();
		//employees
		for (int i = 0; i < 20; i++) {
			employeeListResult.add(new EmployeeModel(i, EmployeeType.OPERATOR, "Employee " + i));
		}
		//supervisors
		for (int i = 21; i < 30; i++) {
			employeeListResult.add(new EmployeeModel(i, EmployeeType.SUPERVISOR, "Employee " + i));
		}
		//directors
		for (int i = 31; i < 40; i++) {
			employeeListResult.add(new EmployeeModel(i, EmployeeType.DIRECTOR, "Employee " + i));
		}
		return employeeListResult;
	}
	
	/**
	 * NOTE: El método dispatchCall puede invocarse por varios hilos al mismo tiempo.
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws CallcenterException 
	 */
	@Test()
	public void concurrentTest() throws InterruptedException, CallcenterException {
		Dispatcher dispatcher = new Dispatcher(loadTheEmployeeList1());
		ProducerTest p1 = new ProducerTest(dispatcher, 0, 10);
		ProducerTest p2 = new ProducerTest(dispatcher, 11, 30);
		ProducerTest p3 = new ProducerTest(dispatcher, 31, 45);
		ConsumerTest c1 = new ConsumerTest(dispatcher);
		ConsumerTest c2 = new ConsumerTest(dispatcher);
		logger.debug("Producer and Consumer has been started");
		//starting concurrently producer
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		new Thread(c1).start();
		new Thread(c2).start();
		TimeUnit.SECONDS.sleep(10);
		Assert.assertTrue(dispatcher.getAllAvailableEmployees().size() == 0, "All employees must be employed");
		Assert.assertTrue(dispatcher.getAvailableEmployee() == null, "Must be without employees");
		Assert.assertTrue(dispatcher.getBlockingQueueCalls().size() == 0, "40 calls are consumed for 40 available employees");
		Assert.assertTrue(dispatcher.getBlockingQueueCallWaiting().size() == 5, "returns 5 calls on hold");
	}
	

}
