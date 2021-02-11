<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>

<jsp:include page="include/menu.jsp"/>
<h2> name : ${name}</h2>
<h2> message : ${message}</h2>
<br><a href='/gugu.do'>구구단</a>
</body>
</html>