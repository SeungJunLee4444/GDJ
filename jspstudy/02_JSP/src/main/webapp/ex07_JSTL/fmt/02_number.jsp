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

	<%-- 1. number --%>
	<c:set var="n" value="123456789"></c:set>
	
	<%-- 
		<fmt:formatNumber> 태그
		- 정의 : DecimalFormat 클래스를 대체하는 태그
		- value 속성과 pattern 속성 + type 속성 사용
		- pattern 속성에서 사용하는 패턴은 simpleDateFormat과 동일한 패턴임
	 --%>
	 
	 
	 <%-- 1. pattern 속성 : pattern 속성을 통해 천단위 구분기호와 소수점 표현이 가능하다--%>
	 <%-- 1) 천단위 구분기호(,) 사용 : 소수점 표현 --%>
	 <h1><fmt:formatNumber value="${n}" pattern="#,##0"/></h1>
	 <%-- => 결과 : 123,456,789--%>
	 <h1><fmt:formatNumber value="${n}" pattern="#,##0.0"/></h1>
	 <%-- => 결과 : 123,456,789.0 --%>
	 <h1><fmt:formatNumber value="${n}" pattern="#,##0.00"/></h1>
	 <%-- => 결과 : 123,456,789.00 --%>
	 
	 <%-- 2) 천단위 구분기호(,) 없음 : 소수점 표현 --%>
	 <h1><fmt:formatNumber value="${n}" pattern="0"/></h1>
	 <%-- => 결과 : 123456789--%>
	 <h1><fmt:formatNumber value="${n}" pattern="0.0"/></h1>
	 <%-- => 결과 : 123456789.0 --%>
	 <h1><fmt:formatNumber value="${n}" pattern="0.00"/></h1>
	 <%-- => 결과 : 123456789.00 --%>
	 
	 
	 <%-- 2. type 속성 : 값에 퍼센트와 통화단위(+currencySymbol)를 붙일 수 있다--%>
	 <%-- 3) 백분율(%) : 값에 100을 곱한 뒤 %를 붙임
	 ex) 0.05를 5퍼센트로 표기하고 싶을 때
	 --%>	
	 <h1><fmt:formatNumber value="${n}" type="percent"></fmt:formatNumber>
	 <%-- => 결과 : 12,345,678,900% 
	 => 100을 곱하고 퍼센트 붙이기
	 --%>
	 
	 <%-- 4) 통화기호 앞에 붙여주기 : $, ￦ (ㄹ+한자)  
	 + 천단위 구분기호(,) 
	 --%>
	 <h1><fmt:formatNumber value="${n}" type="currency" currencySymbol="$"></fmt:formatNumber></h1>
	 <%-- => 결과 : $123,456,789--%>
	 <h1><fmt:formatNumber value="${n}" type="currency" currencySymbol="￦"></fmt:formatNumber></h1>
	 <%-- => 결과 : ￦123,456,789--%>
	 
	 
	 

</body>
</html>