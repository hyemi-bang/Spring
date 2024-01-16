package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ezen.springdb.dto.FruitDTO;

public interface FruitMapperXML {
	
	//어노테이션 사용하지 않는다
	// XML 내용은 main/resources의 동일한 폴더와 같은 이름의 xml파일을 만든다
	// 동일한 위치와 이름이여야 mybatis-spring이 찾아갈 수 있다.

   List<FruitDTO> getAll();
   
   FruitDTO get(int fruit_id);

   int add(FruitDTO dto);
   
   int updateFruit(FruitDTO fruit);
   
   int delete(int fruit_id);
}