package com.almundo.callcenter.manager.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.IDispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.model.EmployeeModel;
import com.almundo.callcenter.model.EmployeeType;
import com.almundo.callcenter.util.SequenceUtil;

/**
 * The Class Dispatcher.
 * 
 * NOTE: Debe existir una clase Dispatcher encargada de manejar las 
 * llamadas, y debe contener el método dispatchCall para que las 
 * asigne a los empleados disponibles.
 *  
 */
@Component
public class Dispatcher implements IDispatcher {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(Dispatcher.class);

	/** The Constant MAX_AVAILABLE_CALLS. */
	public static final Integer MAX_AVAILABLE_CALLS = 10;

	/** The blocking queue calls. */
	private BlockingQueue<CallModel> blockingQueueCalls;

	/** The blocking queue call waiting. */
	private BlockingQueue<CallModel> blockingQueueCallWaiting;

	/** The blocking queue operator employees. */
	private BlockingQueue<EmployeeModel> blockingQueueOperatorEmployees;

	/** The blocking queue supervisor employees. */
	private BlockingQueue<EmployeeModel> blockingQueueSupervisorEmployees;

	/** The blocking queue director employees. */
	private BlockingQueue<EmployeeModel> blockingQueueDirectorEmployees;

	/** The random. */
	private Random random;

	/**
	 * Instantiates a new dispatcher.
	 *
	 * @param employeeList the employee list
	 * @throws CallcenterException the callcenter exception
	 */
	public Dispatcher(Set<EmployeeModel> employeeList) throws CallcenterException {
		if (employeeList == null) {
			throw new CallcenterException("The EmployeeList cannot be null");
		}

		Set<EmployeeModel> operatorEmployeeList = employeeList.stream()
				.filter(e -> EmployeeType.OPERATOR.equals(e.getType())).collect(Collectors.toSet());
		if (operatorEmployeeList != null) {
			this.blockingQueueOperatorEmployees = new LinkedBlockingQueue<>(operatorEmployeeList);
		}

		Set<EmployeeModel> supervisorEmployeeList = employeeList.stream()
				.filter(e -> EmployeeType.SUPERVISOR.equals(e.getType())).collect(Collectors.toSet());
		if (supervisorEmployeeList != null) {
			this.blockingQueueSupervisorEmployees = new LinkedBlockingQueue<>(supervisorEmployeeList);
		}

		Set<EmployeeModel> directorEmployeeList = employeeList.stream()
				.filter(e -> EmployeeType.DIRECTOR.equals(e.getType())).collect(Collectors.toSet());
		if (directorEmployeeList != null) {
			this.blockingQueueDirectorEmployees = new LinkedBlockingQueue<>(directorEmployeeList);
		}

		this.blockingQueueCalls = new LinkedBlockingQueue<>(MAX_AVAILABLE_CALLS);
		this.blockingQueueCallWaiting = new LinkedBlockingQueue<>(MAX_AVAILABLE_CALLS);
		this.random = new Random();
	}

	/**
	 * Debe existir una clase Dispatcher encargada de manejar las llamadas, y debe
	 * contener el método dispatchCall para que las asigne a los empleados
	 * disponibles.
	 *
	 * @param reference the reference
	 * @return the call model
	 * @throws CallcenterException the callcenter exception
	 */
	@Override
	public CallModel dispatchCall(String reference) throws CallcenterException {
		if (reference == null) {
			throw new CallcenterException("The reference cannot be null");
		}

		CallModel callModel = new CallModel(buildConsecutiveCallId(), buildRandomTime(), reference);

		try {
			// adds the employee manager
			EmployeeModel employeeManager = getAvailableEmployee();
			if(employeeManager == null) {
				logger.error("There are no available employees");
				System.out.println("There are no available employees");
				return dispatchWaitingCall(callModel);
			}
			callModel.setEmployeeManager(employeeManager);
			this.blockingQueueCalls.offer(callModel, callModel.getSecondsTimeLife(), TimeUnit.SECONDS);
			//TODO: remover esto
			System.out.println("----> Consumed: " + callModel.getReference() + ", "
					+ callModel.getEmployeeManager().getName() + ", type: " 
					+ callModel.getEmployeeManager().getType().name());
			return callModel;
		} catch (IllegalStateException e1) {
			// added to waiting call
			logger.error("The process is not available by concurrency", e1);
			System.out.println("The process is not available by concurrency");
			throw new CallcenterException("The process is not available by concurrency", e1);
			
		}  catch (InterruptedException e2) {
			logger.error("An error occurred when trying to obtain the employee", e2);
			System.out.println("An error occurred when trying to obtain the employee");
			return dispatchWaitingCall(callModel);
		}
	}

	/**
	 * Dispatch waiting call.
	 *
	 * @param callModel the call model
	 * @return the call model
	 * @throws CallcenterException the callcenter exception
	 */
	private CallModel dispatchWaitingCall(CallModel callModel) throws CallcenterException {
		try {
			this.blockingQueueCallWaiting.offer(callModel, callModel.getSecondsTimeLife(), TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new CallcenterException("The process is not available by concurrency", e);
		}
		return callModel;
	}

	/**
	 * There are available employees.
	 *
	 * @return true, if successful
	 */
	private boolean thereAreAvailableEmployees() {
		return (this.blockingQueueOperatorEmployees.size() > 0 || this.blockingQueueSupervisorEmployees.size() > 0
				|| this.blockingQueueDirectorEmployees.size() > 0);
	}

	/**
	 * Builds the consecutive call id.
	 *
	 * @return the integer
	 */
	public Integer buildConsecutiveCallId() {
		return SequenceUtil.nextValue();
	}

	/**
	 * Builds the random time.
	 *
	 * @return the long
	 */
	public long buildRandomTime() {
		return this.random.nextBoolean() ? 5 : 10;
	}

	/**
	 * Gets the available employee.
	 *
	 * @return the available employee
	 * @throws InterruptedException the interrupted exception
	 */
	public EmployeeModel getAvailableEmployee() throws InterruptedException {
		if (!thereAreAvailableEmployees()) {
			return null;
		}
		if (!this.blockingQueueOperatorEmployees.isEmpty()) {
			// returns the operator employee available
			return this.blockingQueueOperatorEmployees.take();
		} else if (!this.blockingQueueSupervisorEmployees.isEmpty()) {
			// returns the supervisor employee available
			return this.blockingQueueSupervisorEmployees.take();
		} else if (!this.blockingQueueDirectorEmployees.isEmpty()) {
			return this.blockingQueueDirectorEmployees.take();
		}
		return null;
	}

	/**
	 * Gets the blocking queue calls.
	 *
	 * @return the blocking queue calls
	 */
	public BlockingQueue<CallModel> getBlockingQueueCalls() {
		return blockingQueueCalls;
	}

	/**
	 * Gets the blocking queue call waiting.
	 *
	 * @return the blocking queue call waiting
	 */
	public BlockingQueue<CallModel> getBlockingQueueCallWaiting() {
		return blockingQueueCallWaiting;
	}
	
	/**
	 * Gets the all available employees.
	 *
	 * @return the all available employees
	 */
	public Set<EmployeeModel> getAllAvailableEmployees() {
		Set<EmployeeModel> employeeListResult = new HashSet<>();
		employeeListResult.addAll(this.blockingQueueOperatorEmployees);
		employeeListResult.addAll(this.blockingQueueSupervisorEmployees);
		employeeListResult.addAll(this.blockingQueueDirectorEmployees);
		return employeeListResult;
	}

}
