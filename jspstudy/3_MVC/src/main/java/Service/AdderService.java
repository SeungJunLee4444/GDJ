package Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ActionForward;

public class AdderService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// # AdderService : input.do에서 입력된 파라미터값 2개를 호출해 직접 응답
		
		// 1. 요청 파라미터
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// 2. 응답
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + a + "+" + b + "=" + (a + b) + "')");
		out.println("history.back()");
		out.println("</script>");
		out.close();
		
		
		return null;
	}

}
