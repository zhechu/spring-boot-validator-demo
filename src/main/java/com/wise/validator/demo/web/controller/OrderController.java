/**
 * 
 */
package com.wise.validator.demo.web.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wise.validator.demo.entity.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * 订单控制器
 * @author lingyuwang
 *
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@PostMapping
	public Order create(@Valid @RequestBody Order order) {
		
		log.debug("新建订单信息：{}", order);
		
		return order;
	}

}
