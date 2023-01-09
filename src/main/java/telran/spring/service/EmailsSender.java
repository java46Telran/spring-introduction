package telran.spring.service;

import org.springframework.stereotype.Service;

import telran.spring.dto.*;

@Service

public class EmailsSender implements Sender {

	@Override
	public String send(Message message) {
		String res = "";
		EmailMessage emailMessage;
		try {
			emailMessage = (EmailMessage) message;
			res = String.format("email sender text '%s' has been sent to %s\n", emailMessage.text,
					emailMessage.emailAddress);
			LOG.debug("message: {}", res);
		} catch (Exception e) {
			res = "Message Data mismatch sender type";
			LOG.error("Exception {}", e.getMessage());
			
		}

		return res;

	}

}
