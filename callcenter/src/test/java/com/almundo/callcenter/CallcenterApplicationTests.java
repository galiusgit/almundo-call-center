package com.almundo.callcenter;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallcenterApplicationTests {
	
	@Autowired
	Dispatcher dispatcher;
	
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

	@Test(expected = CallcenterException.class)
	public void dispatchCall_employeeList_null() throws CallcenterException {
		dispatcher.dispatchCall(null);
	}
	
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
	 * Choose between 2 defined numbers (5, 10) randomly
	 */
	@Test
	public void buildRandomTime_between_2_defined_numbers(){
		long timeResult = dispatcher.buildRandomTime();
		Assert.assertTrue(timeResult == 5 || timeResult == 10);
		long timeResult1 = dispatcher.buildRandomTime();
		Assert.assertTrue(timeResult1 == 5 || timeResult1 == 10);
		long timeResult2 = dispatcher.buildRandomTime();
		Assert.assertTrue(timeResult2 == 5 || timeResult2 == 10);
		long timeResult3 = dispatcher.buildRandomTime();
		Assert.assertTrue(timeResult3 == 5 || timeResult3 == 10);
	}
	
	public void agregarEmpleadosDisponibles() {
		
	}
	
	//de modo concurrente
	public void procesar10llamadasAlmismoTiempo() {
		
	}
	
	public void duracionLlamadaAleatoriaEntre5y10Segundos() {

	}
	
	public void llegan10LLamadasAltiempo() {
		
	}
	
	public void quePasaCuandoNoHayEmpleadoLibre() {
		
	}
	
	public void quePasaCuandoLLeganMasDe10LLamadas() {
		
	}

	

}
