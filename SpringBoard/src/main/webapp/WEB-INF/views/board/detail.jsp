<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>${board.board_id}������ ����</title>
</head>
<body>
	<h3>${board.board_id}������ ����</h3>

	<table border="3">
		<tr>
			<th>�� ��ȣ</th>
			<td>${board.board_id}</td>
		</tr>
		<tr>
			<th>��ȸ��</th>
			<td>${board.view_count}</td>
		</tr>
		<tr>
			<th>�� ����</th>
			<td>${board.board_title }</td>
		</tr>
		<tr>
			<th>�۾���</th>
			<td>${board.board_writer }</td>
		</tr>
		<tr>
			<th>��й�ȣ</th>
			<td><input type="password" /></td>
		</tr>
		<tr>
			<th>�۳���</th>
			<td><textarea cols="30" rows="10">${board.board_content}</textarea></td>
		</tr>
		<tr>
			<th>�ۼ���</th>
			<td>${board.write_date }</td>
		</tr>
		<tr>
			<th>�ֱ� ������</th>
			<td>??</td>
		</tr>
		<tr>
			<th>÷������</th>
			<td><input type="file" /></td>
		</tr>

	</table>

</body>
</html>