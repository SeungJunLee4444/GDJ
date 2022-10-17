<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// <로그아웃창>
	// 기능 : session에 저장된 정보를 초기화하면 된다
	session.invalidate();
	// => session.invalidate() 정보 초기화 메서드
	
	// 로그인 폼으로 돌아가기
	response.sendRedirect("01_form.jsp");
%>