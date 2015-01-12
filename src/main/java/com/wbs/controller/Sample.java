package com.wbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class Sample {

	@RequestMapping("/{msg}")
	@ResponseBody
	public String check(@PathVariable("msg") String msg) {
		System.out.println("Hello");
		return "Welcome : " + msg;
	}
}
