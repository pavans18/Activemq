package com.example.listener;

import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;

@Component
public class MessageListener implements jakarta.jms.MessageListener{
	
	@Override
	public void onMessage(Message message) {

		try {
			if (message instanceof TextMessage) {
				
				TextMessage textMessage = (TextMessage) message;
				
				String text = textMessage.getText();
				
				System.out.println("Received message: " + text);
			
			} else {
				System.out.println("Received message of unsupported type: " + message);
			}
		} catch (JMSException e) {
			System.err.println("Error while processing the message: " + e.getMessage());
		}
	}

	
}
