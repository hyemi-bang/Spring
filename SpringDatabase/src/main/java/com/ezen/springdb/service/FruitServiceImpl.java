package com.ezen.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapperXML;

@Service
public class FruitServiceImpl implements FruitService {

	@Autowired
	FruitMapperXML fruitMapper;
	@Autowired
	CountryMapper countryMapper;

	@Override
	public int updateForm(Model model, int fruit_id) {
		FruitDTO fruit = fruitMapper.get(fruit_id);

		if (fruit == null) {
			return -1;
		}

		model.addAttribute("fruit", fruit);
		// List<CountryDTO> countries = countryMapper.getAll();
		model.addAttribute("countries", countryMapper.getAll());

		return 1;
	}

	@Override
	public void listFruits(Model model) {
		model.addAttribute("fruits", fruitMapper.getAll());

	}

	@Override
	public int add(FruitDTO dto) {

		int result = fruitMapper.add(dto);

		if (result > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int update(FruitDTO dto) {
		return fruitMapper.updateFruit(dto);
	}
}