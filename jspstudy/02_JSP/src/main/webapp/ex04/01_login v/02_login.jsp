<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// [session]
// - 웹 컨테이너

	// 1. 요청 파라미터
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// 2. 로그인처리
	// => id와 pwd가 동일하면 로그인 성공으로 처리
	if(id.equals(pwd)){
	// 1) 아이디와 비밀번호의 텍스트가 동일할때
		
	// 2) 세션에 id, pwd값 저장
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
	
	}
	// 3. 로그인 폼으로 돌아가기
	// => 자바로 돌아가려면 (1) 포워드, (2) 리다이렉트
	response.sendRedirect("01_form.jsp");
	
%>