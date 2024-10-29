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
	
	@NonNull
	public void titulo(String tratamiento, String autor) {
		System.err.println(tratamiento.toUpperCase() + " " + autor.toUpperCase());
	}
	
	@NonNull
	public void titulo(String autor) {
		System.err.println(autor.toUpperCase());
	}
}
