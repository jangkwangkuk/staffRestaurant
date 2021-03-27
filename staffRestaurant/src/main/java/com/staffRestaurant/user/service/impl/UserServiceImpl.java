package com.staffRestaurant.user.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffRestaurant.common.vo.ReturnVo;
import com.staffRestaurant.except.ServiceErrorException;
import com.staffRestaurant.except.code.StaffError;
import com.staffRestaurant.user.mapper.UserMapper;
import com.staffRestaurant.user.service.UserService;
import com.staffRestaurant.utill.CommonUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public Object setUserInfo(HashMap<String, Object> param) {
		ReturnVo returnVo = new ReturnVo();
		
		String id       = CommonUtil.defaultString(param.get("ID"));
		String password = CommonUtil.defaultString(param.get("PASSWORD"));
		String name     = CommonUtil.defaultString(param.get("NAME"));
		String tel      = CommonUtil.defaultString(param.get("TEL"));
		String typ      = CommonUtil.defaultString(param.get("TYP"));
		
		if(id.equals("") || password.equals("") || name.equals("") || tel.equals("") || typ.equals(""))
			throw new ServiceErrorException(StaffError.INVALID_INPUT_ERROR);

		try {	
			if(userMapper.insertUserInfo(param) != 1) {
				returnVo.setReturnCd("FAIL");
				returnVo.setReturnMsg("UserInfo not insert");
			} else {
				returnVo.setReturnCd("OK");
				returnVo.setReturnMsg("insert Success");
			}
			return returnVo;
		} catch (Exception e) {
			CommonUtil.exceptionLogger(e);
			throw new ServiceErrorException(StaffError.SYSTEM_RUNTIME_ERROR);
		}
	}

	@Override
	public Object login(HashMap<String, Object> param) {
		String id       = CommonUtil.defaultString(param.get("ID"));
		String password = CommonUtil.defaultString(param.get("PASSWORD"));
	
		if(id.equals("") || password.equals(""))
			throw new ServiceErrorException(StaffError.INVALID_INPUT_ERROR);
	
		try {
			return userMapper.selectUserInfo(param);
		} catch (Exception e) {
			CommonUtil.exceptionLogger(e);
			throw new ServiceErrorException(StaffError.SYSTEM_RUNTIME_ERROR);
		}
	}


}
