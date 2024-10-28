package com.example.ioc.basico;

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
