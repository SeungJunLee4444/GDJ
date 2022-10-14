<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. 요청 파라미터
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String chkKeepLogin = request.getParameter("chk_keep_login");
	
	// 2. id="min", pwd="1234"이면 로그인 성공
			if(id.equals("min") && pwd.equals("1234")) {
				
				// 1) 로그인 유지를 체크했다면 chekKeepLogin이 null 아님
				// 2) 로그인 유지를 체크했다면 로그인 정보를 쿠키에 저장(브라우저를 닫아도 정보를 유지하기 위함)		
				if(chkKeepLogin != null) {	// => 체크가 안되었으니 null(애초에 할당이 안되었기 때문)
					Cookie cookie1 = new Cookie("id", id);
					cookie1.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(cookie1);
					Cookie cookie2 = new Cookie("pwd", pwd);
					cookie2.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(cookie2);
				}
				// 3) 로그인 유지를 체크하지 않았다면 일반 로그인 처리(session은 브라우저 종료 전까지 정보 유지)
				else {
					session.setAttribute("id", id);
					session.setAttribute("pwd", pwd);
				}
			}
	// 3. 로그인 품으로 가기
	response.sendRedirect("01_form.jsp");


%>