<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
		1. JSP의 binding 영역 4개
			1) application : 서블릿 ServletContext와 같은 영역	// => 웹 브라우저가 종료되면 데이터가 초기화
			2) session		: 서블릿 HttpSession과 같은 영역	// => 웹 브라우저를 닫기 전까지 페이지를 이동해도 정보 유지
			3) request		: 서블릿 HttpServletRequest와 같은 영역
	 		4) pageContext	: 하나의 JSP 페이지에서 접근 가능한 영역
	 		=> 4개의 영역 안에 존재하지않는건 el로 표현할 수 없다
	 		=> 일반 자바변수
	 
	 	2. 표현언어(el)
	 	- 표현식(<%=자바변수,함수%>을 대체하기 위한 언어
	 	- 형태 ${값}
	 	// => 식이 복잡하니 간단한 디자인 언어로 표현
	 --%> 
	 
	 <!-- 1) 저장 -->
	 <%
	 	application.setAttribute("a", 1);
	 	session.setAttribute("b", 2);
	 	request.setAttribute("c", 3);
	 	pageContext.setAttribute("d", 4);
	 %>
	 
	 <!-- 2) 표현식으로 속성접근  -->
	 <div>a : <%=application.getAttribute("a") %></div>
	 <div>b : <%=session.getAttribute("b") %></div>
	 <div>c : <%=request.getAttribute("c") %></div>
	 <div>d : <%=pageContext.getAttribute("d") %></div>
	 
	 <!-- 2.2)표현언어(표현식 접근과 동일) -->
	 <div>a: ${a}</div>
	 <div>b: ${b}</div>
	 <div>c: ${c}</div>
	 <div>d: ${d}</div>
	 
	 <!-- 2. 우선순위 
	 	- 같은 이름의 속성이 서로 다른 영역에 저장된 경우, 
	 	   먼저 사용되는 우선순위가 있다
	 	- 우선순위 pageContext > request > session > application
	 	- 각 영역을 지정하는 표현언어(el)의 내장객체가 존재함
	 		(1) pageScope
	 		(2) requestScope
	 		(3) sessionScope
	 		(4) applicationScope
	 -->
	 
	 <%
	 	application.setAttribute("movie", "기생충");
	 	session.setAttribute("movie", "터미네이터");
	 	request.setAttribute("movie", "아바타");
	 	pageContext.setAttribute("movie", "미나리");
	 %>
	 <div>application's movie : ${applicationScope.movie}</div>
	 <div>session's movie : ${sessionScope.movie}</div>
	 <div>request's movie : ${requestScope.movie}</div>
	 <div>pageContext's movie : ${movie}</div>
	 <!-- => 같은 이름의 속성을 사용하였으나, 우선순위상 모든 속성의 값은 미나리
	 	=> 다른값들은 사라지지않고, 다른곳에 저장되있음
	 	=> 이때 우선순위에 밀린 기존의 속성값을 확인할 때 우선순위 내장객체를 사용한다
	 	
	   -->


</body>
</html>