package com.example.ioc.multiple;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.aop.Logged;
import com.example.aop.Logging;
import com.example.ioc.NotificationService;

import lombok.NonNull;

@Component
public class ConstructorConValores {
	public ConstructorConValores(int version, String otroAutor, NotificationService notify) {
		notify.add("Version: " + version + " Autor: " + otroAutor);
		// System.err.println("Version: " + version + " Autor: " + otroAutor);
	}
	
	@Logged
	public void titulo(String tratamiento, String autor) {
		System.err.println(tratamiento.toUpperCase() + " " + autor.toUpperCase());
	}
	@Logging	
	public void titulo(String autor) {
		System.err.println(autor.toUpperCase());
	}

//	public String dameValor(String autor) {
//		return Optional.empty();		
//	}

	@Logged
	public Optional<String> dameValor(String autor) {
		return Optional.empty();		
	}
}
