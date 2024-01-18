package com.ezen.springmvc.controller;

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

import com.ezen.springmvc.model.Coffee;
import com.ezen.springmvc.model.Cook;
import com.ezen.springmvc.model.Department;

import commons.Calculator;

@Controller
public class HomeController {

	private static final Logger log = LogManager.getLogger(HomeController.class);

	@Autowired // 생성자를 사용하지 않아도 스프링에서 수거해간 후 그 클래스 바탕으로 인스턴스 만들어서 대입해준것
	Cook cook; // = new Cook();

	@Autowired
	Calculator calculator;

	@RequestMapping(value = "/", method = RequestMethod.GET) // "/"이주소의  get방식으로 들어오는 것을 처리한다`
	public String home(Locale locale, Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		
		Department dept = new Department();
		Coffee coffee = new Coffee();
		
		//@NonNull 필드에 null을 넣으려는 경우 익셉션을 발생시켜준다
		// coffee 테이블에 @NonNull이 설정되어있으면 충돌이 나서 오류가 난다.
		 try {
	         coffee.setCoffee_id(null);
	      }
	      catch(NullPointerException e) {
	         e.printStackTrace();
	      }
	      
		
		log.info(dept);
		log.info(coffee);
		
		int a = calculator.diff(10, 13);
		
		// log4j.xml에서 설정한 level에 따라 나오게 되고 설정하지 않으면 기본셋팅인 warn을 기준으로해서 나온다
		log.fatal("Welcome to HomeController!!");
		log.error("Welcome to HomeController!!");
		log.warn("Welcome to HomeController!!"); //warning메세지를 남김
		log.info("Welcome to HomeController!!");
		log.debug("Welcome to HomeController!!");
		log.trace("Welcome to HomeController!!");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("cook", cook);
		System.out.println(cook);
		return "home";
	}

}
