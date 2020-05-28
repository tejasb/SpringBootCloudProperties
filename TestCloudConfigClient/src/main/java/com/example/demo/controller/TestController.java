package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.component.Foo;

@RestController
public class TestController {
	@Autowired
	Foo foo;
	
	@GetMapping("/giveValue")
	@RequestScope
	public String getFooValue() {
		return foo.giveValue();
	}
}
