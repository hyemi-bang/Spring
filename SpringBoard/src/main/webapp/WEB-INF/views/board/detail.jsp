<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>${board.board_id}번글의 내용</title>
</head>
<body>
	<h3>${board.board_id}번글의 내용</h3>

	<table border="3">
		<tr>
			<th>글 번호</th>
			<td>${board.board_id}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.view_count}</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td>${board.board_title }</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${board.board_writer }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" /></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea cols="30" rows="10">${board.board_content}</textarea></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.write_date }</td>
		</tr>
		<tr>
			<th>최근 수정일</th>
			<td>??</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" /></td>
		</tr>

	</table>

</body>
</html>