package prac;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/* 
 * http://localhost:9090/01_Servlet/now 주소를 입력하면,
 * 현재 날짜와 시간을 보여주기
 * => 요청하는 파라미터가 없으니 요청은 필요없음
 * => 응답으로 시간을 out.print()하면 된다
 * 
 * */

@WebServlet("/now")		// urlmapping값을 now로 변경
public class prac01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public prac01() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 응답 데이터 타입
		response.setContentType("text/html; charset=utf-8");
		
		// 응답 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 현재날짜 만들기
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH + 1);	// calendar은 달이 하나 적게 나옴
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		// 응답 만들기
		out.print("<h1>현재 시간은" + year + "년" + month + "월" + day + "일" + hour + "시" + minute + "분" + second + "초입니다</h1>");
		
		out.flush();
		out.close();
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
