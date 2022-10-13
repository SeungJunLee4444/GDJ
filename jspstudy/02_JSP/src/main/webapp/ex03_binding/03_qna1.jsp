<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		label {
			display : block;
			
		}
		label span {
			display : inline-block;
			width: 100px;
			
		}
	</style>
</head>
<body>
	<%
		Date date = new Date();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(date);
		// => 자바변수는 4개의 저장영역에 바인딩되어야 el로 쓸 수 있다
		
		// today의 el 사용을 위해서 속성으로 저장
		pageContext.setAttribute("today", today);
	
	%>
	<div>
		<form method="POST" action="/02_JSP/ex03_binding/03_qna2.jsp">
			<label for="created_date">
				<span>작성일</span>
				<input type="text" name="created_date" id="created_date" value="${today}">
				<!-- 디폴트값으로 오늘날짜가 나오게만들기
				1) 오늘 날짜 구하기
				2) el을 사용할 수 있도록 만들기-->
			</label>
			<label for="writer">
				<span>작성자</span>
				<input type="text" name="writer" id="writer">
			</label>
			<label for="title">
				<span>제목</span>
				<input type="text" name="title" id="title">
			</label>
			<label for="content">
				<span>내용</span>
				<input type="text" name="content" id="content">
			</label>
			<button>문의 남기기</button>
			<input type="reset" value="다시작성">
			
		</form>
	</div>
</body>
</html>