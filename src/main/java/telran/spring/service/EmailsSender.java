package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.view.*;

@Service("email")
public class EmailsSender implements Sender {

	@Override
	public void send(InputOutput io, String text) {
		String emailAddress = io.readPredicate("Enter email address", "Wrong email",
				EmailsSender::emailPredicate);
		System.out.printf("text '%s' has been sent to %s\n", text, emailAddress);
		
	}
	static boolean emailPredicate(String email) {
		return email.matches(emailRegEx());
	}
	private static String emailRegEx() {
		String firstPart = "[^\\s,]+";
		String domain = "[a-zA-Z]+|[a-zA-Z]+-[a-zA-Z]+";
		String regex = String.format("%1$s@((%2$s)\\.){1,3}(%2$s)", firstPart, domain);
		
		return regex;
	}


}
