package com.example.ioc.multiple;

public class FileSender implements Sender {

	@Override
	public void send(String message) {
		System.err.println("Escribo en el fichero: " + message);
	}

}