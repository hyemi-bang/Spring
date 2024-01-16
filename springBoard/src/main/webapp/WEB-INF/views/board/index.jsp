<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 웹 사이트</title>
<link rel="stylesheet" href="./board/css/index.css">
</head>
<body>


    <h1>board list</h1>

    <div class="grid-container headers">
        <div class="grid-item"><strong>No.</strong></div>
        <div class="grid-item"><strong>Title</strong></div>
        <div class="grid-item"><strong>Writer</strong></div>
        <div class="grid-item"><strong>Timestamp</strong></div>
        <div class="grid-item"><strong>View</strong></div>
	</div>
	<div class="grid-container">
        <c:forEach items="${boards}" var="board">
            <div class="grid-item">${board.board_id}</div>
            <div class="grid-item"><a href="./detail?board_id=${board.board_id}">${board.board_title}</a></div>
            <div class="grid-item">${board.board_writer}</div>
            <div class="grid-item">${board.write_date}</div>
            <div class="grid-item">${board.view_count}</div>
        </c:forEach>
    </div>

    <button id="writeBtn">글쓰기</button>

    <c:url value="/resources/board/js/index.js" var="indexJS"></c:url>
    <c:url value="./write" var="writePageURL"></c:url>

    <script>
        const writePageURL = '${writePageURL}';
    </script>

    <script src="${indexJS}"></script>


</body>
</html>