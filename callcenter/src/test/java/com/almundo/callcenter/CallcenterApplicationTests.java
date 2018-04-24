package com.almundo.callcenter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

/**
 * The Class CallcenterApplicationTests with spring boot test manager.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CallcenterApplicationTests {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ConcurrentlyCase1Tests.class);
	
	/** The dispatcher. */
	@Autowired
	Dispatcher dispatcher;
	
	/**
	 * Employee list. Builds the bean for dispatcher
	 *
	 * @return the sets the
	 */
	@Bean
    public Set<EmployeeModel> employeeList() {
        return loadTheEmployeeList0();
    }
	
	/**
	 * Load the employee list.
	 *
	 * @return the sets the
	 */
	private Set<EmployeeModel> loadTheEmployeeList0() {
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
	 * Dispatch call employee list null.
	 *
	 * @throws CallcenterException the callcenter exception
	 */
	@Test(expected = CallcenterException.class)
	public void dispatchCall_employeeList_null() throws CallcenterException {
		dispatcher.dispatchCall(null);
	}
	
	/**
	 * Dispatch call case 1.
	 *
	 * @throws CallcenterException the callcenter exception
	 */
	@Test()
	public void dispatchCall_case1() throws CallcenterException {
		dispatcher.dispatchCall("Call 1");
		
		BlockingQueue<CallModel> bqCalls1 = dispatcher.getBlockingQueueCalls();
		Set<EmployeeModel> bqEmp1 = dispatcher.getAllAvailableEmployees();
		
		Assert.assertTrue(bqCalls1.size() == 1);
		Assert.assertTrue(bqEmp1.size() == 15);
	}
	
	
	/**
	 * NOTE: Cada llamada puede durar un tiempo aleatorio entre 5 y 10 segundos.
	 * 
	 * Choose between 2 defined numbers (5, 10) randomly
	 */
	@Test
	public void buildRandomTime_between_2_defined_numbers(){
		long timeResult = dispatcher.buildRandomTime();
		logger.debug("random time: " + timeResult);
		Assert.assertTrue(timeResult >= 5 && timeResult <= 10);
		long timeResult1 = dispatcher.buildRandomTime();
		logger.debug("random time: " + timeResult1);
		Assert.assertTrue(timeResult >= 5 && timeResult <= 10);
	}
	

}
