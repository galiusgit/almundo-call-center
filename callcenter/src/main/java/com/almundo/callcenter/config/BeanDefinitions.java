package com.almundo.callcenter.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

/**
 * The Class BeanDefinitions.
 * 
 * @version 0.0.1
 */
@Configuration
public class BeanDefinitions {
	
	/**
	 * Employee list.
	 *
	 * @return the sets the
	 */
	@Bean
    public Set<EmployeeModel> employeeList() {
        return loadTheEmployeeList();
    }
	
	/**
	 * Load the employee list.
	 *
	 * @return the sets the
	 */
	private Set<EmployeeModel> loadTheEmployeeList() {
		Set<EmployeeModel> employeeListResult = new HashSet<>();
		//10 operators
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
}
