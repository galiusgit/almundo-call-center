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

public class ConcurrentlyCase2Tests {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConcurrentlyCase2Tests.class);
	
	/**
	 * Load the employee list.
	 *
	 * @return the sets the
	 */
	private Set<EmployeeModel> loadTheEmployeeList2() {
		Set<EmployeeModel> employeeListResult = new HashSet<>();
		//4 operators
		employeeListResult.add(new EmployeeModel(1, EmployeeType.OPERATOR, "Employee 1"));
		employeeListResult.add(new EmployeeModel(2, EmployeeType.OPERATOR, "Employee 2"));
		employeeListResult.add(new EmployeeModel(3, EmployeeType.OPERATOR, "Employee 3"));
		employeeListResult.add(new EmployeeModel(4, EmployeeType.OPERATOR, "Employee 4"));
		//4 supervisors
		employeeListResult.add(new EmployeeModel(11, EmployeeType.SUPERVISOR, "Employee 11"));
		employeeListResult.add(new EmployeeModel(12, EmployeeType.SUPERVISOR, "Employee 12"));
		employeeListResult.add(new EmployeeModel(13, EmployeeType.SUPERVISOR, "Employee 13"));
		employeeListResult.add(new EmployeeModel(14, EmployeeType.SUPERVISOR, "Employee 14"));
		//2 directors
		employeeListResult.add(new EmployeeModel(15, EmployeeType.DIRECTOR, "Employee 15"));
		employeeListResult.add(new EmployeeModel(16, EmployeeType.DIRECTOR, "Employee 16"));
		return employeeListResult;
	}
	
	/**
	 * Concurrent test.
	 * 
	 * De 16 empleados toma 10;
	 *
	 * @throws InterruptedException the interrupted exception
	 * @throws CallcenterException 
	 */
	@Test()
	public void concurrentTest() throws InterruptedException, CallcenterException {
		
		Dispatcher dispatcher1 = new Dispatcher(loadTheEmployeeList2());
		
		ProducerTest p1 = new ProducerTest(dispatcher1, 0, 6);
		//starting concurrently producer
		new Thread(p1).start();
		logger.debug("Producer and Consumer has been started");
		
		TimeUnit.SECONDS.sleep(2);
		Assert.assertTrue(dispatcher1.getBlockingQueueCalls().size() == 6);
        Assert.assertTrue(dispatcher1.getAllAvailableEmployees().size() == 4);
	}
	

}
