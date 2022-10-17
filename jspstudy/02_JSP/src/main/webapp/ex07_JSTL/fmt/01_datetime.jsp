<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 2. JSTL(2) : fmt --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- => core + 태그 라이브러리를 하나더 작성한다 --%>
<%-- --%>
<%-- --%>
<%-- --%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 1. simpledateformat 처리 --%>
	<c:set var="now" value="<%=new Date()%>"></c:set>
	
	${now}	
	<%-- => 웹 화면에 Mon Oct 17 09:13:02 KST 2022 --%>
	
	<%-- 
		<fmt:formatDate> 태그
		- 정의 : simpleDateFormat 클래스를 대체하는 태그
		- value 속성과 pattern 속성을 사용
		- pattern 속성에서 사용하는 패턴은 simpleDateFormat과 동일한 패턴임
	 --%>
	 
	 <h1><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일"/></h1>
	 <%-- & E 대문자를 사용하면 요일출력 가능 --%>
	 <%-- => 결과 : 2022년 10월 17일 월요일--%>
	 <h1><fmt:formatDate value="${now}" pattern="a h:mm:ss"/></h1>
	 <%-- => 결과 : 오전 9:20:20 --%>
	 <h1><fmt:formatDate value="${now}" pattern="H:mm:ss"/></h1>
	 <%-- => 결과 : 9:20:20 --%>
	 
	 <%-- & 자바 format
	 - H : 0시부터 23시
	 - h : 1시부터 12시
	 - E : 요일
	 
	  --%>
	 
	 
	 

</body>
</html>