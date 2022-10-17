<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%-- 							= <%=request.getContextPath()%> --%>
<%-- & 학습목록
1) mvc 패턴
2) 한 서블릿으로 복수의 요청을 받는법
	(1) 각 클래스(모델)의 request 속성명을 동일하게 하기 
	(2) 서블릿에 요청명에 따른 자바파일 실행, switch문으로 구분
	(3) 실행 jsp파일에 동일한 속성명 작성
	
	
3) 인터페이스의 사용
=> 인터페이스를 통해 중복되는 메서드 호출을 줄일 수 있음


4) 이동경로를 변수로 지정[3]
=> 모델이 필요한 경우와 단순히 jsp파일로의 이동이 필요한 경우를 위해 경로를 변수로 지정


5) 모델에서 응답을 만들떄
=> ioexceiptio 생성
=> 직접 응답을 만들경우 경로를 history.back, location.href를 자주 사용한다

 --%>
<%-- --%>
<%-- --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>
	<%-- == <a href="03_MVC/Today"></a> --%>
	<%-- 1. 왜 컨텍스트 패스를 변수로로 만들어 사용하는가?
	=> war 파일의 이름과 컨텍스트 패스와의 충돌을 막기 위해서,
	'컨텍스트 패스를 변수 처리해야한다'--%>
	
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>
	
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>
	
	
	
	
	
	
	
</body>
</html>