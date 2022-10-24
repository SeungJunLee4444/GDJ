package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MemberAddService;
import service.MemberDetailService;
import service.MemberListService;
import service.MemberService;


@WebServlet("*.do")
// & 웹 서블릿
// - 해석 : .do로 받는 모든 요청을 이 서블릿으로 처리하겠다는 의미
// => 모든 요청을 하나의 서블릿으로 받기 위해서 *.do를 사용
// => do는 임의의 명칭이다
// => 웹 서블릿은 요청을 위한 것이다(특정한 종류의 파일이 아님)

public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 / 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 요청확인
		String requestURI = request.getRequestURI();							// 05_MyBatis/list.do
		String contextPath = request.getContextPath();							// 05_MyBatis
		String urlMapping = requestURI.substring(contextPath.length()); 		// /list.do		
		
		// => + 1 사라진 이유는? /는 포함하든 말든 상관없어서?
		
	
		
		// StudentService 객체
		MemberService service = null;
		
		// actionforward 객체
		ActionForward af = null;
		
		//----------------------------------------------------------------------
		// # 요청에 따른 service의 선택과 execute 서비스 메서드 실행
		
		
		// 요청에 따른 service 선택
		// 1) 비즈니스 로직
		switch(urlMapping) {
		case "/member/manage.do":
			af = new ActionForward("/member/manage.jsp", false);
			break;
		case "/member/list.do" :
			service = new MemberListService();
			break;
		case "/member/detail.do" :
			service = new MemberDetailService();
			break;
		case "/member/add.do" :
			service = new MemberAddService();
			break;
		
		}
		
		// 선택된 service 실행
		try {
			if(service != null) {
				service.execute(request, response);
				// => qk
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//----------------------------------------------------------------------
		// # 이동
		// => 반환된 경로는 actionforward타입, 필드이 view(이동위치)와 이동방법을 저장		
	
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());	// 1) true면 리다이렉트 이동
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
				// 2) false면 forward 이동
			}
		}
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
