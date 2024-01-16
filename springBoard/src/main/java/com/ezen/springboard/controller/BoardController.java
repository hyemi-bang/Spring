package com.ezen.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.springboard.mapper.BoardMapper;
import com.ezen.springboard.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {

	@Autowired
	BoardMapper board;

	@Autowired
	BoardService boardService;

	@GetMapping("/board/index")
	public void list(Model model) {
		boardService.boardIndex(model);
	}

}
