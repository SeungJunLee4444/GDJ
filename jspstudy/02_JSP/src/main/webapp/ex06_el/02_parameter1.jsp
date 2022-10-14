<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="get" action="02_parameter2.jsp">
			<div>
				<input type="text" name="a">
			</div>
			<div>
				<input type="text" name="b">
			</div>
			<!-- => a와 b의 파라미터는 요청이기 때문에 el을 사용가능
			& 속성과 파라미터는 다름(주의)
			=> request에는 파라미터의 형태, 속성의 형태 두 가지가 올 수 있음			
			 -->
			<div>
				<input type="submit" value="전송">
				<!-- => 서브밋시에는 name 필요없음 -->
			</div>
		</form>
	</div>

</body>
</html>