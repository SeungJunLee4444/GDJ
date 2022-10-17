package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MyService;


@WebServlet("*.do")	// circle.do, rectangle.do, square.do, input.do
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 응답
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 2. 요청확인
		String requestUri = request.getRequestURI();						// 컨텍스트패스/urimapping
		String contextPath = request.getContextPath();						// 컨텍스트 패스
		String command = requestUri.substring(contextPath.length() + 1); 	// urimapping만 :  circle.do ....
		
		
		// & myservice 선언(모델의 공통 인터페이스)
		MyService service = null;
		// & actionforward 선언(jsp파일 이동경로 클래스)
		ActionForward actionForward = null;
		
		
		// 3. 요청에 따른 model 선택		
		switch(command) {
		// 1) 비즈니스 로직이 필요한경우
		case "Circle" : 
		case " Rectangle" :
		case "Square" : 
		
		// 2) 비즈니스 로직이 필요하지 않은경우
		// (1) input.do 이동
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			break;
			
			// & input.do과 input.jsp와 혼동하지말것?
		}
		
		// 4. 선택한 model 실행					--------------------------	=> 각 모델로 이동해서 실행
		if(service != null) {
		actionForward = service.execute(request, response);
	}
		
		
		// 5. 이동(포워드로 통일)
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getView());
		} else {
			request.getRequestDispatcher(actionForward.getView()).forward(request, response);
		}
		// => 모델의 경로는 전부 false(포워드)를 기준으로 잡은 상태(임의로)
	}
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
