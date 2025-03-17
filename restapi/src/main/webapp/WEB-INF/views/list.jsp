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
		url:"/api/data4",
		success : function(json){
		//Q.result 태그안에 테이블을 만들고 json으로 전달받은 데이터를 처리하시오.
		//확인사항:jquery를 이용하여 테이블 생성, td에 json전달받은 값을 해석 출력
			var table = $('<table border="1"></table>');
			var row = $('<tr></tr>');
			row.append('<td>이름</td><td>나이</td>');
			table.append(row);
			for(let item of json){
				console.log(item);
				var drow = $('<tr></tr>');
				drow.append(`<td>\${item.name}</td><td>\${item.age}</td>`);
				table.append(drow);
			}
			$('#result').append(table);
		}});
});

</script>
</head>
<body>
<h1>restapi를 이용하여 화면 구현</h1>
<div id="result">
<!--
<table>
<tr><td>이름</td><td>이름</td></tr>
<tr><td>kildong</td><td>23</td></tr>
<tr><td>park</td><td>50</td></tr>
</table>
-->
</div>
</body>
</html>