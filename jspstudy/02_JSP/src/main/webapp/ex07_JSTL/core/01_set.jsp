<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- core library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 1. 속성 만들기태그 
		1) <c:set var="속성명" value="값" scope="영역">
		2) 영역 : page(디폴트), request, session, application
--%>
	
	<%-- & 이거 하나하나를 변수라 생각하면 된다 => <c:set var="name" value="가나다" scope="page"/> --%>
	
	<c:set var="name" value="가나다" scope="page"/>
	<%-- / : 닫는태그를 스스로 닫는태그로 만들어주는 마무리방식 --%>
	<c:set var="age" value="44" scope="page"/>
	<c:set var="isAdult" value="${age >= 20}" scope="page"/>
	<c:set var="height" value="180.5" scope="page"/>
	<c:set var="weight" value="73.5" scope="page"/>
	<%-- <c:set var="bmi" value="${몸무게 / 키(m)제곱}" scope="page"/> --%>
	<c:set var="bmi" value="${weight div (height * height * 0.0001)}" scope="page"/>
	<%-- <c:set var="health" value="${bmi 25 이상이면 비만 아니면 정상} scope="page"/> --%>
	<c:set var="health" value="${bmi ge 25 ? '비만' : '정상'}" scope="page"/>
			<%--
			=> 위와 아래는 동일한 코드다
			pageContext.setAttribute("name", "가나다");
			pageContext.setAttribute("age", 44); 
			--%>
	
	<h1>이름 : ${name}</h1>
	<h1>나이 : ${age}</h1>
	<h1>${isAdult ? '성인' : '미성년자'}</h1>
	<h1>bmi : ${bmi}</h1>
	<h1>건강상태 : ${health}</h1>
	
	
</body>
</html>