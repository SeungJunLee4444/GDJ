
package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// & 서블릿 안은 '서버'
		
		
		
		// 1. 요청
		
		// 1) 요청에 포함된 한글처리
		request.setCharacterEncoding("utf-8");
		
		// 2) 요청 파라미터 확인
		//	(1) URL?파라미터=값&파라미터=값
		//	(2) 모든 파라미터는 String 타입!
		String name = request.getParameter("name");
		String strAge = request.getParameter("name");
		
		// null처리
		int age = 0;
		if(strAge != null) {
			age = Integer.parseInt(strAge);
		}
		// => null값을 변환하려하면 numberformatexception 오류발생
		// (숫자가 아닌걸 숫자로 변환할때 발생하는 오류)
		
		// 2. 응답
		// - 서버 -> 클라이언트로 보내는 응답
		// - HttpServletResponse response 객체가 처리(톰켓이 있어야 사용가능)
		
		// 1) 사용자에게 전달할 데이터의 형식을 html문서로 결정, mine-type활용
		// & mine-type
		// (1) HTML : text/html
		//    (2) CSS  : text/css
		//    (3) JS   : text/javascript
		//    (4) XML  : application/xml
		//    (5) JSON : application/json
		
		// 2) 응답에 포함되는 한글처리 + minetype
		response.setContentType("text/html; charset=utf-8");
		
		// 3) 응답스트림 생성
		//	- 문자출력스트림(writer) 생성
		//	- response 객체로부터 printwriter 객체를 얻을 수 있음
		//	- ioexception 필요 -> throw로 이미 처리
		//	- wirte()메서드 보다는 print()/println()메서드를 사용하는 것이 권장
		PrintWriter out = response.getWriter();
		
		// 4) 응답 만들기(html문서 만들기)
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>");
		out.println("나의 첫 번째 응답");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>안녕하세요. " + name + "님 반갑습니다 ♥</h1>");
		if(age >= 20) {
			out.println("<h1>귀하는 " + age + "살이므로 입장이가능합니다</h1>");
		} else {
			out.println("<h1>" + age + "살? 애들은 다음에</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();  // 출력 스트림에 남아 있는 모든 데이터 내보내기 (만약을 위해서)
		
	
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}