package com.spring.microservices.limitsservice.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
	
	private int maximun;
	private int minimun;
	
	public int getMaximun() {
		return maximun;
	}
	
	public void setMaximun(int maximun) {
		this.maximun = maximun;
	}
	
	public int getMinimun() {
		return minimun;
	}
	
	public void setMinimun(int minimun) {
		this.minimun = minimun;
	}
}
