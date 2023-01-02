package telran.spring.controller;

import java.util.*;

import org.springframework.stereotype.Component;

import telran.spring.service.Sender;
import telran.view.*;
@Component
public class MessageSender {
Map<String, Sender> senders;
public MessageSender(Map<String, Sender> senders) {
	
	this.senders = senders;
}

public void menu(InputOutput io) {
	Item items[] = {
		Item.of("send message", this::sendMessage),
		Item.exit()
	};
	Menu menu = new Menu("Sender Adpplication", items);
	menu.perform(io);
	
}
private void sendMessage(InputOutput io) {
	String text = io.readString("Enter text");
	List<String> types = new ArrayList<>(getTypes());
	String senderType =
			io.readOption(String.format("Enter a sender type from %s", types),
					"Wrong type, please enter type from the specified types above",
					types);
	Sender sender = senders.get(senderType);
	if(sender == null) {
		throw new IllegalStateException("error in getting sender's type");
	}
	sender.send(io, text);
			
}
private Set<String> getTypes() {
	
	return senders.keySet();
}

}
