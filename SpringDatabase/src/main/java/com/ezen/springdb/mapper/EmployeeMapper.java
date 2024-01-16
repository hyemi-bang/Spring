package com.ezen.springdb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ezen.springdb.dto.EmployeeDTO;

public interface EmployeeMapper {

	@Select("SELECT * FROM employees") // select어노테이션과 쿼리문을 적으면 자동으로 생성해다 준다.
	List<EmployeeDTO> getAll();
}
