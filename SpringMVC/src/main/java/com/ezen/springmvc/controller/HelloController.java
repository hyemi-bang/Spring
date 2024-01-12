package com.ezen.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.springmvc.model.Department;

@RequestMapping("/hello") //  /hello로 들어오는 것을 처리하겠다.
@Controller
public class HelloController {
	
	private static Logger log = LogManager.getLogger(HelloController.class);
	
	@RequestMapping("/index")
	String index(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("department", new Department());
		
		// WEB-INF/views 와 확장자 .jsp를 제외한 주소를 리턴하면 알맞은 뷰를 찾아감
		// servlet-context.xmp에 관련된 설정이 있다
		return "hello/index";
	}
	
	@RequestMapping(value ={"/hi", "/greetings"})
	String greetion() {
		return "hello/greetings";
	}
	
	@RequestMapping(value ="/parameter", method = RequestMethod.GET)
	String paraForm() {
		return "hello/parameter";
	}
	
	@RequestMapping(value ="/parameter", method = RequestMethod.POST)
	String para(Department dept) {
		
		//request.getParameter()로 노가다 하지 않았으나 알아서 인스턴스화 되어있다.
		//log.info(dept);
		
		//return "redirect:/";
		
		// request.setAttribute()로 추가하지 않아도 추가됨
		return "hello/paraResult";
	}
	
	@RequestMapping(value ="/para2")
	String para2(Integer employee_id) {
		
		log.info("employee_id"  + employee_id);
		return "hello/result2";
	}
	
	@RequestMapping(value ="/para3")
	String para3(@ModelAttribute("employee_id") Integer emp_id) {
		
		log.info("emp_id"  + emp_id);
		return "hello/result2";
	}
	
	@RequestMapping("/cookie/")
	String cookieIndex() {
		return "hello/cookie/index"; //  포워드 경로 
	}
	@RequestMapping("/cookie/set")
	String cookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("age","10");
		response.addCookie(cookie);
		response.addCookie(new Cookie("hobby", "수영"));
		response.addCookie(new Cookie("movie", "판타지"));
		
		return "redirect:/hello/cookie/"; // 리다이렉트 경로 포워드랑 리다이렉트랑 같은 경로를 사용하게끔 
	}
	
	@RequestMapping("/cookie/check")
	String checkCookie(
			@CookieValue Integer age, 
			@CookieValue String movie,
			@CookieValue String hobby) {
		
		log.info("age" + age);
		// log.info("language" + language);
		// Missing cookie 'language' for method parameter of type String]
		log.info("movie" + movie);
		log.info("hobby" + hobby);
		
		return "redirect:/hello/cookie/";
	}
	
	@RequestMapping("/return/void")
	void returnPage() {}
	// void는 리턴이 없어
	// 아무것도 적지 않아도 /WEB-INF/views/hello/return/void.jsp를 찾아간다
	
	//ModelAndView : model 과 string의 역할 짐싣는 역할 과 다음 페이지로 가는 역할을 한데 묶은 객체이다.
	@RequestMapping("/return/mnv")
	ModelAndView returnPage2() {
		ModelAndView mnv = new ModelAndView();
		
		// Model의 짐 싣는 역할도 하고
		mnv.addObject("dept", new Department());
		
		// String의 다음 뷰로 안내하는 역할
		mnv.setViewName("hello/return/mnv");
		
		return mnv;
	}
}
