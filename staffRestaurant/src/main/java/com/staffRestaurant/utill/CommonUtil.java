package com.staffRestaurant.utill;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonUtil {
	
	// Map To String
	public static String convertMapToStr(Object map) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter() // Pretty-Print(Json 형식으로 변)
		                       .writeValueAsString(map);		 // MapToString
		return jsonStr;
	} 
}
