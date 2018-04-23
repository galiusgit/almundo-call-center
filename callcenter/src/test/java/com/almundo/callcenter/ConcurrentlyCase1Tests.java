package com.almundo.callcenter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

public class ConcurrentlyCase1Tests {
	
	/**
	 * Load the employee list.
	 *
	 * @return the sets the
	 */
	private Set<EmployeeModel> loadTheEmployeeList1() {
		Set<EmployeeModel> employeeListResult = new HashSet<>();
		//10 employees
		employeeListResult.add(new EmployeeModel(1, EmployeeType.OPERATOR, "Employee 1"));
		employeeListResult.add(new EmployeeModel(2, EmployeeType.OPERATOR, "Employee 2"));
		employeeListResult.add(new EmployeeModel(3, EmployeeType.OPERATOR, "Employee 3"));
		employeeListResult.add(new EmployeeModel(4, EmployeeType.OPERATOR, "Employee 4"));
		employeeListResult.add(new EmployeeModel(5, EmployeeType.OPERATOR, "Employee 5"));
		employeeListResult.add(new EmployeeModel(6, EmployeeType.OPERATOR, "Employee 6"));
		employeeListResult.add(new EmployeeModel(7, EmployeeType.OPERATOR, "Employee 7"));
		employeeListResult.add(new EmployeeModel(8, EmployeeType.OPERATOR, "Employee 8"));
		employeeListResult.add(new EmployeeModel(9, EmployeeType.OPERATOR, "Employee 9"));
		employeeListResult.add(new EmployeeModel(10, EmployeeType.OPERATOR, "Employee 10"));
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
		Dispatcher dispatcher = new Dispatcher(loadTheEmployeeList1());
		ProducerTest p1 = new ProducerTest(dispatcher, 0, 10);
		//starting concurrently producer
		new Thread(p1).start();
        System.out.println("Producer and Consumer has been started");
		
		TimeUnit.SECONDS.sleep(2);
		Assert.assertTrue(dispatcher.getBlockingQueueCalls().size() == 10);
        Assert.assertTrue(dispatcher.getAllAvailableEmployees().size() == 6);
	}
	

}
