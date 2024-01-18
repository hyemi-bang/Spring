package com.ezen.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.service.BoardService;
import com.ezen.board.service.ReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	ReplyService replyService;

	@GetMapping("/")
	public String index() {
		return "/board/index";
	}

	@GetMapping("/list")
	public String list(Model model) {
		boardService.list(model);
		return "/board/list";
	}
//   public String list(Model model) {
//	   List<BoardDTO> boards = boardService.list(model);
//
//	    for (BoardDTO board : boards) {
//	        int replyCount = replyService.getReplyCountByBoardId(board.getBoard_id());
//	        board.setReply_count(replyCount);
//	    }

//	    model.addAttribute("boards", boards);
//	    return "/board/list";
//	}

	// a href="./detail?board_id=${bid}" ->해당 번호를 입력했을때 나와야하는 부분
	@GetMapping("/detail")
	public String detail(int board_id, Model model) {

		boardService.detail(board_id, model);

		return "/board/detail";
	}

	@GetMapping("/write")
	public String writeForm() {
		return "/board/writeForm";
	}

	@PostMapping("/write")
	public String write(BoardDTO dto, RedirectAttributes rattr) {
		int board_id = boardService.write(dto);

		if (board_id > 0) {
			rattr.addAttribute("board_id", board_id);
			return "redirect:/board/detail";
		} else {

			return "redirect:/board/writeFail";
		}
	}
	

	@PostMapping("/reply")
	public String reply(ReplyDTO replyDTO, RedirectAttributes rattr) {
		log.info(replyDTO.getBoard_id());
		 int board_id = replyService.addReply(replyDTO);

		if (board_id > 0) {
			rattr.addAttribute("board_id", board_id);
			return "redirect:/board/detail";
		} else {
			return "redirect:/board/writeFail";
		}
	}

}