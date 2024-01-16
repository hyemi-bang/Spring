package com.ezen.springdb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ezen.springdb.dto.EmployeeDTO;
import com.ezen.springdb.mapper.EmployeeMapper;
import com.zaxxer.hikari.HikariDataSource;


@Controller
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static Logger log = LogManager.getLogger(HomeController.class);
	
	@Autowired
	HikariDataSource ds; // root-context에서 필요하구나 하고 사용할 수 있게 해준다.
	
	@Autowired 
	EmployeeMapper empMapper;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		log.info(ds);		
		log.info("---------------");
		log.info(empMapper.getAll());
		
		for(EmployeeDTO emp : empMapper.getAll()) {
			System.out.println(emp);
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
