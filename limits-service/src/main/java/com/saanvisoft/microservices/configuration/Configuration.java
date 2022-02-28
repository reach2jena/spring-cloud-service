package com.saanvisoft.microservices.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("limits-service")
@Data
@RefreshScope
public class Configuration {
	private int minimum;
	private int maximum;

//	public int getMinimum() {
//		return minimum;
//	}
//
//	public void setMinimum(int minimum) {
//		this.minimum = minimum;
//	}
//
//	public int getMaximum() {
//		return maximum;
//	}
//
//	public void setMaximum(int maximum) {
//		this.maximum = maximum;
//	}

}
