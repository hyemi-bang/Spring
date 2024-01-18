package com.ezen.board.mapper;

import java.util.List;

import com.ezen.board.dto.BoardDTO;

public interface BoardMapper {
	
	List<BoardDTO> getAll();

	BoardDTO get(int board_id);

	int insert(BoardDTO dto);
}