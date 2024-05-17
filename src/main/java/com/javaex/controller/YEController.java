package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YEController {
	
	@GetMapping("/api/ye")
	public void list() {
		System.out.println("YEController.list");
		
	}
}
