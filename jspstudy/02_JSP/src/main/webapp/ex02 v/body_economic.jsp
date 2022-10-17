<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%-- # 동적 레이아웃 
		1) 포함할 페이지에 변경되는 부분이 있음 
		2) jsp:include> 액션태그 사용
		3) jsp:param> 액션태그를 이용해 파라미터 전달
	 --%>
	 
	 <!-- (1) 잘못된 코드  -->
	<%-- 	<%@ include file="header.jsp"%> --%>
	<!-- (2) 올바른 코드 : 동적 코드  -->
	<% request.setCharacterEncoding("utf-8"); %>
	
	<%-- jsp 내장객체(ppt 참고)
	(1) request
	(2) response
	(3) session
	(4) out
	(5) applicaion
	(6) pageContext
	
	
	 --%>
	
	<jsp:include page ="header.jsp">
			<jsp:param value="경제" name="title"/>
	</jsp:include>

	<section>
		<div>경제1</div>
		<div>경제2</div>
		<div>경제3</div>
		<div>경제4</div>
	</section>
	
	<%-- # 정적 레이아웃 
		1) 포함할 페이지에 변경되는 부분이 없음
		2) <%@ include %> 지시어를 사용
	--%>
	<%@ include file="footer.jsp"%>

