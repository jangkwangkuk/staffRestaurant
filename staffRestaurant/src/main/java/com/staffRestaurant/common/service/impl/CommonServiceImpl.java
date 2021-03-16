package com.staffRestaurant.common.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staffRestaurant.common.mapper.CommonMapper;
import com.staffRestaurant.common.service.CommonService;
@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	CommonMapper commonMapper;
	
	@Override
	public Object getTest(HashMap<String, String> paramMap) {
		
		return commonMapper.selectTest(paramMap);
	}
}
