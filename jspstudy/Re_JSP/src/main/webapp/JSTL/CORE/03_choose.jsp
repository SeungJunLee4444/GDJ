<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- --%>
	<%-- 1. <c:choose> 태그는 if-else 구조를 지닌다
				- 조건문은 자식태그로 작성한다
				(1) <c:when test="조건">	: 조건에 해당하는 경우
				(2) <c:otherwise> 			: 그외의 모든것
	 --%>
	
	<c:set var="age" value="400"/>
	
	<c:choose>
		<c:when test="${age < 0}">인간이아님</c:when>	<%-- => & c:if와 c:choose의 c:when의 조건은 test속성이다--%>
		<c:when test="${age <= 7}">미취학아동</c:when>
		<c:when test="${age <= 13}">초등학생</c:when>
		<c:when test="${age <= 16}">중학생</c:when>
		<c:when test="${age <= 19}">고등학생</c:when>
		<c:when test="${age <= 100}">성인</c:when>
		<c:otherwise>인간이아님(100살 초과)</c:otherwise>
	</c:choose>

</body>
</html>