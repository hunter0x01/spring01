<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(function(){ // 페이지가 로딩되면 자동 실행

	// id가 btnLogin인 버튼을 누르면
	$("#btnLogin").click(function(){

		//태그에 입력한 값
		id=$("#id").val();
		pw=$("#pw").val();
		param={"id":id, "pw":pw};

		//비동기식 호출 async
		$.ajax({
			type: "post",
			url: "login_result.do",
			data: param,
			success: function(result){
					$("#result").html(result);
				}
			});
		});
});
</script>
</head>
<body>

id : <input id="id">
pw : <input type="password" id="pw">

<input type="button" id="btnLogin" value="로그인">

<div id="result"></div>
</body>
</html>