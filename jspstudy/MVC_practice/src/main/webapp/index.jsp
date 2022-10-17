<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--[1] contextpath 변수화 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="${contextPath}/input.do">도형의 크기 구하기</a></h1>
	
	
	<%--
	[1] 처음부터 input.do로 이동
	1) 비즈니스 로직이 필요하지 않음
	2) actionforward로 직접 경로 생성 후 이동
	
	[2] input.jsp에서 서블릿
	1) input.jsp에서 각 도형별 서블릿 구현
	2) 컨트롤러에서 해당 모델 요청
	3) 요청한 값을 output.jsp로 반환(모델 내에서, 모든 도형 공통)
	4) 해당 경로로 이동
	
		
	
	
	 --%>

	
	
	
	
	
</body>
</html>