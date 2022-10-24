<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- & --%>
<%-- 
# contextPath의 절대경로를 el변수로 저장
1) taglib : 코어 라이브러리 jar 파일 필요, c는 태그로 자바의 변수선언 가능
2) el	  : 라이브러리x, 디자인언어
3) el을 이용한 contextPath 변수선언
- 절대경로 : pageContext.reqeust.contextPath => ${contextPath}
- 장점 
	(1) 상대경로보다 절대경로가 훨씬 안전하다(상대경로는 경로가 바뀔수있음)
	(2) el을 이용해 단축하여 컨텍스트 패스 경로를 가져올 수 있음	
 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- # 모든 시작페이지는 index.jsp로 규정 --%>
<title>시작페이지는 index.jsp</title>
</head>
<body>

	<%-- &
	.do로 끝나는 것들은 '서블릿'이다
	 --%>
	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>

</body>
</html>