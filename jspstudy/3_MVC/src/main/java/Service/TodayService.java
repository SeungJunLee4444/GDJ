package Service;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ActionForward;

public class TodayService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// # todayservice
		// index.jsp에서 해당 서비스를 요청하면, 현재 시간을 출력하는 서비스를 제공
		
		// 1. 현재시간 계산
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		// 2. 뷰(jsp)로 전달할 데이터를 request에 저장한다
		request.setAttribute("result", today);
		// => request 영역에 result라는 키값에 today변수에 저장된 속성값을 저장하여 전달
		
		// 3. 경로 전달
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");	// webapp내에서 jsp의 경로
		actionForward.setRedirect(false);			// forward 이동
		
		
		return actionForward;
	}

}
