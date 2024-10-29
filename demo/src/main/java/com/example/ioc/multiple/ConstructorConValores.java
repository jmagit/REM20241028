package com.example.ioc.multiple;

import org.springframework.stereotype.Component;

@Component
public class ConstructorConValores {
	public ConstructorConValores(int version, String otroAutor) {
		System.err.println("Version: " + version + " Autor: " + otroAutor);
	}
}
