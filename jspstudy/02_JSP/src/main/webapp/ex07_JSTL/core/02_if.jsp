<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- taglib 지시어 : 경로는 세번째꺼, prefix는 c --%> 

<%-- & jstl
=> 자바의 기능을 가진 태그

 --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 1. <c:if> 태그는 else 개념이 없다 => else를 사용할 수 있는 태그는 따로있다 --%>
	
	<%-- 1) 정수생성 --%>
	<c:set var="score" value="50"/>
	
	<%-- 2) 정수생성 --%>
	<c:if test="${score <= 100 and score >= 90}">
	A
	</c:if>
	<c:if test="${score <= 90 and score >= 80}">
	B
	</c:if>
	<c:if test="${score <= 80 and score >= 70}">
	C
	</c:if>
	<c:if test="${score <= 70 and score >= 60}">
	D
	</c:if>
	<c:if test="${score <= 60 and score >= 50}">
	F
	</c:if>

	
	
	

</body>
</html>