<%@page import="java.util.ArrayList"%>
<%@page import="domain.Student"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
	<%-- 1. 1~5 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<div>${n}</div>
	</c:forEach>
	
	<hr>
	
	<%-- 2. 5~1 --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<div>${6-n}&nbsp;</div> 
	</c:forEach>
	
	<%-- 3. <select> 1~12월 --%>
	<select name="month">
			<option value="">선택안함</option>
	<c:forEach var="n" begin="1" end="12" step="1">
			<option value="">${n}</option>
	</c:forEach>
	</select>
	
	<hr>
	
	<%-- 4. 배열순회 --%>
	<%
	String[] menu = {"튀김", "떡볶이", "순대"};
			// => 자바변수는 el 사용이 안된다
			pageContext.setAttribute("menu", menu);
			// & pagecontext : jsp 기본객체 => 페이지 접근 
			// & 속성을 만들어 접근
	%>
	<c:forEach var="food" items="${menu}" varStatus="vs">	
	<%-- => 배열의 인덱스를 쓰고싶으면 varStatus의 정해진 객체들을 사용해야한다(vs는 임의의 이름, 변수명)
		인덱스 : ${vs.index}, 순번 : ${vs.count}, 배열요소 : ${menu}
	--%>
		인덱스 : ${vs.index}, 순번 : ${vs.count}, 배열요소 : ${food}<br>
	</c:forEach>
	
	<%-- 5. 리스트 
	=> jspl은 배열과 리스트를 동일하게 다룬다
	--%>
	
	<%
		List<String> seasons = Arrays.asList("봄", "여름", "가을", "겨울");
				pageContext.setAttribute("seasons", seasons);
		%>
	<c:forEach var="season" items="${seasons}" varStatus="ds">
		인덱스 : ${ds.index}, 순번 : ${ds.count}, 배열요소: ${season}<br>
	</c:forEach>
	<%--  => 대문자 C는 오류발생 주의!--%>
	
	
	<%-- 6. Map --%>
	<%-- =>  map을 el에서 사용하는 방식 --%>
	<%
	Map<String, Integer> map = new HashMap<>();
		// => 제네릭은 참조타입만 가능 : integer
			map.put("begin", 1);
			map.put("end", 10);
			pageContext.setAttribute("map", map);
	%>
	${map.begin} ~ ${map.end}
	
	<hr>
	
	<%-- 7. 객체(반복이 필요한건 아님) --%>
	<%
	Student board = new Student();
			board.setBoardNo(1);
			board.setTitle("도데체 언제까지..");
			board.setHit(100);
			pageContext.setAttribute("board", board);
	%>
	${board.boardNo}, ${board.title}, ${board.hit}<br>
	${board.getBoardNo()}, ${board.getTitle()}, ${board.getHit()}<br>
	
	<%--
		${board.boardNo}는 ${board.getBoardNo()}을 자동으로 호출하다
	 --%> 
	 
	 <hr>
	 
	 <%-- 
	 	문제 : 임의의 Board 객체를 3개 저장한 리스트 만들기
	  --%>
	  <table border="1">
	  	<thead>
	  		<tr>
	  			<td>순번</td>
	  			<td>게시글번호</td>
	  			<td>제목</td>
	  			<td>조회수</td>
	  		</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach var="board" items="${boards}" varStatus="vs">
	  		<%-- => board 클래스의  객체 --%>
	  			<tr>
	  				<td>${vs.count}</td>
	  				<td>${board.boardNo}</td>
	  				<td>${board.title}</td>
	  				<td>${board.hit}</td>
	  				<%-- => 객체는 필드값 호출시 자동으로 get메서드가 사용된다 --%>
	  			</tr>
	  		</c:forEach>
	  	</tbody>
	  </table>
	  

	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>