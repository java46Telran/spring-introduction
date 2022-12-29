package telran.spring.service;

import org.springframework.stereotype.Service;

@Service("email")
public class EmailsSender implements Sender {

	@Override
	public void send(String text) {
		System.out.printf("Email message: %s has been sent\n", text);

	}

}
