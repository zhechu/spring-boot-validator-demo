package com.wise.validator.demo.web.validator;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * 验证异常类
 * @author lingyuwang
 *
 */
public class ValidateException extends RuntimeException {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7207451175263593487L;
	
	private List<ObjectError> errors;
	
	public ValidateException(List<ObjectError> errors) {
		this.errors = errors;
	}

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}

}
