package Service;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ActionForward;

public class NowService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// # NowService : 현재시간을 전달하는 서비스
		
		// 1. 시간계산
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
		String now = sdf.format(date);
		
		// 2. request 속성에 저장
		request.setAttribute("result", now);
		
		// 3. 이동경로와 이동방식 저장
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		actionForward.setRedirect(false);  // 포워드하겠다!
		
		
		return actionForward;
	}

}
