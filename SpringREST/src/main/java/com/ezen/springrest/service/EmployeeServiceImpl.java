package com.ezen.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springrest.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	@Override
	public void list(Model model) {
	
		model.addAttribute("employees", employeeMapper.getAll());
		
	}

}
