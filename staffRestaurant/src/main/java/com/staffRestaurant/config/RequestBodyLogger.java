package com.staffRestaurant.config;

import java.lang.reflect.Type;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.staffRestaurant.utill.CommonUtil;

@ControllerAdvice
public class RequestBodyLogger extends RequestBodyAdviceAdapter {

    @Autowired
    HttpServletRequest httpServletRequest;
	
    private Logger logger = LoggerFactory.getLogger(RequestBodyLogger.class);
	

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		return true;
	}
    
	@Override
    public Object afterBodyRead( Object body
    		                   , HttpInputMessage inputMessage
    		                   , MethodParameter parameter
    		                   , Type targetType
    		                   , Class<? extends HttpMessageConverter<?>> converterType) {
		try {
			String ip = httpServletRequest.getRemoteAddr();
			String url = httpServletRequest.getRequestURI();
			String requestBody = CommonUtil.convertMapToStr(body);
			
			logger.info(String.format("{\"IP\" : \"%s\", \"URL\" : \"%s\", \"RESPONSE\" : %s", ip, url, requestBody));
		} catch (Exception e) {
			logger.error("[afterBodyRead] staffError : "+e.getMessage());
		}
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
	}
}