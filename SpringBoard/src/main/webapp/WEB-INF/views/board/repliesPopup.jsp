<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>repliesPopup.jsp</title>
</head>
<body>



	<script>
		function openRepliesPopup(boardId) {
			var popupUrl = '/replies/' + boardId;
			window.open(popupUrl, 'RepliesPopup', 'width=500, height=500');
		}
	</script>
	
	
</body>
</html>