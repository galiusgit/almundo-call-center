package com.almundo.callcenter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.almundo.callcenter.manager.impl.Dispatcher;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CallcenterApplicationTests {
	
	@Autowired
	Dispatcher dispatcher;

	@Test
	public void contextLoads() {
		dispatcher.dispatchCall();
	}
	
	
	private Set<EmployeeModel> loadTheEmployeeList() throws JsonParseException, JsonMappingException, IOException {
		Set<EmployeeModel> employeeList = new HashSet<>();
		//employeeList.add(arg0);
		//InputStream is = this.getClass().getResourceAsStream("/static/employee-list.json");
		//String jsonCarArray = "[\\r\\n{\\r\\n\\t\\\"id\\\": 1,\\r\\n\\t\\\"type\\\": \\\"OPERATOR\\\",\\r\\n\\t\\\"isAvailable\\\": true,\\r\\n\\t\\\"currentCall\\\": null\\r\\n},\\r\\n{\\r\\n\\t\\\"id\\\": 2,\\r\\n\\t\\\"type\\\": \\\"OPERATOR\\\",\\r\\n\\t\\\"isAvailable\\\": true,\\r\\n\\t\\\"currentCall\\\": null\\r\\n}\\r\\n]";
		//Set<EmployeeModel> listCar = objectMapper.readValue(is, new TypeReference<Set<EmployeeModel>>(){});
		
		//TODO continuar con lectura de ojetos luego
		/*Set<EmployeeModel> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<Set<EmployeeModel>>(){});
		listCar.size();*/
		
		//10 operadores
		employeeList.add(new EmployeeModel(1, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(2, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(3, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(4, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(5, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(6, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(7, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(8, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(9, EmployeeType.OPERATOR, true, null));
		employeeList.add(new EmployeeModel(10, EmployeeType.OPERATOR, true, null));
		//4 supervisores
		employeeList.add(new EmployeeModel(11, EmployeeType.SUPERVISOR, true, null));
		employeeList.add(new EmployeeModel(12, EmployeeType.SUPERVISOR, true, null));
		employeeList.add(new EmployeeModel(13, EmployeeType.SUPERVISOR, true, null));
		employeeList.add(new EmployeeModel(14, EmployeeType.SUPERVISOR, true, null));
		//2 directores
		employeeList.add(new EmployeeModel(15, EmployeeType.DIRECTOR, true, null));
		employeeList.add(new EmployeeModel(16, EmployeeType.DIRECTOR, true, null));
		return employeeList;
	}
	
	public void prioridadAtencion() {
		// 1) operador
		// 2) supervisor
		// 3) director
	}
	
	public void agregarEmpleadosDisponibles() {
		
	}
	
	public void dispararLlamadasVariosHilosAlTiempo() {
		
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
