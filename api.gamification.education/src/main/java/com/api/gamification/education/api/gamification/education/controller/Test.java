package com.api.gamification.education.api.gamification.education.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class Test {
	
	@RequestMapping(path="api")
	public String teste() {
		return "Hello word!";
	}

}
