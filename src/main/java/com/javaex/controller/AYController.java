package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AYController {
	
	@GetMapping("/api/ay")
	public void list() {
		System.out.println("AYController.list");
		
	}
}
