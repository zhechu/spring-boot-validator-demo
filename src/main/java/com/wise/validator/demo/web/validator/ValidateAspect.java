package com.wise.validator.demo.web.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 验证切面
 * @author lingyuwang
 *
 */
@Aspect
@Component
@Slf4j
public class ValidateAspect {
	
	@Around("execution(* com.wise.validator.demo.web.controller.OrderController.*(..))")
	public Object handleValidateResult(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("进入切片");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult errors = (BindingResult)arg;
				if (errors.hasErrors()) {
					throw new ValidateException(errors.getAllErrors());
				}
			}
		}
		
		Object result = pjp.proceed();
		
		return result;
	}

}
