package com.example.ioc.basico;

import org.springframework.stereotype.Component;

@Component
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
