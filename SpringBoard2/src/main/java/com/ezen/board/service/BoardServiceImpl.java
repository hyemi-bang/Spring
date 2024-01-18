package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.BoardDTO;
import com.ezen.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public void list(Model model) {
		//model.addAttribute("boards", boardMapper.getAll());
		//boardMapper.getAll()을 할때 업그레이드 된 getAll이 필요하다 왜냐햐면 댓글을 봐야하기때문
	      model.addAttribute("boards",boardMapper.getAllWithReplyCount());
	}

	@Override
	public boolean detail(int board_id, Model model) {
		BoardDTO board = boardMapper.get(board_id);

		if (board != null) {
			model.addAttribute("board", board);
			return true;
		} else {
			return false;
		}

	}

	/** insert 성공 시 pk를 반환 실패시 0을 반환 */
	@Override
	public int write(BoardDTO dto) {
		int result = boardMapper.insert(dto);
		
		if (result == 1) {
			return dto.getBoard_id();
		} else {
			return result;
		}
	}

}