package com.ezen.springboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ezen.springboard.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	
	 @Select("SELECT * FROM myboard")
	   List<BoardDTO> getAll();
	 
	 @Select("SELECT * FROM myboard WHERE board_id=#{id}")
	 BoardDTO get(@Param("id")int board_id);
	   
	 @Select("SELECT board_title FROM myboard")
	 List<String> listBoardTitles();
}
