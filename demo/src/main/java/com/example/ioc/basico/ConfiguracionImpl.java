package com.example.ioc.basico;

import com.example.ioc.basico.Configuracion;

public class ConfiguracionImpl implements Configuracion {
	private int contador = 0;
	
	public ConfiguracionImpl() {
		System.err.println("ConfiguracionImpl Constructor");	
	}

	@Override
	public void config() {
		System.err.println("Me configuran");	
	}

	@Override
	public int getNext() {
		return ++contador;
	}

}
