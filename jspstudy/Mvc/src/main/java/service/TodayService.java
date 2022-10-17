package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodayService implements MyService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// Model : todayservice
		
		// 1) todayService가 할일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		// 2) 뷰(Jsp)로 전달할 데이터는 request에 속성으로 저장한다.
		request.setAttribute("result", today);
		
		// 3) 경로 생성
		
		// 어디로 갈 것인가?(응답 Jsp 명시)
		// 어떻게 갈 것인가?(리다이렉트 또는 포워드)
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		actionForward.setRedirect(false);  // 포워드하겠다!
		
	}

}
