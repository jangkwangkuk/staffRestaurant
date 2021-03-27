package com.staffRestaurant.except.code;

import org.springframework.http.HttpStatus;

public enum StaffError {

    INVALID_INPUT_ERROR(HttpStatus.BAD_REQUEST, "1000", "Invalid Input Parameter"),
    USER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "1100", "User Not Found"),
    CONTENT_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "1200", "Content Not Found"),
    SYSTEM_RUNTIME_ERROR(HttpStatus.NOT_FOUND, "1200", "System Runtime Error"),
    ;

	StaffError(HttpStatus status, String code, String message) {
    	this.status = status;
        this.code = code;
        this.message = message;
    }

	private final HttpStatus status;
    private final String code;
    private final String message;    
    
    public String getCode() {
    	return code;
    }
    
    public String getMessage() {
    	return message;
    }
    
    public HttpStatus getStatus() {
    	return status;
    }
}
