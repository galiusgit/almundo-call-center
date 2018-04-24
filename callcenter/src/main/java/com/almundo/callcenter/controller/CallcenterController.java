package com.almundo.callcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.IDispatcher;
import com.almundo.callcenter.model.CallModel;
import com.almundo.callcenter.util.SequenceUtil;

/**
 * The Class CallcenterController.
 * 
 * @version 0.0.1
 */
@Controller("/api")
public class CallcenterController {
	
	/** The dispatcher. */
	IDispatcher dispatcher;
	
	/**
	 * Instantiates a new callcenter controller.
	 *
	 * @param dispatcher the dispatcher
	 */
	@Autowired
	public CallcenterController(IDispatcher dispatcher) {
		super();
		this.dispatcher = dispatcher;
	}
	
	/**
	 * Builds the call.
	 *
	 * @return the call model
	 * @throws CallcenterException the callcenter exception
	 */
	@RequestMapping(value = "/build-call", method = RequestMethod.GET)
	@ResponseBody
	public CallModel buildCall() throws CallcenterException {
		return this.dispatcher.dispatchCall("Web call" + SequenceUtil.nextValue().toString());
	};

}
