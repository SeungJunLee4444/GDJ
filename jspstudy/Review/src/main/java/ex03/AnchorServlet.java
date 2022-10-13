package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AnchorServlet")
public class AnchorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		
		// 2. 요청 파라미터 a, b
		int a = 0, b = 0;
		String strA = request.getParameter("a");
		if(strA != null) {
			a = Integer.parseInt(strA);
		}
		
//		a = Integer.parseInt(strA);
		
		String strB = request.getParameter("b");
		if(strB != null) {
			b = Integer.parseInt(strB);
		}
//		b = Integer.parseInt(strB);
		
		// => 전달받은 파라미터 a,b의 값이 null이 아니라면 정수로 변환
		// (처리하지않으면 NumberFormatException 발생)
		
		// 3. 응답(출력스트림 작성)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello World</h1>");
		out.println("<h1>" + a + "+" + b + "=" + (a + b) + "</h1>");
		out.flush();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
