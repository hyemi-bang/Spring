package com.ezen.board.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ezen.board.dto.ReplyDTO;


public interface ReplyService {

	List<ReplyDTO> getRepliesAll(int board_id);
	
	void getAll(int board_id, Model model);

    int addReply(ReplyDTO replyDTO);
}