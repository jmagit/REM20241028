package com.example.ioc.multiple;

public class EMailSender implements Sender {

	@Override
	public void send(String message) {
		System.err.println("Envio correo: " + message);
	}

}
