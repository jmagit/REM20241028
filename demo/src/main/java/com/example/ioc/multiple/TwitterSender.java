package com.example.ioc.multiple;

public class TwitterSender implements Sender {

	@Override
	public void send(String message) {
		System.err.println("Twiteo: " + message);
	}

}
