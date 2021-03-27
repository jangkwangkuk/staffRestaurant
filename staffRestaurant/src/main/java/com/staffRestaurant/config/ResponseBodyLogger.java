package com.staffRestaurant.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.staffRestaurant.utill.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ResponseBodyLogger<T> implements ResponseBodyAdvice<T> {

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
			String ip  = request.getRemoteAddress().getAddress().getHostAddress();
			String uri = request.getURI().getPath();
			String responseBody = CommonUtil.convertMapToStr(body);
			
			log.info(String.format("{\"IP\" : \"%s\", \"URI\" : \"%s\", \"RESPONSE\" : %s}", ip, uri, responseBody));
		} catch (Exception e) {
			log.error("[beforeBodyWrite] staffError : "+e.getMessage());
		}
		return body;
	}
}