package com.almundo.callcenter.manager.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.almundo.callcenter.manager.IDispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Dispatcher implements IDispatcher{
	
	private static final Logger logger = LoggerFactory.getLogger(Dispatcher.class);
	
	public static final Integer MAX_available_CALLS = 10;
	
	private BlockingQueue<CallModel> blockingQueueCalls;
	
	private Set<EmployeeModel> employeeList = new HashSet<>();
	
	ObjectMapper objectMapper = new ObjectMapper();

	public Dispatcher() throws JsonParseException, JsonMappingException, IOException {
		this.loadTheEmployeeList();
		this.blockingQueueCalls = new LinkedBlockingDeque<>(MAX_available_CALLS);
	}

	@Override
	public void dispatchCall() {
		// TODO Auto-generated method stub
		System.out.println("-------> dispatchCall");
		
	}
	
	private void loadTheEmployeeList() throws JsonParseException, JsonMappingException, IOException {
		this.employeeList = new HashSet<>();
		//this.employeeList.add(arg0);
		//InputStream is = this.getClass().getResourceAsStream("/static/employee-list.json");
		//String jsonCarArray = "[\\r\\n{\\r\\n\\t\\\"id\\\": 1,\\r\\n\\t\\\"type\\\": \\\"OPERATOR\\\",\\r\\n\\t\\\"isAvailable\\\": true,\\r\\n\\t\\\"currentCall\\\": null\\r\\n},\\r\\n{\\r\\n\\t\\\"id\\\": 2,\\r\\n\\t\\\"type\\\": \\\"OPERATOR\\\",\\r\\n\\t\\\"isAvailable\\\": true,\\r\\n\\t\\\"currentCall\\\": null\\r\\n}\\r\\n]";
		//Set<EmployeeModel> listCar = objectMapper.readValue(is, new TypeReference<Set<EmployeeModel>>(){});
		
		//TODO continuar con lectura de ojetos luego
		/*Set<EmployeeModel> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<Set<EmployeeModel>>(){});
		listCar.size();*/
		
		//10 operadores
		this.employeeList.add(new EmployeeModel(1, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(2, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(3, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(4, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(5, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(6, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(7, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(8, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(9, EmployeeType.OPERATOR, true, null));
		this.employeeList.add(new EmployeeModel(10, EmployeeType.OPERATOR, true, null));
		//4 supervisores
		this.employeeList.add(new EmployeeModel(11, EmployeeType.SUPERVISOR, true, null));
		this.employeeList.add(new EmployeeModel(12, EmployeeType.SUPERVISOR, true, null));
		this.employeeList.add(new EmployeeModel(13, EmployeeType.SUPERVISOR, true, null));
		this.employeeList.add(new EmployeeModel(14, EmployeeType.SUPERVISOR, true, null));
		//2 directores
		this.employeeList.add(new EmployeeModel(15, EmployeeType.DIRECTOR, true, null));
		this.employeeList.add(new EmployeeModel(16, EmployeeType.DIRECTOR, true, null));
	}
	
	private Set<EmployeeModel> getEmployees() {
		return this.employeeList;
	}
	
	private void validarPrioridadDeEmpleadosDisponibles() {
		
	}
	
	private void liberarEmploeado() {
		
	}
	
	private void agregarEmpleado() {
		
	}
	
	private EmployeeModel getAvailableEmployee() {
		return null;
	}

}
