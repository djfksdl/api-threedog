package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SUService;
import com.javaex.util.JsonResult;

@RestController
public class SUController {
	
	@Autowired
	private SUService suService;
	
	@GetMapping("/api/su")
	public JsonResult list() {
		System.out.println("SUController.list");
		
		suService.exeList();
		
		return JsonResult.success("얏호");
		
		
	}
}
