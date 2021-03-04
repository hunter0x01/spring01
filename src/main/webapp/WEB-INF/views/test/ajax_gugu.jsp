<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Gugudan</title>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>

$(function(){
	$("#button1").click(function(){
		dan=$("#dan").val();
		param={"dan":dan};

		$.ajax({
			type: "post",
			url: "ajax_gugu_result.do",
			data: param,
			success: function(result){
					$("#result").html(result);
				}
			}); // $.ajax(
		}); //$("#button1").click(
}); //$(function
</script>
</head>
<body>
	<h2> 구구단 계산</h2>
	단을 입력하세요 <input type="number" id="dan" value="3">
	<input type="button" id="button1" value="확인">
	<div id="result"></div>
</body>
</html>