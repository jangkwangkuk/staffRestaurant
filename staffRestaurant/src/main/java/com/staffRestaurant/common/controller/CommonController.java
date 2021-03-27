package com.staffRestaurant.common.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.staffRestaurant.common.service.CommonService;

@RequestMapping(path="/common")
@RestController
public class CommonController {
	
	@Autowired
	CommonService commonService;

	@GetMapping(path="/test")
	public Object getTest() {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("asd", "asd");
		return commonService.getTest(paramMap);
    }
    

	@PostMapping(path="/test1")
	public Object getTest1(@RequestBody(required = false) HashMap<String, Object> body) {
	return "123123213";
    }
}
