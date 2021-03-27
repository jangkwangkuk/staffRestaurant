package com.staffRestaurant.user.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	/**
	 * 회원가입
	 * @param param
	 * @return
	 */
	public int insertUserInfo(HashMap<String, Object> param);
	
	/**
	 * 로그인
	 * @param param
	 * @return
	 */
	public HashMap<String, String> selectUserInfo(HashMap<String, Object> param);
}