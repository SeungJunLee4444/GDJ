package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnchorServlet")
public class anchorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public anchorservlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 파리미터
		request.setCharacterEncoding("utf-8");
		String stra = request.getParameter("a");
		String strb = request.getParameter("b");
		int a = 0;
		int b = 0;
		if(stra != null ) {
			a = Integer.parseInt(stra);			
		}
		if(strb != null) {
			b = Integer.parseInt(strb);			
		}
		
		System.out.println("값" + (a + b));
		
		// 응답 만들기
		// => 요청은 단축이없음, 응답만 setcontenttype가 있음
		response.setContentType("text/html; charset=utf-8");
	
		PrintWriter out = response.getWriter();
		// => getWriter이 반환하는건 printwriter
		
		
		
		// 웹상에 출력
		// => 응답시 html문서
		out.println("<h1>hello world</h1>");
		out.println("<h1>" + a + "+" + b + "=" + (a+b) + "</h1>"); 
		
	
		
		
		

		
		
		
		out.flush();
		out.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
