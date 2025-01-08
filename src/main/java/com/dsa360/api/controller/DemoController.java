package com.dsa360.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
	@GetMapping("/add")
	public int addNumbers(@RequestParam int num1, @RequestParam int num2) {
		int sum = num1 + num2;
		return sum;
	}

}
