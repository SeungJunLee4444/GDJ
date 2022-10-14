<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- & jsp 내장객체
1) request			: 웹 브라우저 요청정보 저장한 객체
2) response			: 웹 브라우저 응답정보 저장한 객체
3) out				: jsp 페이지 출력할 내용을 담은 객체
4) session			: 웹 브라우저 내에서 정보를 유지하기 위헤 세션정보를 저장한 객체
5) application		: 웹 에플리케이션 context를 담은 객체
6) pageContext		: JSP 페이지에 대한 정보를 저장하고 있는 객체
7) page				: JSP 페이지를 구현한 자바 클래스 객체
8) config			: JSP 페이지에 대한 설정 정보를 담고 있는 객체
9) exception		: JSP 페이지에서 예외가 발생한 경우 사용하는 객체
  -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// 1. el 사용이 가능한 4개의 영역(jsp 내장객체 9개중)
			// 1) pageContext
			// 2) request	
			// 3) session	
			// 4) application

		// 2. el 연산자
			// 1) 산술연산자	: + - * /(div) %(mod)
			// 2) 관계연산자	: <(lt) >(gt) >=(ge) <=(le) ==(eq) !=(ne)
			// 3) 논리연산자	: &&(and) ||(or) !(not)
			// 4) 조건연산자	: (조건식) ? 값1 : 값2
					
		pageContext.setAttribute("a", 7);
		pageContext.setAttribute("b", 2);
	%>
	<div>${a+b}</div>
	<div>${a-b}</div>
	<div>${a*b}</div>
	<div>${a/b}, ${a div b}</div>
	<div>${a%b}, ${a mod b}</div>
	
	<div>${a < b}, ${a lt b}</div>
	<div>${a <= b}, ${a le b}</div>
	<div>${a > b}, ${a gt b}</div>
	<div>${a >= b}, ${a ge b}</div>
	<div>${a == b}, ${a eq b}</div>
	<div>${a != b}, ${a ne b}</div>
	
	<div>${a == 7 && b == 2}, ${a eq 7 and b eq 2}</div>
	<div>${a == 7 || b == 2}, ${a eq 7 or b eq 2}</div>
	<div>${(!a == 7)}, ${not (a == 7)}</div>			
	<!-- => ()로 꼭 감싸줘야한다  -->
	
	<div>${a == 7 ? "a는 7이다" : 'a는 7이 아니다'}</div>
	
	
	

</body>
</html>