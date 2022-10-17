<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- [페이지에서 일부분만 변화를 주는 경우] 
1. 목록 header과 몸통 body, 바닥 footer로 jsp파일 분리
=> 대체로 header은 동적으로, footer은 정적으로 만든다
(header의 목록을 통해 이동, footer은 변화없이 그대로)

2. 동적레이아웃과 정적 레이아웃 구분하기
1) 동적 레이아웃은 포함할 페이지에 변경되는 부분이 있을때
=> jsp:include, jsp:param 액션태그 사용
=> 바뀌는 페이지 타이틀과 파라미터 반영하기
2) 정적 레이아웃은 포함할 페이지에 변경되는 부분이 없음
=> include 지시어만 사용
=> 서버에서 전달받은 데이터를 스크립트를 거쳐서 출력

& 동적 웹페이지와 정적 웹페이지의 차이
1) 동적 웹페이지 : 입력된 데이터에 따라 웹페이지 변화있음
2) 정적 웹페이지 : 이미 만들어진 웹페이지 사용, 변화없음
=> 사전에 전달된 웹 페이지를 그대로 전달받음(데이터변화x)

-->
		<%-- 
		3. 현재의 jsp에서 다른 jsp,html을 포함시켜 사용
		- 주로 header, footer, 상태바에 사용
		- 형태 : jsp:include page = "파일명.jsp"
		=> 현재 페이지 상에 다른 페이지를 포함시켜 사용
		
		4. jsp:param value="" name=""
		- jsp페이지에 파라미터를 추가할 수 있음
		- jsp:include 나 jsp:forward의 자식태그로 추가해서 사용
		- forward, include 태그에 데이터 전달을 목적으로 사용되는 태그
		- name이 파라미터명, value가 파라미터값
		- & /닫아주는 슬래시를 꼭 써줘야한다
		
		& jsp:include page와 file의 차이
		(1) 정적이면 file
		(2) 동적이면 page
		
		
	 --%>
	 
	 <!-- (1) 잘못된 코드  -->
	<%-- 	<%@ include file="header.jsp"%> --%>
	
	
	
	<!-- (2) 올바른 코드 : 동적 코드  -->
	<% request.setCharacterEncoding("utf-8"); %>	
	<!-- => 요청 파라미터의 캐릭터셋지정 -->
	<jsp:include page ="header.jsp">
			<jsp:param value="사회" name="title"/>
	</jsp:include>
			<%-- 
			& 파라미터 : 정보를 전달하는 역할 name : value로 구성
			(1) 프론트 : ex) url
			(2) 백엔드 : 정보를 전달하는 역할을 하지만 드러나지않는다 ex) 위의 title
			=> jsp는 백엔드, 백엔드는 파라미터가 드러나지않는다
			
			 --%>

	<section>
		<div>사회1</div>
		<div>사회2</div>
		<div>사회3</div>
		<div>사회4</div>
	</section>
	
	<%@ include file="footer.jsp"%>

