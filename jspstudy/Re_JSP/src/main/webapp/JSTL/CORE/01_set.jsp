<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Core Library : JTSL 사용을 위해서는 코어 라이브러리가 필요하다 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <%-- --%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 1. <c:set> 태그
	- 정의 : '속성을 만드는 일종의 변수 태그'
	- <c:set var="속성명" value="값" scope="영역">
	- 만들 수 있는 영역 : page(디폴트), request, session, application--------------?
	--%>
	
	 <%-- & 정리
	 1_ c:set를 통해 태그로 변수선언이 가능해진다
	 2_ 변수선언시 value값을 조건처럼 사용할 수 있으며, el을 사용한다
	  --%>
	
	<%--
	- 아래 자바코드는
		pageContext.setAttribute("name", "가나다");
	다음 <c:set> 태그와 같다
		<c:set var="name" value="가나다" scope="page"/>
	
	 --%>
	<c:set var="name" value="민경태" scope="page" />
	<c:set var="age" value="45" scope="page" />
	<c:set var="isAdult" value="${age >= 20}" scope="page" />	<%-- => age값을 변수로 다시 사용 --%>
	<c:set var="height" value="180.5" scope="page" />
	<c:set var="weight" value="73.5" scope="page" />
	<c:set var="bmi" value="${weight div (height * height * 0.0001)}" scope="page" />
	<c:set var="health" value="${bmi ge 25 ? '비만' : '정상'}" scope="page" />	
	
	<h1>이름 : ${name}</h1>
	<h1>나이 : ${age}</h1>
	<h1>${isAdult ? '성인' : '미성년자'}</h1>
	<h1>bmi : ${bmi}</h1>
	<h1>건강상태 : ${health}</h1>
</body>
</html>