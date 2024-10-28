package com.example.ioc.basico;

import com.example.ioc.basico.Configuracion;
import com.example.ioc.basico.Repositorio;

public class RepositorioImpl implements Repositorio {
	private final Configuracion configuracion;
	
	
	public RepositorioImpl(Configuracion configuracion) {
		System.err.println("RepositorioImpl Constructor");	
		this.configuracion = configuracion;
		configuracion.config();
	}


	@Override
	public void save() {
		var contador = configuracion.getNext();
		System.err.println("Guardo los datos. Me han usado " + contador + (contador == 1 ? " vez." : " veces."));	
	}
}