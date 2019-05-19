package com.spring.microservices.limitsservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.microservices.limitsservice.bean.Configuration;
import com.spring.microservices.limitsservice.bean.LimitsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfig getLimitsConfig() {
		return new LimitsConfig(configuration.getMaximun(), configuration.getMinimun());
	}
	
	@GetMapping("/hystrixtest")
	@HystrixCommand(fallbackMethod = "fallback")
	public LimitsConfig hystrixtest() {
		throw new RuntimeException();
	}
	
	private LimitsConfig fallback() {
		return new LimitsConfig(999, 9);
	}
}
