package com.staffRestaurant.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.staffRestaurant.utill.CommonUtil;

@ControllerAdvice
public class ResponseBodyLogger<T> implements ResponseBodyAdvice<T> {
	
	private Logger logger = LoggerFactory.getLogger(ResponseBodyLogger.class);

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public T beforeBodyWrite( T body
			                , MethodParameter returnType
			                , MediaType selectedContentType
			                , Class<? extends HttpMessageConverter<?>> selectedConverterType
			                , ServerHttpRequest request
			                , ServerHttpResponse response) {
		try {
			String ip    = request.getRemoteAddress().getAddress().getHostAddress();
			String url   = request.getURI().getPath();
			String responseBody = CommonUtil.convertMapToStr(body);
			
			logger.info(String.format("{\"IP\" : \"%s\", \"URL\" : \"%s\", \"RESPONSE\" : %s}", ip, url, responseBody));
		} catch (Exception e) {
			logger.error("[beforeBodyWrite] staffError : "+e.getMessage());
		}
		return body;
	}
}