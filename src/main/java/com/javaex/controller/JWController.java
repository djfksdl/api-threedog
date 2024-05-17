package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWController {
	
	@GetMapping("/api/jw")
	public void list() {
		System.out.println("JWController.list");
		
	}
}
