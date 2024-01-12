<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈 형태의 모델 객체</title>
</head>
<body>

	<h3>파라미터 보내는 폼</h3>
	<p>
	파라미터로 보내는 name 값과 이 값을 받는 모델 클래스의 속성 이름이 일치하면 알아서 자동으로 바인딩 해준다.
	이름이 다르거나 오류가 생길경우 null값이 호출된다
	</p>

	<form action="./parameter" method="POST">
		DEPT_NO:<input type="text" name ="department_id" value="50"/>
		DEPT_NAME: <input type="text" name="department_name" value="IT Programmer" />
		MGR_NO:<input type="text" name="manager_id" value="105" />
		LOC_NO:<input type="text" name="location_id" value="130" />
		<input type="submit" value="컨트롤러로 보내기"/>
	</form>
	
	<hr>
	
	<form action="./para2" method="POST">
		EMPLOYEE_ID: <input type="text" name="employee_id" value="135" />
		<input type="submit" value="보내기" />
	</form>
	
	<hr>
	
	<form action="./para3" method="POST">
		EMP_ID: <input type="text" name="employee_id" value="122" />
		<input type="submit" value="보내기" />
	</form>
</body>
</html>