package com.example.ioc.basico;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Primary
@Profile("default")
public class ServicioImpl implements Servicio {
	private final Repositorio dao;
	
	
	public ServicioImpl(Repositorio dao) {
		this.dao = dao;
		System.err.println(getClass().getSimpleName() + " Constructor");
	}


	@Override
	public void add() {
		dao.save();
	}

}
