package com.staffRestaurant.utill;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {
    @Autowired
    HttpServletRequest request;
	
    /**
	 * Map을 문자열로 변환
	 * @param map
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String convertMapToStr(Object map) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writerWithDefaultPrettyPrinter() // Pretty-Print(Json 형식으로 변환)
		                       .writeValueAsString(map);		 // MapToString
		return jsonStr;
	}
	
	/**
	 * null 인 경우 빈값("")을 가져오기
	 * @param obj
	 * @return
	 */
	public static String defaultString(Object obj) {
		return obj == null ? "" : String.valueOf(obj);
	}
	
	/**
	 * 에러 로그 남기기
	 * @param errMsg
	 */
	public static void exceptionLogger(Exception e) {
		StackTraceElement[] element = new Throwable().getStackTrace();
		
		if(element != null && element.length > 1) {
			String clazzName  = element[1].getClassName();
			String methodName = element[1].getMethodName();
			int    LineNumber = element[1].getLineNumber();
			log.error(String.format("[%s.%s(%s)]  staffError : %s",clazzName, methodName, LineNumber,e.getMessage()));
		}
	}
}