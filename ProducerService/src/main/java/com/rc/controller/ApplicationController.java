package com.rc.controller;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.service.ProducerService;
 
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApplicationController {

	@Autowired
	private  ProducerService producerService ;
	
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String msg) {

        producerService.sendMessage(msg);

        return new ResponseEntity<>("Please check msg in Consumer Service Logs & Offset Explorer", HttpStatus.OK);
    }
	
	
	
}
