package com.khaledahmmedanik.main.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Admin {
	@Id
	private String id;
	
	private int seatLimit;
	
	private String password;
}
