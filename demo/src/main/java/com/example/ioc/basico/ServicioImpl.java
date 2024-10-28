package com.example.ioc.basico;

import org.springframework.stereotype.Service;

//@Service
public class ServicioImpl implements Servicio {
	private final Repositorio dao;
	
	
	public ServicioImpl(Repositorio dao) {
		this.dao = dao;
		System.err.println("ServicioImpl Constructor");	
	}


	@Override
	public void add() {
		dao.save();
	}

}
