package com.wise.validator.demo.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

/**
 * 订单仓库
 * @author lingyuwang
 *
 */
@Repository
public class OrderRepository {

	/**
	 * 模拟获取订单总交易金额
	 * @return
	 */
	public BigDecimal getTotalTradeAmount() {
		return new BigDecimal(100);
	}
	
}
