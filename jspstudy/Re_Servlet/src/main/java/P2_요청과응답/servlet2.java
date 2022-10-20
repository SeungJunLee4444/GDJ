package P2_요청과응답;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")	
// & url mapping은 복수 지정이 가능하다
// @webServlet("/my", "/me")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlet2() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		// - 클라이언트 -> 서버로 보내는 요청, 데이터
		// - HttpServletRequest request 객체가 처리
		// => 톰캣(was)가 있어야 사용 가능하다
		
		// 1) 요청에 포함된 한글 처리(컴퓨터가 한글 데이터를 읽어들일 수 있도록 0과 1로 인코딩)
		request.setCharacterEncoding("utf-8");
		
		// 2) 요청 파라미터 확인
		// - 모든 파라미터는 String 타입이다
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		// 3) null 처리
		int age = 0;
		if(strAge != null) {
			age = Integer.parseInt(strAge);
		}
		
		
		// 2. 응답
		// 서버 -> 클라이언트로 보내는 응답
		//  HttpServletResponse response 객체가 처리 
		// => Tomcat이 있어야 사용 가능
		
		// 1) 사용자에게 전달할 데이터의 형식을 결정	+ 응답에 포함되는 한글 처리
		//		(1) html : text/html
		//		(2) css  : text/css
		//		(3) js	 : text/javascript
		//		(4) xml	 : application/xml
		//		(5) json : application/json
		//		(6) 텍스트?
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 응답 스트림 생성
		// - 문자 출력 스트림 생성
		// - response 객체로부터 Printwriter 객체를 얻을 수 있음
		// - IoException 예외처리가 필요함 => throw로 이미 처리되있음
		// - writer() 메서드 보다는 print()/println() 메서드를 사용하는 것이 권장
		
		PrintWriter out = response.getWriter();
		out.println("<html");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
