/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Hafiz
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
    
    public DataNotFoundException () {
    }
    
    public DataNotFoundException (String message) {
        super(message);
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
}
