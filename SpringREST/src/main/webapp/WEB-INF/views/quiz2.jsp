<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/js/quiz2.js" var="quiz2JS" />
<c:url value="/resources/css/quiz2.css" var="quiz2CSS" />
<link rel="stylesheet" href="${quiz2CSS}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과일 테이블 QUIZ</title>
</head>
<body>

	<h3>REST방식으로 INSERT, UPDATE, DELETE 구현</h3>

	<div>
	<button id="listAll">과일목록</button>
	</div>
	
	<h1>과일 목록</h1>
	<div id="fruitsJson"></div>
	
	<button id="quiz2-1">Fruit Isert</button>
	<hr />
	<input id="modify-fruit-id" type="number"> <!--  왜 쓰는지 ? -->
	<button id="quiz2-2">Fruit Update</button>
	<hr />
	<button id="quiz2-3">Fruit Delete</button>

	<script src="${quiz2JS}"></script>

</body>
</html>