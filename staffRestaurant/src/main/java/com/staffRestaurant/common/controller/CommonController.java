package com.staffRestaurant.common.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staffRestaurant.common.service.CommonService;

@RestController
@RequestMapping(path="/common")
public class CommonController {
	
	@Autowired
	CommonService commonService;
	
	@GetMapping(path="/test")
	public Object getTest() {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		return commonService.getTest(paramMap);
	}
}
