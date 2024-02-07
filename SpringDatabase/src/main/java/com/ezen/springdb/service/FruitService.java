package com.ezen.springdb.service;

import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;

public interface FruitService {

	void listFruits(Model model);

	int updateForm(Model model, int fruit_id); // 인터페이스로 만든 후에 인터페이스 구현체를 만든다 (FruitServiceImpl)
	
	int update(FruitDTO dto);

	int add(FruitDTO dto);
}