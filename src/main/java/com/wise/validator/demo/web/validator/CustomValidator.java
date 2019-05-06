package com.wise.validator.demo.web.validator;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.wise.validator.demo.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义验证器
 * @author lingyuwang
 *
 */
@Slf4j
// 不需加 @Component 注解，Spring 会自动处理实现 ConstraintValidator 接口的类
public class CustomValidator implements ConstraintValidator<CustomConstraint, BigDecimal> {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void initialize(CustomConstraint constraintAnnotation) {
		log.info("custom validator init");
	}

	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		
		log.info("value:{}", value);
		
		if (value != null && value.compareTo(orderRepository.getTotalTradeAmount()) >= 0) {
			return true;
		}
		
		return false;
	}

}
