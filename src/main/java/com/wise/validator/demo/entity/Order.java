package com.wise.validator.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.wise.validator.demo.web.validator.CustomConstraint;

import lombok.Data;

/**
 * 订单实体
 * @author lingyuwang
 *
 */
@Data
public class Order implements Serializable {
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7326468588263698503L;

	private String id;
	
	@NotBlank(message = "订单流水号不能为空")
	private String orderSerialNumber;
	
	@Past(message = "交易时间必须是过去的时间")
	private Date tradeTime;
	
	@CustomConstraint(message = "自定义验证器验证失败提示信息")
	private BigDecimal tradeAmount;

}
