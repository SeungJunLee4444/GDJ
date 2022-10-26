<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>;	<%-- & 절대경로의 변수화 --%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${login == null}">		<%-- & 회원가입이 안되어있으면 로그인 창을 보여주겠다 --%>
	<div>
		<form method="post" action="${contextPath}/member/login.me">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="text" name="pw" placeholder="비밀번호">
			</div>
			<div>
				<button>로그인</button>
			</div>
		</form>
	</div>
	</c:if>
	
	<%-- & login에는 member의 정보가 저장되있음 --%>
	<c:if test="${login != null}">
	<div>
		${login.name} 님 어서오세요
		<input type="button" value="로그아웃" onclick="location.href='${contextPath}/member/logout.me'">	<%-- & 로그아웃시 로그아웃 요청 --%>
	</div>
	</c:if>

</body>
</html>