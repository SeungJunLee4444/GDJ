<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. JSP 스크립트 요소 -->
	<!-- 1) jsp 주석  -->
	<!-- html 주석 : 웹 구성요소 주석, 페이지 소스보기에서 확인 가능  -->	
	<%-- jsp 주석 : 자바 구성요소 주석, 페이지 소스보기에서 확인 불가능--%>	
	
	<!-- 2) 선언부
	=> 이 안은 자바의 영역
	  -->
	<%!
	// 2) 선언부 : 전역변수 선언, 메소드 정의
	public int getSum(int begin, int end) {
		int sum = 0;
		for(int n = begin; n < end; n++) {
			sum += n;
		} 
		return sum;
	}
	%>
	
	<% 
		// 3) 스크립트릿(scriptlet) : 일반 자바 코드
		int sum = getSum(1, 100);
	%>
	
	<!-- 4. 표현식 : 값(변수, 메서드 호출 결과)을 나타낼때 사용 -->
	<div><%=sum%></div>					<!-- 변수 -->
	<div><%=getSum(1,1000)%></div>		<!--메서드  -->
	
	<!-- -------------------------------------------------------------------------------------  -->
	<!-- 연습 : 화면 1에서 10 출력하기-->
	
	<% for(int p = 1; p <= 10; p++) { %>
	<div><%=p%></div>
	<% } %>
		
		
	<!-- -------------------------------------------------------------------------------------  -->
		
	<!-- 연습: select태그만들기 -->
	<div>
		<select name="month">
			<option value="">월 선택></option>
			<% for(int m = 1; m <= 12; m++) { %>
				<option value="<%=m%>"><%=m%>월</option>
			<% } %>
		</select>
	</div>		
	
	<!-- 연습 테이블 만들기 -->
	<%
		String[] names = {"정숙", "영희", "영숙"};
		int[] ages = {25,26,27};
	%>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>이름</td>
					<td>나이</td>
				</tr>
			</thead>
			<tbody>
				<% for(int t = 0; t < names.length; t++) { %>
					<tr>
						<td><%=t+1%></td>
						<td><%=names[t]%></td>
						<td><%=ages[t]%></td>
					</tr>
					<% } %>
			</tbody>
		</table>
	</div>

	
	
	
	
	
</body>
</html>