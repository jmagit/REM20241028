package com.example.ioc.multiple;

import org.springframework.stereotype.Component;

import com.example.ioc.NotificationService;

import lombok.NonNull;

@Component
public class ConstructorConValores {
	public ConstructorConValores(int version, String otroAutor, NotificationService notify) {
		notify.add("Version: " + version + " Autor: " + otroAutor);
		// System.err.println("Version: " + version + " Autor: " + otroAutor);
	}
	
	public void titulo(@NonNull String tratamiento, String autor) {
		System.err.println(tratamiento.toUpperCase() + " " + autor.toUpperCase());
	}
		
	public void titulo(@NonNull String autor) {
		System.err.println(autor.toUpperCase());
	}
}
