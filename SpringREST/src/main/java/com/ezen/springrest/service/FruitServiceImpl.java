package com.ezen.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.springrest.dto.FruitDTO;
import com.ezen.springrest.mapper.FruitMapper;

@Service
public class FruitServiceImpl implements FruitService {

	@Autowired
	FruitMapper fruitMapper;

	@Override
	public List<FruitDTO> getAll() {

		List<FruitDTO> fruits = fruitMapper.getAll();
		return fruits;
	}

}
