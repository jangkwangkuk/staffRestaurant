package com.staffRestaurant.except;

import com.staffRestaurant.except.code.StaffError;

public class ServiceErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final StaffError staffError;

	public ServiceErrorException(StaffError staffError) {
        super(staffError.getMessage());
        this.staffError = staffError;
    }
	
    public ServiceErrorException(StaffError staffError, Throwable cause) {
        super(cause);
        this.staffError = staffError;
    }
    
    public StaffError getError() {
        return this.staffError;
    }
}
