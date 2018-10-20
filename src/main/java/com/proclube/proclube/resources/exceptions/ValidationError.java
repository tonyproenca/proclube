package com.proclube.proclube.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessages> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessages> getErrors(){
		return errors;
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessages(fieldName, message));
	}
	
}
