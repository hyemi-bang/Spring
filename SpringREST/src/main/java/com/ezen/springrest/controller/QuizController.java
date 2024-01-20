package com.ezen.springrest.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/quiz")
@RestController
public class QuizController {
	@Autowired
	private EmployeeService employeeService; // EmployeeService를 사용하여 DB에서 데이터를 가져옴

	@GetMapping(value = "/jsonQ", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeDTO> value7() {
		// DB에서 모든 직원 데이터 가져오기
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();

		// 리스트를 섞음
		Collections.shuffle(allEmployees);

		// 리스트에서 처음 10개의 직원을 선택
		List<EmployeeDTO> randomEmployees = allEmployees.subList(0, Math.min(allEmployees.size(), 10));

		return randomEmployees;
	}

	@GetMapping(value = "/xmlQ", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> value8() {
		// DB에서 모든 직원 데이터 가져오기
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();

		// 리스트를 섞음
		Collections.shuffle(allEmployees);

		// 리스트에서 처음 10개의 직원을 선택
		List<EmployeeDTO> randomEmployees = allEmployees.subList(0, Math.min(allEmployees.size(), 10));

		return randomEmployees;
	}
}