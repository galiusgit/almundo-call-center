package com.almundo.callcenter;

import com.almundo.callcenter.exception.CallcenterException;
import com.almundo.callcenter.manager.impl.Dispatcher;

public class ProducerTest implements Runnable {

	private Dispatcher dispatcher;
	
	private Integer startReference;
	
	private Integer endRefenrece;


	public ProducerTest(Dispatcher dispatcher, Integer startReference, Integer endRefenrece) {
		super();
		this.dispatcher = dispatcher;
		this.startReference = startReference;
		this.endRefenrece = endRefenrece;
	}

	@Override
	public void run() {
		for (int i = this.startReference; i < this.endRefenrece; i++) {
			System.out.println("Init the: " + i);
			try {
				//Thread.sleep(i);
				this.dispatcher.dispatchCall("Call " + i);
			} catch (CallcenterException e) {
				e.printStackTrace();
			}
		}
	}

}
