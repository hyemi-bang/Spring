package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class RedirectController {

	// 해당 경로로 들어가면 "redirect:/abc/a";로 리다이렉트 abc/a로 이동한다는거지 
   @RequestMapping(value = "/redirect/test1", method = RequestMethod.GET)
   public String test1() {
      return "redirect:/abc/a";
   }
   

   @RequestMapping(value = "/redirect/test2", method = RequestMethod.GET)
   public String test2(RedirectAttributes rattr) {
      // 리다이렉트 요청시 GET방식 파라미터로 함께 보내는 값들을 RedirectAttribute라고 칭한다
      rattr.addAttribute("age", 20);  // 파라미터 age 20으로 설정
      return "redirect:/abc/b?user=admin&t=a"; // "/abc/a"로 이동하면 쿼리 파라미터로  "user=admin"과 "t=a"를 함께 전달한다
   }

   @RequestMapping(value = "/abc/b", method = RequestMethod.GET)

   public String test22(String user, Character t, int age) {
      // 리다이렉트 요청시 GET방식 파라미터로 함께 보내는 값들을 RedirectAttribute라고 칭한다
      log.info("user:" + user);
      log.info("t:" + t);
      log.info("age:" + age);

      return "/aaa/aaa";
   }

   @RequestMapping(value = "/redirect/test3", method = RequestMethod.GET)
   public String test3(RedirectAttributes rattr) {
      rattr.addFlashAttribute("age", 123);
      rattr.addFlashAttribute("login","true");

      return "redirect:/abc/c";
   }
   
   @RequestMapping(value = "/abc/c", method = RequestMethod.GET)
   public String test33(@ModelAttribute("age") int age, @ModelAttribute("login") boolean login) {
	 //     @ModelAttribute 는 메서드의 파라미터를 모델 속성과 바인딩 시킨다
	   // age, login 두 모델 속성에 저장된 값을 가져올 수 있게 해준다
      log.info("age:" + age);
      log.info("login:" + login);
      return "redirect:/bbb/bbb";
   }
   

   
   @RequestMapping(value = "/abc/c2", method = RequestMethod.GET)
   public String test333(Model model) {
      // Model model 모델 인터페이스 사용하면 메서드의 파라미터를 직접 받아온다
	   // model.getAttribute("속성값")통해 해당 모델의 속성값을 가져온다
      
      log.info("age:" + model.getAttribute("age"));
      log.info("login:" + model.getAttribute("login"));
      return "redirect:/bbb/bbb";
   }
   
}