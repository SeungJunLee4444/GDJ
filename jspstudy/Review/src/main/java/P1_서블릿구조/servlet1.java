package P1_서블릿구조;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
[서블릿]
- 웹 화면을 만드는 자바 클래스
- jsp 컨테이너(servlet 컨테이너, ex 톰캣)에 의해서 실행
- 서블릿을 실행하면 웹 브라우저가 실행됨

& 서블릿과 jsp의 차이
- 서블릿 : 자바언어를 바탕으로 내부에 html을 담는 형태
- jsp	 : html의 내부에 자바를 담는 형태

& url 구조
- 프로토콜(http) : //호스트:포트번호/컨텍스트패스/urlmapping
 				http://localhost:9090/P1_서블릿구조/serlvet
 
*/


@WebServlet("/servlet")	// => urlmapping
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	// 1. 생성자
	// - 가장 먼저 호출
	// 생성자 호출 뒤 init() 메서드 호출
    public servlet1() {
        super();
        System.out.println("생성자");

    }
    
    // 2. 초기화
    // - 각종 초기화 정보 실행
    // - 서블릿 환경설정 처리
    // - init() 메서드 호출 뒤 service() 메서드 호출
    public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init");
	}
    
    // 3. 서비스
    // - 클라이언트의 요청마다 매번 호출
    // - get 요청방식은 doGet() 메서드 호출, post 요청방식은 doPost() 메서드 호출
    // - service 메서드가 존재하면 doget(), dopost() 메서드가 자동으로 호출되지 않음
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("service");
			
			// 1) 요청 메서드
			// - doget과 dopost를 말한다
			// - 디폴트 요청메서드는 get
			System.out.println(request.getMethod());		// get
			
			// 2) 요청 메서드 확인
			// request.getMethod() : 요청하는 메서드의 종류를 알 수 있다
			// => get, post 반환
			switch(request.getMethod()) {
			case "GET" : doGet(request, response); break;
			case "POST" : doPost(request, response); break;
			}
			
	}
	
	// 4. doGet()
	// - get의 요청방식을 처리
	// - 요청메서드가 get인 경우
	/* 		(1) ajax 	: $.ajax({
						'type': 'GET',
						'url': 'http://localhost:9090/01_Servlet/HelloServlet'
					});
	 * 		(2) a링크 			: <a href="http://localhost:9090/01_Servlet/HelloServlet">링크</a>
	 * 		(3) form			: (3) <form method="GET" action="http://localhost:9090/01_Servlet/HelloServlet">  또는  <form action="http://localhost:9090/01_Servlet/HelloServlet">
	 * 		(4) location 객체	: location.href='http://localhost:9090/01_Servlet/HelloServlet'
			(5) window 객체 	: window.open('http://localhost:9090/01_Servlet/HelloServlet')
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// response : 사용자에게 전달할 때 사용
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	// 5. doPost()
	// - post 방식의 요청을 처리
	// - 요청 메서드가 post인 경우
	/*		(1) ajax : $.ajax({
						'type': 'POST',
						'url': 'http://localhost:9090/01_Servlet/HelloServlet'
					});
	 * 
	 * 		(2) <form method="POST" action="http://localhost:9090/01_Servlet/HelloServlet">
	 * 
	 * 
	 * & GET과 POST의 차이
	 * - GET은 URL에 파라미터를 노출시키고, POST는 감춘다
	 * - 일반적으로는 GET방식(디폴트)며, 필요한 상황에는 지정할 때는 POST를 쓰면 될듯
	 * 
	*/		
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
