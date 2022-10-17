<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- [1] contextPath를 변수로 만들기 : war 파일명과 충돌 방지? --%>    
    <%-- --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>		<%-- 오늘 날짜 구하기 --%>
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>			<%-- 현재 시간 구하기 --%>
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>		<%-- 계산하기 --%>
	<%-- => today.do, now.do, input.do는 urlmapping, 즉 서블릿파일이다 
		 => [2] 서블릿 파일 생성
		  
	 --%>

</body>
</html>