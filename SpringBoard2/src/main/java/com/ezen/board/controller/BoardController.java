package com.ezen.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	//게시판 메인페이지
	@GetMapping("/")
	public String index() {
		return "/board/index";
	}

	// 게시판1의 목록페이지
	@GetMapping("/list")
	public String list(Model model) {
		boardService.list(model);
		return "/board/list";
	}

	// 게시판 타이틀 클릭했을때 보이는 글 상세페이지
	// a href="./detail?board_id=${bid}" ->해당 번호를 입력했을때 나와야하는 부분
	@GetMapping("/detail")
	public String detail(int board_id, Model model) {

		boardService.detail(board_id, model);

		return "/board/detail";
	}

	// 게시글 작성폼을 보여준다
	@GetMapping("/write")
	public String writeForm() {
		return "/board/writeForm";
	}

	// 작성한 게시글 처리를 해준다
	@PostMapping("/write")
	public String write(BoardDTO dto, RedirectAttributes rattr) {
		int board_id = boardService.write(dto);

		if (board_id > 0) {
			rattr.addAttribute("board_id", board_id);
			return "redirect:/board/detail";
		} else {
			return "redirect:/board/writeFail";
		}
		//브라우저가 해당 데이터를 POST 방식으로 서버에 전송 
		//그러면 이 메서드가 호출되어 게시글 작성을 처리하고, 작성이 성공하면 해당 게시글의 상세 페이지로 리다이렉트한다.
	}
	//두 메서드가 같은 URL(/board/write)을 사용하는 이유
	//하나는 폼을 보여주는 용도(GET), 다른 하나는 폼에서 제출된 데이터를 처리하는 용도(POST)로 구분
	

}