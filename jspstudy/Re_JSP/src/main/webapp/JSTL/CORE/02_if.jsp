<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inser here</title>
</head>
<body>
	<%-- 1. <c:if text="조건"> 태그는 else 개념이 없다
	=> 굳이 el의 ge div 등의 조건을 사용할 필요는 없을듯?
	 --%>
	<c:if test="${score <= 100 and score >= 90}">A</c:if>
	
	<c:if test="${score <= 100 and score >= 90}">
		A
	</c:if>
	<c:if test="${score < 90 and score >= 80}">
		B
	</c:if>
	<c:if test="${score < 80 and score >= 70}">
		C
	</c:if>
	<c:if test="${score < 70 and score >= 60}">
		D
	</c:if>
	<c:if test="${score < 60 and score >= 0}">
		F
	</c:if>
	
</body>
</html>