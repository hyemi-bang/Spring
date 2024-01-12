package com.ezen.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 생성자
@AllArgsConstructor 
@ToString
@Setter
@Getter // 개터가 생성된것
public class Department {

	private Integer department_id;
	private String department_name;
	private Integer location_id;
	private Integer manager_id;
}
