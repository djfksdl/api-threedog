package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YEService;

@RestController
public class YEController {
	
	@Autowired
	private YEService yeService;
	
	@GetMapping("/api/ye")
	public void list() {
		System.out.println("YEController.list");
		
	}
}
