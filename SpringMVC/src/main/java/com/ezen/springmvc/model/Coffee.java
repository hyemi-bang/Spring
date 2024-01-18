package com.ezen.springmvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
//@RequiredArgsConstructor
@Data
public class Coffee {
	
	//@NonNull
	private Integer coffee_id;
	private String coffee_name;
	private double coffee_price;
	private String country_id;
}
