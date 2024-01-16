package com.ezen.springboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.springboard.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper board;
	
	@Override
	public void boardIndex(Model model) {
		model.addAttribute("boards", board.getAll());
		
	}

	

}

