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
		// & request.getParameter
		// => id 파라미터에 입력된 값(value)에 접근하여 string 변수에 저장
		if(id.isEmpty()) {
			id = "빈 아이디";
		}
		
		// & isEmpty()	=> ""가 들어간상태
		// & null 차이	=> 아무런 주소값도 없음
		// null은 인스턴스가 생성되지 않은 상태, isempty는 인스턴스가 생성된 상태
		// 둘다 값이 존재하지 않는 상태다
		
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		// => isempty() : 입력된 값이 비어있으면(문자열의 길이로 공백여부확인)
		
		String gender = request.getParameter("gender");
		if(gender == null) {
			gender = "빈 성별";
		}
		//  => 선택안함 raio의 value값이 null
		
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
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];
			agree[0] = "빈 동의";
		}
		// => agree가 null값일경우, 새로운 배열을 만들어서 빈동의
		
		// 연습(이메일)
		String emailId = request.getParameter("email_id");
		String domain = request.getParameter("domain");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
