package com.staffRestaurant.user.service;

import java.util.HashMap;

public interface UserService {
	/**
	 * 회원가입
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object setUserInfo(HashMap<String, Object> param) throws Exception;
	
	/**
	 * 로그인
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object login(HashMap<String, Object> param) throws Exception;
}
