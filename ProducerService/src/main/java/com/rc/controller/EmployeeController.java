package com.rc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.model.Employee;
import com.rc.service.ProducerService;

 
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
	@Autowired
	private ProducerService producerService;
	
	@PostMapping("sendempinfo")
	public ResponseEntity<String> sendEmployeeInfo(@RequestBody Employee emp){
		producerService.sendEmpInfo(emp);
		return new ResponseEntity<String>("Check Employee Details at Consumer Service log ..!" ,HttpStatus.OK);
	}

}
