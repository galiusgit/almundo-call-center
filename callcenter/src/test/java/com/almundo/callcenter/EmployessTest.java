package com.almundo.callcenter;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

/**
 * The Class EmployessTest.
 */
public class EmployessTest {
	
	/**
	 * Gets the employees for case 1.
	 *
	 * @return the employees for case 1
	 */
	private Set<EmployeeModel> getEmployeesForCase1(){
		Set<EmployeeModel> employeeListTest1 = new HashSet<>();
		employeeListTest1.add(new EmployeeModel(1, EmployeeType.OPERATOR, "Employee 1"));
		return employeeListTest1;
	}
	
	/**
	 * Gets the employees for case 2.
	 *
	 * @return the employees for case 2
	 */
	private Set<EmployeeModel> getEmployeesForCase2(){
		Set<EmployeeModel> employeeListTest2 = new HashSet<>();
		employeeListTest2.add(new EmployeeModel(11, EmployeeType.SUPERVISOR, "Employee 11"));
		employeeListTest2.add(new EmployeeModel(15, EmployeeType.DIRECTOR, "Employee 15"));
		return employeeListTest2;
	}
	
	/**
	 * Gets the employees for case 3.
	 *
	 * @return the employees for case 3
	 */
	private Set<EmployeeModel> getEmployeesForCase3(){
		Set<EmployeeModel> employeeListTest3 = new HashSet<>();
		employeeListTest3.add(new EmployeeModel(15, EmployeeType.DIRECTOR, "Employee 15"));
		return employeeListTest3;
	}
	
	/**
	 * Gets the employees for case 4.
	 *
	 * @return the employees for case 4
	 */
	private Set<EmployeeModel> getEmployeesForCase4(){
		Set<EmployeeModel> employeeListTest4 = new HashSet<>();
		return employeeListTest4;
	}
	
	
	/**
	 * Prioridad atencion 2.
	 *
	 * @throws CallcenterException the callcenter exception
	 * @throws InterruptedException the interrupted exception
	 */
	@Test
	public void prioridadAtencion2() throws CallcenterException, InterruptedException {
		// 1) operator
		Dispatcher dispatcher1 = new Dispatcher(this.getEmployeesForCase1());
		EmployeeModel e1 = dispatcher1.getAvailableEmployee();
		Integer expectedId1 = 1;
		Assert.assertEquals(e1.getId(), expectedId1);
		// 2) supervisor
		Dispatcher dispatcher2 = new Dispatcher(this.getEmployeesForCase2());
		EmployeeModel e2 = dispatcher2.getAvailableEmployee();
		Integer expectedId2 = 11;
		Assert.assertEquals(e2.getId(), expectedId2);
		// 3) director
		Dispatcher dispatcher3 = new Dispatcher(this.getEmployeesForCase3());
		EmployeeModel e3 = dispatcher3.getAvailableEmployee();
		Integer expectedId3 = 15;
		Assert.assertEquals(e3.getId(), expectedId3);
		// 4) null
		Dispatcher dispatcher4 = new Dispatcher(this.getEmployeesForCase4());
		EmployeeModel e4 = dispatcher4.getAvailableEmployee();
		Assert.assertNull(e4);
	}

}
