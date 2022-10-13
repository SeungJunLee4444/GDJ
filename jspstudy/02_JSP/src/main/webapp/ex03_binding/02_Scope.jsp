<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--[jsp로 해보는 binding]  -->
	 <%
	 	application.setAttribute("a", 1);	// 애플리케이션 종료 전까지
	 	session.setAttribute("b", 2);		// 브라우저 닫기 전까지
	 	request.setAttribute("c", 3);		// 하나의 요청&응답 사이클까지
	 	pageContext.setAttribute("d", 4); 	// 현재 페이지에서만 유지
	 %>
	 
	 <%-- 
	 	& JSP 내장객체
	 	1) request 		: httpServletRequest	- 웹 브라우저 요청정보 저장
	 	2) response		: httpServletResponse	- 웹 브라우저의 요청에 대한 응답정보 저장
	 	3) out			: JspWriter				- jsp 페이지의 출력할 내용을 가지고 잇는 줄거리
	 	4) session		: HttpSession			- 하나의 웹 브라우저 내에서 정보를 유지하기위한 객체
	 	5) application	: ServletContext	- 웹 에플리케이션의 context정보를 담는 객체
	 	
	 	6) pageContext	: PageContext		- jsp 페이지에 대한 정보를 저장하고 있는 객체
	 	7) page
	 	8) config
	 	9) exception	:					- 예외
	 	
	 	- 
	 
	 
	 --%>
	 
	 <!-- 
	 	& 포워드	 : a와 b,c값 확인가능
	 	& 리다이렉트 : a와 b값만 확인가능 => request는 응답이 이미 끝나서 전달안됨
	 
	   -->
	
	 
	 <%-- 포워드 : request 정보를 전달하는 이동방삭%>  --%>
	 <%
	 	// 자바 포워드
	 	/* request.getRequestDispatcher("02_scope2.jpg").forward(request,response); */
	 	// jsp 포워드(& jsp로 시작하는 태그를 액션태그라 한다)
	 %>
	 
	 <%-- 포워드 --%>
	 	<%-- <jsp:forward page="02_Scope2.jsp"></jsp:forward> --%>		
	 	
	 <%-- 리다이렉트 --%>
	 <%
	 	response.sendRedirect("/02_JSP/ex03_binding/02_Scope2.jsp");	// a, b
	 %>
	 
</body>
</html>