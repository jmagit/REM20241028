package com.example.ioc.basico;

import org.springframework.stereotype.Service;

@Service
public class ServicioMockImpl implements Servicio {
	
	public ServicioMockImpl() {
		System.err.println(getClass().getSimpleName() + " Constructor");
	}


	@Override
	public void add() {
		System.err.println("doble de pruebas");	
	}

}
