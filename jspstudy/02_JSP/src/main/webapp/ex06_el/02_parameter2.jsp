<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--[el의 연산처리]  -->

	<!-- 파라미터와 속성을 구분하는법
	=> el에서 파라미터를 부를떄 param.를 붙여줘야한다
	-->
	
	<%--
		el의 파라미터 처리
		1. el 내장객체 param을 사용(params, paramValues)
		2. 모든 파리미터는 String이다(크기비교가 제대로 안된다)
			ex) "10" "5" 중 누가 큰가?(문자열의 크기는 사전 편찬순, 먼저 나온놈이 작고, 나중에 나온놈이 크다)
		
		3. 파라미터의 크기 비교
			- 두 파라미터의 차이를 구한 뒤 0보다 큰지 여부를 판단
			- 두 파라미터의 차이를 구하면 결과는 숫자가 반환 
			
		& 파라미터로 비교연산자 사용시 오류발생
		=> 파라미터는 문자열값으로, 숫자비교가 되지 않기 때문,
		=> 파라미터간의 차이를 이용해 0보다 큰지 작은지 여부로 확인
	
	 --%>
	
	
	<div>${a + b}</div>	<!-- 값 : 0, el에서 파라미터 처리를 위해서는 내장객체 param을 사용해야한다  -->
	
	<div>${param.a+param.b}</div>
	<div>${param.a-param.b}</div>	<!--=> 애가 크기비교를 한 것  -->
	<div>${param.a*param.b}</div>
	<div>${param.a/param.b}, ${param.a div param.b}</div>
	<div>${param.a%param.b}, ${param.a mod param.b}</div>
	
	<div>${param.a - param.b < 0 }, ${param.a - param.b lt 0}</div>
	<div>${param.a - param.b <= 0}, ${param.a - param.b le 0}</div>
	<div>${param.a - param.b > 0}, ${param.a gt param.b}</div>
	<div>${param.a - param.b >= 0}, ${param.a ge param.b}</div>
	<div>${param.a == param.b}, ${param.a eq param.b}</div>
	<div>${param.a != param.b}, ${param.a ne param.b}</div>
	
	<div>${param.a == 7 && param.b == 2}, ${param.a eq 7 and param.b eq 2}</div>
	<div>${param.a == 7 || param.b == 2}, ${param.a eq 7 or param.b eq 2}</div>
	<div>${!(param.a == 7)}, ${not (param.a == 7)}</div>
	
	<div>${param.a == 7 ? "a는 7이다" : 'a는 7이 아니다'}</div>
	
	

</body>
</html>