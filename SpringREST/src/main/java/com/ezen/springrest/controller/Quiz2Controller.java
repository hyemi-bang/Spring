package com.ezen.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springrest.dto.FruitDTO;
import com.ezen.springrest.service.FruitService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/quiz2")
@RestController
public class Quiz2Controller {

	@Autowired
	FruitService fruitService;

	@GetMapping(value = "/fruits", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FruitDTO> list() {
		List<FruitDTO> fruits = fruitService.getAll();

		return fruits;
	}
	
	@PostMapping("/fruit")
	public ResponseEntity<String> insertFruit(
			@RequestBody FruitDTO fruit){
		log.info("POST:" + fruit);
		// 여기에서 DB저장 추가해야한다
		
		return ResponseEntity.ok("ABC");
	}
	@PutMapping("/fruit/{fruit_id}")
	public ResponseEntity<String> updateFruit(
			@PathVariable("fruit_id") Integer furit_id, 
			// id 값을 직접 받아서 사용할 수 있다. 현재는 굳이 필요한 방법은 아니었다.
			// DTO가 아니라 과일 1개만 받고 싶다 했을때는 괜찮은 방법임
			@RequestBody FruitDTO fruit_dto
			){
		log.info("PathVariable:" + furit_id);
		log.info("@RequestBody:" + fruit_dto);
		
		// 여기에서 DB 수정부분 추가해야한다
		
		return ResponseEntity.ok("OK!"); // 리스폰스 텍스트 인거지~ 
	}

}
