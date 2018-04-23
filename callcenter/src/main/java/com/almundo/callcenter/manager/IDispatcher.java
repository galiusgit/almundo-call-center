package com.almundo.callcenter.manager;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.model.CallModel;

/**
 * The Interface IDispatcher.
 */
public interface IDispatcher {

	/**
	 * Dispatch call.
	 *
	 * @param reference the reference
	 * @return the call model
	 * @throws CallcenterException the callcenter exception
	 */
	CallModel dispatchCall(String reference) throws CallcenterException;
	
}
