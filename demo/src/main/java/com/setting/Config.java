package com.setting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.haiwan.Kambing;

@Configuration
public class Config {

	@Bean
	public Kambing bagiBalikseekorKambing() {
		return new Kambing();
	}
}
