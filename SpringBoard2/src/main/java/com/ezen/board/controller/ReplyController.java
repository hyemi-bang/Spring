package com.ezen.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.service.ReplyService;

@RequestMapping("/reply")
@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;

	// 댓글 보여주기

	@GetMapping("/listReplies")
	public String listReplies(@RequestParam("board_id") int boardId, Model model){
		// board_id라는 파라미터를 이용하여 어떤 게시글의 댓글 목록을 가져올지 보기위함
		List<ReplyDTO> dto = replyService.getRepliesAll(boardId);
		model.addAttribute("replies", dto);
		return "/board/listReplies";
		
	}
	// 댓글 목록 <div class="reply/list">

	
	
	//댓글 추가로직
	// 댓글 작성 <form action="./reply/form" method="post">
	
	//댓글 수정로직
	//댓글 수정 <form action="./reply/update" method="POST">

	//댓글 삭제로직
	

}
