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
		url:"/api/data5",
		success : function(json){
			//확인사항 : url에서 전달되는 값이 문자열인지, 객체인지에 따라 달라진다.
			//문자열인 경우 객체로 변환
			//json=JSON.parse(json);			
			//객체인 경우에는 변환필요없음			
			//Q.json변수의 내용이 문자열인지 객체인 확인하는 코드 찾기
			if(typeof json ==="string"){
				json=JSON.parse(json);
			}else if(typeof json ==="object"){
				if(json===null){}
				else if(Array.isArray(json)){
					$("#content").text(json);
					$("#name").text(json[0]["name"]);
					$("#age").text(json[0]["age"]);
					$("#name").append(json[1]["name"]);
					$("#age").append(json[1]["age"]);
					$("#name").append(json[2]["name"]);
					$("#age").append(json[2]["age"]);
					return;
				}
				else{}
			}
			
			$("#name").text(json["name"]);
			$("#age").text(json["age"]);
			/*
			$("#name").text(json.name);
			$("#age").text(json.age);
			*/
		}
	});
});
</script>
</head>
<body>
<h1>respapi 메인페이지 입니다.</h1>
<div id="content"></div>
<lable>이름:</lable><span id="name"></span><p>
<lable>나이:</lable><span id="age"></span><p>
</body>
</html>


