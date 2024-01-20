<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/js/quiz.js" var="quizJS" />
<c:url value="/resources/css/quiz.css" var="quizCSS" />
<link rel="stylesheet" href="${quizCSS}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
</head>
<body>

	<h1>Quiz</h1>
	<div>
		<h3>추첨 버튼을 누르면 랜덤으로 10명의 사원을 골라와서 화면에 출력해주는 기능을 만들기
			 JSON 버전과 XML버전으로 한번씩 만들기</h3>
	</div>

	<div>
		<button id="jsonBtn">json 추첨</button>
		<button id="xmlBtn">xml 추첨</button>
	</div>
	
    <div id="randomEmployeesJson"></div>

    <div id="randomEmployeesXml"></div>

	<script src="${quizJS}"></script>

</body>
</html>