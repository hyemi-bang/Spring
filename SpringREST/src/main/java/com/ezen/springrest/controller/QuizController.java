package com.ezen.springrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springrest.dto.EmployeeDTO;
import com.ezen.springrest.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/quiz")
@Controller
public class QuizController {
	
	@Autowired
	EmployeeService employeeService;

	
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_XML_VALUE)
	public List<EmployeeDTO> jsonBtn() {
		List<EmployeeDTO> emps = new ArrayList<>();

		return emps;
	}

}
