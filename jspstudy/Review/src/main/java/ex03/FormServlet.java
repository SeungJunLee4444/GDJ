package ex03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 변수(파라미터 = name)
		// & getParameter을 사용하여 해당 파라미터와 파라미터값을 가져온다
		// => 파라미터의 값에 접근하기 위해서는 getAttribute,setAttribute 메서드사용?
		
		String id = request.getParameter("id");
		if(id.isEmpty()) {
			id = "빈 아이디";
		}
		
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		
		String gender = request.getParameter("gender");
		if(gender == null) {
			gender = "빈 성별";
		}
		// => 선택안함의 value값이 "" => null과 동일
		// & 자바에서는 ""는 공백, 즉 null로 인식한다
		// " "는 공백이 아니다
		
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "빈 도시";
		}
		
		String[] phone = request.getParameterValues("phone");
		if(phone[0].isEmpty()) {
			phone[0] = "빈전화";
		}
		if(phone[1].isEmpty()) {
			phone[1] = "빈 전화2";
		}
		if(phone[2].isEmpty()) {
			phone[2] = "빈 전화3";
		}
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
