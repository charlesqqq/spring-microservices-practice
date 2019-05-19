package com.spring.microservices.currencyconversionservice.controller;

import com.spring.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.spring.microservices.currencyconversionservice.feign.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversionBean bean = currencyExchangeProxy.getCurrencyConversionBean(from, to);
		bean.setQuantity(quantity);
		bean.setCalculatedAmount(quantity.multiply(bean.getConversionMultiple()));
		logger.info("{}", bean);
		return bean;
	}
}
