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

	<hr>
	<c:forEach items="${replies}" var="reply">
		<div>
			[${reply.reply_writer}] ${reply.reply_content} <span>${reply.reply_date}</span>
		</div>
		<form action="./reply/update" method="POST">
			<input type="hidden" name="reply_id" value="${reply.reply_id}" />
			<input type="submit" value="�����ϱ�" />
		</form>
	</c:forEach>

	<form action="./reply" method="POST">
		<table border="2">
			<tr>
				<th>�۾���</th>
				<td><input name="board_writer" type="text" /></td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input name="board_password" type="password" /></td>
			</tr>
			<tr>
				<th>�۳���</th>
				<td><textarea name="board_content" cols="20" rows="10"></textarea></td>
			</tr>
			<tr>
				<th></th>
				<td>
				<input type="hidden" name="board_id"value="${board.board_id}" />
				<input type="submit" value="��۴ޱ�" />
				</td>

			</tr>
		</table>
	</form>



</body>
</html>