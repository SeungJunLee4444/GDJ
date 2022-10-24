package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ActionForward;

// & 하나의 서블릿에서 복수의 요청 처리하는법
// - 답 : 요청의 확장자를 일치시킨다

// - 웹서블릿에 요청 작성하는법
// 1) 일반방법 : {} 사용
/*@WebServlet({"/today.do", "/now.do", "/adder.do"})*/

// 2) 단축방법 : * 사용
@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// # 요청과 응답 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// => mvc는 다양한 jsp 페이지를 이동하기 때문에 html로 응답해야한다
		
		// # 요청 확인(today.do인지 now.do인지...)
		String requestURI = request.getRequestURI();
		// requestURI = /3_MVC/today.do ...
		String contextPath = request.getContextPath();                    
		// contextPath : /03_Mvc
		String command = requestURI.substring(contextPath.length() + 1);
		
		// => +1은 하든 안하든 상관없다
		// (command에 /를 포함하냐 안하냐의 차이)
		
		
		// # myservice 선언(모든 서비스의 인터페이스)
		Myservice myService = null;
		
		// # actionForward 선언(경로)
		ActionForward actionForward = null;
		
		//---------------------------------------------------------------------
		// [service]
		
		// # 요청에 따른 model '선택'	: today.do, now.do, adder.do
		switch(command) {
		case "today.do" :
			myService = new TodayService();
		
		
		// # 비즈니스 로직이 필요없는 단순이동	: input.do
		
		case "input.do" : 
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			// => views는 패키
		}
		
		// # 선택한 model의 실행
		if(myService != null) {	// null?
			actionForward = myService.execute(request,response);
			// => 각 서비스는 actionForward 타입 반환
			// => 요청한 서비스마다 응답된 actionforward 결과를 변수에 저장?
		}
		
		// # 이동(리다이렉트, 포워드)
		// - actionForward != null : 이동
		// - actionForward == null : response로 응답한 경우, 또는 ajax처리
		if(actionForward.isRedirect()) {
			// 1) 리다이렉트 이동
			response.sendRedirect(actionForward.getView());
			// 2) 포워드 이동
			request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			
		}
		
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
