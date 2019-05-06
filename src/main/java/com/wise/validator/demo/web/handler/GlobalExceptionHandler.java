/**
 * 
 */
package com.wise.validator.demo.web.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 * @author lingyuwang
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleUserNotExistException(MethodArgumentNotValidException ex) {
		Map<String, Object> result = new HashMap<>();
		
		StringBuilder errmsg = new StringBuilder();
		
		ex.getBindingResult().getAllErrors().forEach(x -> {
			errmsg.append(x.getDefaultMessage()).append(",");
		});
		
		String errmsgStr = null;
		if (errmsg.lastIndexOf(",") > 1) {
			errmsgStr = errmsg.substring(0, errmsg.length() - 1);
		} else {
			errmsgStr = errmsg.toString();
		}
		
		result.put("errmsg", errmsgStr);
		
		return result;
	}

}
