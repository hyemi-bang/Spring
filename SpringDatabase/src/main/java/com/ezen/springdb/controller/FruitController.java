package com.ezen.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapper;
import com.ezen.springdb.mapper.FruitMapperXML;
import com.ezen.springdb.service.FruitService;

import lombok.extern.log4j.Log4j;


@Log4j
@Controller
public class FruitController {

	// @GetMapping, @PostMapping...등으로 @RequestMapping을 줄여 사용할 수 있다
	
	/* 재활용이 어렵기때문에! Service를 만들어준다	*/
	
	@Autowired
	FruitMapper fruitMapper;
	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	FruitMapperXML fruitMapperXML;
	

	@Autowired
	FruitService fruitService;
	
	
	@GetMapping("/fruit/list")
	public void list(Model model) {
		//model.addAttribute("fruits", fruitMapper.getAll());
		//model.addAttribute("fruits", fruitMapperXML.getAll());
		fruitService.listFruits(model);
	
	}

	/*@GetMapping("/fruit/update")
	public void updateForm(Model model, Integer fruit_id, Integer country_id) {
		model.addAttribute("fruit", fruitMapper.get(fruit_id));
		model.addAttribute("countries", countryMapper.getAll()); // 외래키는 샐렉을 해서 줄 수 있도록 해야한다.	
	}
	*/
	
	@GetMapping("/fruit/update")
	public String updateForm(Model model, Integer fruit_id, Integer country_id) {
		int result = fruitService.updateForm(model, fruit_id);
		
		if(result == 1) {
			return "/fruit/update";
		} else {
			return "redirect:/fruit/list";
		}
		
	}
/*
	@PostMapping("/fruit/update")
	public String update(FruitDTO dto) {
		//int row = fruitMapper.update(dto);
		int row = fruitMapperXML.updateFruit(dto);
		return "redirect:/fruit/list";
	}
*/	
	@PostMapping("/fruit/update")
	public String update(FruitDTO dto, RedirectAttributes rattr) {
		int result = fruitService.update(dto);
		
		if(result == 1) {
			return "redirect:/fruit/list";
		} else {
			rattr.addAttribute("fruit_id", dto.getFruit_id());
			return "redirect:/fruit/update";
		//return "redirect:/fruit/update?fruit_id=" + dto.getFruit_id();
		}
	}
	
	
	@GetMapping("/fruit/add")
	public String addForm(Model model) {
		return "/fruit/add";
	}
}