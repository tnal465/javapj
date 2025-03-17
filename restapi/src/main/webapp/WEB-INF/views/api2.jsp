<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
$(function(){
	$.ajax({
		url:"/api2/member",
		method:"delete",
		success:function(result){
			$("#result").text(result);
		}
	});
});
</script>
</head>
<body>
<h1>웹브라우저에서 get, post, put, delete를 처리하는 방법</h1>
<div id="result"></div>
<!-- <form action="/api2/member" method="get"></form> -->
</body>
</html>