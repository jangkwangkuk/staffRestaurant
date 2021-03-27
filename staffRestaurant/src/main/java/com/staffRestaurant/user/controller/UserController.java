package com.staffRestaurant.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staffRestaurant.user.service.UserService;

@RequestMapping(path="/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 회원가입
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path="/setUserInfo")
	public Object setUserInfo(@RequestBody(required = false) HashMap<String, Object> param) throws Exception {
		return userService.setUserInfo(param);
    }
	
	/**
	 * 로그인
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path="/login")
	public Object login(@RequestBody(required = false) HashMap<String, Object> param) throws Exception {
		return userService.login(param);
    }
}
