<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
		1. 가능한 작업
		- java 변수를 javascript에서 표현식으로 사용할 수 있다
		=> 자바변수를 자바스크립트에서도 인식해서 사용가능하다		
	 -->
	 <% 
	 	// 1) 자바 변수
	 	String name = "가나다";
	 	int age = 44;
	 %>
	 <script>
	 	// 2) 자바변수를 스크립트 변수에 저장
	 	var name = '<%=name%>';
	 	var age = <%=age%>;
	 	alert(name + ', ' + age);
	 </script>
	 
	 
	<!-- 2. 불가능한 작업 : 자바스크립트 변수를 자바에서 사용하려는 경우 
	=> 반대는 안됨
	-->
	
	<script>
		var address = '서울시';
	</script>
	<%-- 	
	<div><%=address%></div>
	 --%>
	 
	 
		
		 
	 
	 
	 
	 
	
</body>
</html>