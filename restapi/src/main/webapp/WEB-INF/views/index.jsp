<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<script>
	$(document).ready(function() {
	    // 특정 요소에 클릭 이벤트 바인딩
	    $("#someButton").click(function() {
	        alert("버튼이 클릭되었습니다!");
	    });
	});
	$(function(){
		//회원가입 - regbtn을 눌렀을 때
		//$("#regbtn").click(); 이걸 눌렀을 때 뭔가 작동해야한다 ==> function추가
		$("#regbtn").click(function(){

			//정보를 획득
			let username = $("#username").val();
			let password = $("#password").val();
			let email = $("#email").val();
			
			//정보를 처리(ajax)
			$.ajax({
				url:"/restapi/member",
				method:"post",
				data:JSON.stringify(
				{username: username, password:password, email:email}
				),
				headers: {"Content-Type": "application/json;charset=UTF-8",},
				success:function(result){
					alert("회원가입 성공")
				}
			});
				
			
			
			
			
		});

		
		
		
		//회원정보 전체출력 - 회원전체 출력버튼을 클릭했을 때
		$("#listbtn").on("click",function(){
			$.ajax({
				url: "/restapi/members",
				method: "get",
				headers:{"Content-Type":"application/json;charset=UTF-8",},
				dataType:"json",
				success:function(result){
					$("#tbody").empty();
					for(let item of result){
						var row = $(`<tr class="child" id="\${item.username}"></tr>`);

						row.append(`<td>\${item.username}</td><td>\${item.email}</td><td>\${item.regdate}</td>
									<td><button class="childbtn">수정</button><button class="childbtn">삭제</button></td>`);
						$("#tbody").append(row);
						
					}
				}
			});
		});
	
		
		//회원정보 상세보기 - 회원목록에서 특정 행을 클릭했을 때
		//Q. jquery에서 append한 태그를 이벤트 처리 가능하게 하는 방법은? -- class추가
		//Q. 수정 삭제버튼이 있는 td는 이벤트가 실행되지 않게 처리하는 방법은? (4열의 td이벤트만 제거하는 방법) -- event.target.closest
		$("#tbody").on("click",".child",function(){
			if(event.target.closest("button")){
				return;
			}
			// alert(this.id);
			
			let username = this.id;
			//ajax를 이용하여 username을 통한 restapi로 member값 가져온 후 폼에 입력
			$.ajax({
				url: `/restapi/member/\${username}`,
				method: "get",
				headers:{"Content-Type":"text/plain;charset=UTF-8",},
				dataType:"json",
				success:function(member){
					console.log(member);
					$("#username").val(member["username"]);
					$("#password").val(member["password"]);
					$("#email").val(member["email"]);
					
					//멤버입력 -> 멤버상세보기
					//id, password, email 편집창을 disabled변경
					//회원가입은 표시 안되도록 설정
					//$("fieldset:first>legend").text("멤버상세보기");
					$("fieldset").eq(0).find("legend").text("멤버상세보기");
					$("#username").prop("disabled",true);
					$("#password").prop("disabled",true);
					$("#email").prop("disabled",true);
					$("input[value = '회원가입']").attr("type","hidden"); //attr: 속성값 가져오기 //attr("type","hidden") : 속성을 가져와 type변경
				}
			});
		});
	
		
		//회원수정 - updatebtn을 클릭했을 때
		//버튼의 값이 수정인 객체를 선택.현재 객체의 상위객체인 tr에 id를 획득하시오(버튼위엔 td-> tr이있음) 
		//획득한 값을 이용하여 legend를 멤버 수정으로 변경한 후 수정처리하기
		//추가적으로 테이블에서 td를 편집모드로 변경하고 수정처리하게 만들기
		$("#tbody").on("click",".childbtn",function(event){
			//console.log(event.target);	//순수자바스크립트로 객체 선택
			//console.log($(event.target.closest("tr")).attr("id"));
			//console.log($(event.target).parent().parent().attr("id"));
			let username = $(event.target.closest("tr")).attr("id");
			

			$.ajax({
				url: `/restapi/member/\${username}`,
				method: "get",
				headers:{"Content-Type":"text/plain;charset=UTF-8",},
				dataType:"json",
				success:function(member){
					console.log(member);
					$("#username").val(member["username"]);
					$("#password").val(member["password"]);
					$("#email").val(member["email"]);
					
					$("fieldset").eq(0).find("legend").text("멤버수정");
					$("#username").prop("disabled",false);
					$("#password").prop("disabled",false);
					$("#email").prop("disabled",false);
					$("#regbtn").attr("type","button");
					$("#regbtn").val("수정하기");
				}
			});
		});
		
	});

	//수정처리
	$("#regbtn:[value='수정하기']").click(function(){
		alert("수정하기버튼")

		//정보를 획득
		let username = $("#username").val();
		let password = $("#password").val();
		let email = $("#email").val();
		
		//정보를 처리(ajax)
		$.ajax({
			url:`/restapi/member/\${username}`,
			method:"put",
			data:JSON.stringify(
			{username: username, password:password, email:email}
			),
			headers: {"Content-Type": "application/json;charset=UTF-8",},
			success:function(result){
				alert("수정성공");
				//$("#regbtn").val("회원가입");
			},
			
			error: function(error){
				alert("수정 실패: " + error.responseText);
            }
		});

	})
		
</script>
</head>
<body>
<fieldset>
	<legend>멤버 입력</legend>
	<div>
		<label>아이디</label>
		<input type="text" id="username" value="">
	</div>
	
	<div>
		<label>비밀번호</label>
		<input type="password" id="password" value="">
	</div>
	
	<div>
		<label>이메일</label>
		<input type="email" id="email" value="">
	</div>
	<div>
		<input type="button" id="regbtn" value="회원가입">
	</div>

</fieldset>

<fieldset>
	<legend>회원리스트 </legend>
	<div id="list">
	<button id="listbtn">리스트보기</button>
	<table border="1">
		<thead>
			<tr><th>아이디</th><th>이메일</th><th>등록일</th><th>수정/삭제</th></tr>
		</thead>
		<tbody id="tbody">
			<!-- <tr><td>아이디</td><td>이메일</td><td>등록일</td></tr> -->
		</tbody>
	</table>
	
	</div>
</fieldset>

</body>
</html>