package com.khaledahmmedanik.main.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document
public class Student {
	
	@Id
	private String id;
	
	private String name;
	
	private String subvisorInit;
	
	@NonNull
	private String entryTime;
	
	private String exitTime;
	
	private boolean isIn;

}
