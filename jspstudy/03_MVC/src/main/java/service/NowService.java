package service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class NowService implements Myservice {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 1. now가 하는 일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a hh-mm-ss");
		String now = sdf.format(date);
		
		request.setAttribute("result", now);
		// => response를 안하고 서버에 요청을 전달? forward 전달
		
		// 어디로 갈 것인가
		// 어떻게 갈 것인가(redirect/forward)
		
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		actionForward.setRedirect(false); // 포워드하겠다
		return actionForward;
	}

}
