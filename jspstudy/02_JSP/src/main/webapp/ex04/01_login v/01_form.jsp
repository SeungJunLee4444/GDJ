<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 로그인 성공시 session에 id, pwd 저장된 상태임 -->
	<%
		// => 저장된 아이디, 비밀번호 꺼내보기
		Object id = session.getAttribute("id");
		Object pwd = session.getAttribute("pwd");
		
		// object는 null 포함, string은 null이 없음
		
		
		
		
		/* 
		
		& null : 서브밋하기 전 최초
		& 빈문자열 : 아무런 값을 입력안하고 서브밋 했을 떄
		
		& isempty / null => 구분하기공부필요
		"" null
		isemply() == null */
	%>
	<% if(id != null && pwd != null) { %>
	<!-- & el 은 4개의 영역에 저장된 경우에만 접근 가능하다  -->
		${id}님 환영합니다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- => 02_login에서 session으로 집어넣는 id파라미터값 -->
		<input type="button" value="로그아웃" id="btn_logout">
		<% } else { %>	
		<div>
			<form method="POST" action="02_login.jsp">
				<div>
					<input type="text" name="id" placeholder="아이디">
				</div>
				<div>
					<input type="password" name="pwd" placeholder="비밀번호">
				</div>
				<div>
					<button>로그인</button>
				</div>
			</form>
		</div>
	<% } %>
	
	<script>
		document.getElementById("btn_logout").onclick = function(event) {
			location.href = '03_logout.jsp';
		}
	</script>
		
	
	
	
	
	
</body>
</html>