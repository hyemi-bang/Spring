package com.ezen.board.service;

import org.springframework.ui.Model;

import com.ezen.board.dto.ReplyDTO;


public interface ReplyService {

	void getAll(int board_id, Model model);

    int addReply(ReplyDTO replyDTO);
}