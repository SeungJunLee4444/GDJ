<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- # 입력화면 : input.do
	- 내용 : 입력한 두개의 숫자값을 더하면, 
	각각 a와 b의 파라미터에 저장하여 adder.do에 전송해 값을 표시
	--%>
	<div>
		<form action="${contextPath}/adder.do">
			<div>
				<input type="text" name="a">
				+
				<input type="text" name="b">
				<button>계산</button>
			</div>
		</form>
	</div>

</body>
</html>