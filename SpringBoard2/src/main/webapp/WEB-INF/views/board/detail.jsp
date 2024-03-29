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
	<hr>
	
		<!-- 댓글 목록 표시 부분 -->
		<c:if test="${not empty replies}">
		    <div class="reply-list">
		        <h2>댓글 목록</h2>
		        <ul>
		            <c:forEach items="${replies}" var="reply">
		                <li>
		                    <div>${reply.reply_writer}</div>
		                    <div>${reply.reply_content}</div>
		                    <div>${reply.reply_date}</div>
		                </li>
		            </c:forEach>
		            <form action="./reply/update" method="POST">
					<input type="hidden" name="reply_id" value="${reply.reply_id}" />
					<input type="submit" value="수정하기" />
					</form>
		        </ul>
		    </div>
		</c:if>

	<!-- 댓글 작성 폼 부분 -->
	<div class="reply-form">
	    <h2>댓글 작성</h2>
	    <form action="./reply" method="post">
	    <table border="2">
			<tr>
				<th>글쓴이</th>
				<td><input name="board_writer" type="text" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="board_password" type="password" /></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea name="board_content" cols="20" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
		        <input type="hidden" name="board_id" value="${board.board_id}" />
		        <input type="submit" value="댓글 작성" />
		        </td>
	        </tr>
	       </table>
   		 </form>
	</div>
	
	
</body>
</html>