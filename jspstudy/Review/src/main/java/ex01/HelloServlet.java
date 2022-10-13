package ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
[servlet]
- 정의 : 웹 화면을 만드는 자바 클래스
- 클라이언트의 요청에 따라 동적으로 서비스 제공
- jvm가 아닌 톰캣같은 jsp/servlet container로 실행된다
- 서블릿을 실행하면 웹 브라우저가 실행됨
- 자바 안에 html이 포함된 구조

- URL 
- 	프로포콜://호스트:포트번호/컨텍스트패스/URLMapping
	http://localhost:9090/01_Servlet/HelloServlet
	
& 서블릿 클래스 구조
1. HttpServlet을 상속받아 서블릿 클래스 생성
2. 기본 메서드는 doGet()과 doPost()	
	(1) GET/POST 방식에 따라 메서드 실행
	(2) 둘다 IOException이 발생할 수 있어, Throw IOException
3. HttpServletRequest	: 요청정보를 관리
- 클라이언트의 요청정보를 처리하는 클래스
- was가 웹 브라우저로 서블릿 요청을 받으면 httpservletrequest 객체 생성
- http 프로토콜의 request 정보를 서블릿에게 전달하기 위한 클래스
- header, parameter, cookie, url 등의 정보를 처리할 수 있는 메서드 포함

=> 이 객체(request) 메서드를 호출하여 요청정보를 얻을 수 있다

4. HttpServletResponse	: 응답정보를 관리
=> httpservletresponse에서 PrintWriter을 꺼내서 클라이언트에게 응답을 반환한다

& URLMapping 이름짓기
(1) 서블릿 파일명, 서블릿 어노테이션 변경(3.0이상)	o
(2) web.xml(3.0이하) 								x

& context path
- was에서 웹 에플리케이션을 구분하기 위한 기본 경로
- 기본적으로 프로젝트 이름과 동일


	
*/


@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // 1. 생성자
    public HelloServlet() {
        super();
        
    }
    
    // 2. 초기화(init)
    public void init(ServletException config) throws ServletException {
		System.out.println("init");
	}

    // 3. 서비스(service)
    // - 클라이언트 요청마다 매번 호출
    // - get방식은 doGet(), post방식은 doPost()방식 호출
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		// 1) 요청메서드 확인코드
		// => service 메서드가 있는 경우 doGet, doPost 메서드가 자동으로 호출되지않음
		switch(request.getMethod()) {
		case "GET":
			doGet(request, response);  // doGet() 메소드 호출
			break;
		case "POST":
			doPost(request, response);  // doPost() 메소드 호출
			break;
		}
		
    }
	
    /* 
		4. doGet
    	- get방식 요청 처리
    	1) 요청메서드가 get방식인 경우
    			(1) $.ajax({
						'type': 'GET',
						'url': 'http://localhost:9090/01_Servlet/HelloServlet'
					});
    			(2)  <a href="http://localhost:9090/01_Servlet/HelloServlet">링크</a>
    			(3) <form method="GET" action="http://localhost:9090/01_Servlet/HelloServlet">  또는  <form action="http://localhost:9090/01_Servlet/HelloServlet">
    			(4) location.href='http://localhost:9090/01_Servlet/HelloServlet'
				    open('http://localhost:9090/01_Servlet/HelloServlet')
				    
				    & window.open("경로") => js함수에 넣어서 사이트 여는 데에 사용
      
      
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2) 사용자에게 전달할 때 사용(요청한 url 반환)
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/*
	 	5. doPost
	 	- post방식 요청 처리
	 	1) 요청 메서드 post인 경우
	  			(1) $.ajax({
						'type': 'POST',
						'url': 'http://localhost:9090/01_Servlet/HelloServlet'
					});
				(2) <form method="POST" action="http://localhost:9090/01_Servlet/HelloServlet">
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청과 응답정보를 doGet()메서드로 넘겨버림
		doGet(request, response);
	}

}
