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
	<%-- 1. forEach는 반복문 태그다
			(1) var 선언한 변수(int i)
			(2) begin	: 시작값
			(3) end		: 끝값
			(4) step	: 증가범위
			& forEach에서는 step에 -가 먹히지 않는다
	
	
	 --%>
	
	<%-- 실습:  1 ~ 5 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		${n}&nbsp;
	</c:forEach>
	
	<%-- 2. 5 ~ 1 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		${6 - n}&nbsp;
	</c:forEach>
	
	<%-- 3. <select> 1월 ~ 12월 --%>
	<select name="month">
		<option value="">월 선택</option>
		<c:forEach var="m" begin="1" end="12" step="1">
			<option value="${m}">${m}월</option>
		</c:forEach>
	</select>
	
	<%-- 4. 배열 --%>
	<%
		String[] menus = {"김밥", "떡볶이", "순대"};
		pageContext.setAttribute("menus", menus);
	%>

</body>
</html>