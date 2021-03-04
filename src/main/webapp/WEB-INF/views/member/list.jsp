<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- tag 라이브러리 Ctrl+Space  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--  날짜 출력 포멧 지정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<input type="button" value="회원등록" onclick="location.href='/member/write.do'">
<table border="1" width="700px">
<tr>
<td>아이디</td>
<td>이름</td>
<td>이메일</td>
<td>가입일자</td>
</tr>

<c:forEach var="row" items="${list}">
 <tr>
	 <td>${row.userid}</td>
	 <td>${row.name}</td>
	 <td>${row.email}</td>
	 <td><fmt:formatDate value="${row.join_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
 </tr>
</c:forEach>
 
</table>
</body>
</html>