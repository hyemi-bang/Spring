package com.ezen.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.springrest.dto.EmployeeDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/jquery")
@Controller
public class JQuerySampleController {
	
	@GetMapping("/")
	public String jQueryHome() {
		return "jquery/index";
	}

	// - @ResponseBody	: 일반 컨트롤러 내부의 해당 메서드가 뷰 페이지 대신 데이터를 응답한다는 것을 표시
	@ResponseBody
	@GetMapping("/employee/{emp_id}")
	public EmployeeDTO getEmployee(
			@PathVariable("emp_id") Integer emp_id
			){
		log.info("emp_id:" + emp_id);
		
		// DB에서101번 사원을 잘 꺼냈다고 가정한 후 
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmployee_id(emp_id);
		emp.setFirst_name("Will");
		emp.setLast_name("Smith");
		
		return emp;
	}
}
