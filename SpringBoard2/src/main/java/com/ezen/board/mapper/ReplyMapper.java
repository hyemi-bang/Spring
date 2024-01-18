package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.ReplyDTO;

public interface ReplyMapper {

	List<ReplyDTO> getAll(int board_id);

	int insert(ReplyDTO replyDTO);

	List<ReplyDTO> getRepliesAll(int board_id);
	
}
