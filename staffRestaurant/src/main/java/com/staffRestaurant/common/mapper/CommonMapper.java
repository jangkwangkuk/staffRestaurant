package com.staffRestaurant.common.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommonMapper {
	public List<HashMap<String, Object>> selectTest(HashMap<String,String> paramMap);
}
