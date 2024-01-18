package com.ezen.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ezen.board.dto.ReplyDTO;
import com.ezen.board.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;

    @Override
    public void getAll(int board_id, Model model) {
    	model.addAttribute("reply", replyMapper.getAll(board_id));
    }

    @Override
    public int addReply(ReplyDTO replyDTO) {
        int result = replyMapper.insert(replyDTO);

        if (result == 1) {
            return replyDTO.getReply_id();
        } else {
            return result;
        }
    }
}