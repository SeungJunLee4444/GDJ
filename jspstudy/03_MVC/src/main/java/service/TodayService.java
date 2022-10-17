package service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class TodayService implements Myservice {
	
	// [MODEL]
	// => 모델은 클래스로 생성
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. today서비스가 하는 일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		// & => date와 simpledateformat 사용법
		
		// 2. 뷰(jsp)로 전달할 데이터(request에 저장)
		request.setAttribute("result", today);
		
		// 어디로 갈 것인가?
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		
		// 반환
		return actionForward;
	}

}
