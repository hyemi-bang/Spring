<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 삭제페이지</title>
</head>
<body>
	<h1>과일 삭제</h1>
	<form action="./delete" method="post">
		<table border="3">
			<tr>
				<th>과일번호</th>
				<td><input type="text" name="fruit_name"
					value="${fruit.fruit_id}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="삭제하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>
