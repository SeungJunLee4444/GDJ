<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	// 1. session에 저장된 cart 제거
 	/* session.invalidate(); => 오류 */	
 	// => 장바구니를 비우다가 로그아웃되 될 수 있기 때문에
 	session.removeAttribute("cart");
 	
 	// 2. 장바구니 목록으로 이동
 	response.sendRedirect("03_cart_list.jsp");
 %>