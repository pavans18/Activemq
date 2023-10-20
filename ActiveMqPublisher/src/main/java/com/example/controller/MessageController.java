package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.publisher.MessagePublisher;

@RestController
@RequestMapping("/api")
public class MessageController {
	
	@Autowired
	MessagePublisher publisher;
	
	@PostMapping(path = "/send/{message}")
	public ResponseEntity<String> sendMessage(@PathVariable String message){
		
		
		publisher.PublishMessage("MyQueue", message);
		
		return new ResponseEntity<String>("message sent successfully", HttpStatus.OK);
		
	}

}
