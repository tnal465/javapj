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
	//자바스크립트는 네트워크로 데이터 전송할 때 반드시 문자열로 전송
	//객체로 전송하면 오류발생, 원인은 문자열로 치환해주는 라이브러리 존재하지 않아서임.
	//객체를 문자열로 변경하는 함수JSON.stringify(객체)
	/*
	curl http://localhost:8080/restapi/member -v -X POST -d "{\"username\": \"hongkildong\", \"password\":\"1234\", \"email\":\"hong@gmail.com\"}" -H "Content-Type: application/json;charset=UTF-8"
	*/
	/*
	$.ajax({
		url:"/restapi/member",
		method:"post",
		data:JSON.stringify(
		{username: "hongkildong", password:"1234", email:"hong@gmail.com"}
		),
		headers: {"Content-Type": "application/json;charset=UTF-8",},
		success:function(result){
			$("#result").text(result);
		}
	});
	*/
	
	
	//get : 문자열을 전송할 경우 ?를 이용한다.
	//curl http://localhost:8080/restapi/member?username=admin -v -X GET -H "Content-Type:text/plain;charset=UTF-8"
	/*
	$.ajax({
		url:"/restapi/member?username=admin",
		method:"get",
		headers: {"Content-Type": "text/plain;charset=UTF-8",},
		dataType: "json",
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	*/
	
	//get : path를 이용하여 처리하는 방법
	//curl http://localhost:8080/restapi/member/admin -v -X GET	-H "Content-Type:text/plain;charset=UTF-8"-H "Accept: application/json"
	/*
	$.ajax({
		url:"/restapi/member/admin",
		method:"get",
		headers: {"Content-Type": "text/plain;charset=UTF-8",},
		dataType: "json",
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	*/
	
	//예제)
	//전체리스트 curl, ajax처리
	//삭제하기 curl, ajax처리	
	//수정하기 curl, ajax처리
	
	//전체리스트
	//curl http://localhost:8080/restapi/members -v -X GET
	// -H "Content-Type:application/json;charset=UTF-8"
	// -H "Accept: application/json"
	/*
	$.ajax({
		url:"/restapi/members",
		method:"get",
		headers: {"Content-Type":"application/json;charset=UTF-8",},
		dataType: "json",
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	*/
	
	//수정하기 curl, ajax처리
	//curl http://localhost:8080/restapi/member -v -X PUT 
	//-d "{\"username\": \"hongkildong\", \"password\":\"1111\", \"email\":\"hong@gmail.com\"}"
	//-H "Content-Type:application/json;charset=UTF-8"
	/*
	//객체를 문자열로 변환하여 처리
	$.ajax({
		url:"/restapi/member",
		method:"put",
		contentType:"application/json",
		data:JSON.stringify(
				{username: "hongkildong", password:"1234", email:"hongex@gmail.com"}
				), 
		headers: {"Content-Type": "application/json;charset=UTF-8",},
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	*/
	//객체를 바로 처리하는 방법
	//localhost:8080/member?username=xxxx&password=xxxx&email=xxx
	//바인딩 오류발생하므로 확인 필요
	/*
	$.ajax({
		url:"/restapi/member",
		method:"put",
		contentType:"application/x-www-form-urlencoded",
		data:{username:"hongkildong", password:"1111", email:"hongex@gmail.com"}, 
		headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"},
		
		success:function(result){
		console.log(result)
		$("#result").text(result);
		},
		
		error : function(xhr, status, error){
			console.error("ERROR:"+error)
			$("#result").text("에러발생");	
		}
});
	*/
	
	
	//삭제하기
	//curl http://localhost:8080/restapi/member?username=hongkildong -v -X DELETE -H "text/plain;charset=UTF-8"
	//curl http://localhost:8080/restapi/member/hongkildong -v -X DELETE -H "text/plain;charset=UTF-8"
	/*
	$.ajax({
		url:"/restapi/member?username=hongkildong",
		method:"delete",
		headers: {"Content-Type": "text/plain;charset=UTF-8",},
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	
	$.ajax({
		url:"/restapi/member/hongkildong",
		method:"delete",
		headers: {"Content-Type": "text/plain;charset=UTF-8",},
		success:function(result){
			console.log(result)
			$("#result").text(result);
		}
	});
	*/
});
</script>
</head>
<body>
<h1>member restapi</h1>
<div id="result"></div>

</body>
</html>