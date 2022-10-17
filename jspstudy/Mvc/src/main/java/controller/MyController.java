package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.AdderService;
import service.MyService;
import service.NowService;
import service.TodayService;


// [2] 한 서블릿에서 복수의 요청 처리하기
// 기존 : @WebServlet({"/today.do", "/now.do", "/adder.do"})
@WebServlet("*.do")  
// => do로 끝나는 모든 요청(urlmapping)
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 & 응답 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf=8");
		
		// 2. 요청확인(요청한 것이 어떤 urlmapping인지 확인)
		String requestURI = request.getRequestURI(); 	// requesturi : 03_Mvc/today.do, now.do, adder.do
		String contextPath = request.getContextPath();	// contextPath : 03_Mvc
		String command = requestURI.substring(contextPath.length() + 1); // todat.do, now.do 
		// => substring은 문자열의 일부분(컨텍스트 패스 이후의 문자열을 범위로 정함
		
		
		//------------------------------------------------------
		// 1) Myservice  선언
		// => 모든 model은 My service 인터페이스 타입이다
		MyService myService = null;
		
		// 2) ActionForward 선언
		// & 각 요청별 이동경로를 정하기 위함
		// => 모든 model의 execute()메서드의 반환타입은 ActionForward다
		// => model이 필요없는 경우 ActionForward를 직접 만든다
		ActionForward actionForward = null;
		
		//------------------------------------------------------
		
		// 3. 요청(command)에 따른 Model의 선택(해당 요청에 따른 생성자 생성)
		switch(command) {
		// 1) 비즈니스 로직(모델)이 필요한 경우						-----------------(생성자 생성)
		case "today.do" : myService = new TodayService(); break;
		case "now.do" : myService = new NowService(); break;
		case "adder.do" : myService = new AdderService(); break;
		
		// 2) 비즈니스 로직(모델)이 필요하지 않은 경우
		case "input.do" : actionForward = new ActionForward();
		actionForward.setView("views/input.jsp");
		// => input.jsp는 경로만 필요하다
		// => input.jsp로 이동후 계산에 필요한 모델(adder)을 다시 요청한다
		
		}
		
		// 3) 선택한 model(클래스) 실행(요청에 다른 실행 메서드 실행)							-----------------------(메서드 실행)
		if(myService != null) {
			actionForward = myService.execute(request.response);
		}
		
		if(actionForward != null) {
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getView());
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			}
		}
		
				
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
