package com.almundo.callcenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.almundo.callcenter.manager.impl.Dispatcher;

public class CallcenterMainProcessTest {
	
	@Autowired
	Dispatcher dispatcher;
	
	@Test
	public void dispararLLamadas() {
		dispatcher.dispatchCall();
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
