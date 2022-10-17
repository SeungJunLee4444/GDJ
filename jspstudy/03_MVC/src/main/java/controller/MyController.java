package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.AdderService;
import service.Myservice;
import service.NowService;
import service.TodayService;


/*@WebServlet("/Today", "/Now.do", "/adder.do")*/	// [컨트롤러]

@WebServlet("*.do")
// => 복수의 요청을 하나의 서블릿으로 처리하는 법
// .do로 끝나는 모든 요청을 처리

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyController() {
        super();
      
    }

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청확인(today인지 now인지) & 응답
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 2. 요청확인
		String requestURI = request.getRequestURI();	// urimapping  : 03_MVC/today.do 또는 now.do
		String contextPath = request.getContextPath();	// contextPath : 03_MVC
		String command = requestURI.substring(contextPath.length() + 1);	// t또는 n / command는 today.do, now.do를 저장
		
		
		
		// 4. MyService 선언(모든 모델은 MyService 타입이다)
		Myservice myService = null;
		
		// [3]5. ActionForward 선언(모든 model의 execute() 메서드의 반환타입)
		// - model이 필요없는 경우 ActionForward을 직접 만든다
		ActionForward actionForward = null;
		
		
		
		// 3. 요청에 따른 model의 선택
		switch(command) {
		
		
		// [3]비즈니스 로직이 필요한 경우
		case "today.do" : 
			// 1. 모델로 요청과 응답을 보내서 생성
			myService = new TodayService();
//			myservice.execute(request, response);	// todatyservice(MODEL)의 실행 메서드
			// => todayService에 request,와 response를 전달하여 처리(model에서 처리)
			
		
			// => result.jsp에 today(model의 결과)를 보내줌
			break;
		case "now.do" 	: 	
			myService = new NowService();
			break;
			
			
		// [3]비즈니스 로직이 필요하지않는 단순 이동
		case "input.do" : 
			// - 모델이 사용되지 않아도 괜찮다
			// - 이동만 하면됨
			// => 이동해야하는 getRequestDispacher의 값을 변수처리할 필요가 있다
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			break;
			
		// [4] 덧셈을 위한 로직 필요
		case "adder.do" : 
			myService = new AdderService();
	
		}
		
		
		
		// [3] 선택한 model의 실행(input는 해당 코드를 거치지않음, 단순 jsp파일로의 이동이기 때문)
		if(myService != null) {
			
			actionForward = myService.execute(request, response);
		}
		
		
		// => 해더
//		// 선택한 model의 실행(중복)
//		myService.execute(request, response);
		
		
		// 이동(리다이렉트,포워드 => 리다이렉트를 위한 코드 생성이 필요)
		// [4] 경로가 null이여서 null 예외발생 작성 => 이동하는 코드가 동작안했음, 
		if(actionForward != null) {	
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getView());
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);							
			}
		}
		
		// => actionforward가 null아 아니면 리다이렉트, 포워트
		// => actionforward가 null인 경우는 모델에서 response로 응답한 경우(직접 모델응답시 내부에 경로작성) 또는 ajax 처리
		
		// today나 now는 모델 안에 있는 result.jsp를 경로로 이동
		// input.do는 새롭게 뷰를 설정했으며 input.jsp로 이동
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
