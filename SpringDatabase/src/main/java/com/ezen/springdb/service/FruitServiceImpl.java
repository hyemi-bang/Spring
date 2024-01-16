package com.ezen.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springdb.dto.FruitDTO;
import com.ezen.springdb.mapper.CountryMapper;
import com.ezen.springdb.mapper.FruitMapperXML;

@Service
public class FruitServiceImpl implements FruitService{
   
   @Autowired
   FruitMapperXML fruitMapper;
   
   @Autowired
   CountryMapper countryMapper;
   
   @Override
   public int updateForm(Model model, int fruit_id) {
      
      System.out.println("과일번호"+fruit_id);
      FruitDTO fruit = fruitMapper.get(fruit_id,model);
      if(fruit==null) {
         return -1;
      }
      model.addAttribute("fruit",fruit);
      model.addAttribute("countries", countryMapper.getAll());
      return 1;
      
   }
   
   @Override
   public List<FruitDTO> list(Model model) {
      List<FruitDTO> fruit = fruitMapper.getAll();
      
      return fruit;
   }

@Override
public void list(Model model) {
	 model.addAttribute("fruits", fruitMapper.getAll());
	
}

@Override
public int update(FruitDTO dto) {
	// TODO Auto-generated method stub
	return 0;
}
}