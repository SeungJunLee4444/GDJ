package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class AdderService implements Myservice {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		// 1. 요청파라미터 처리
		int a = Integer.parseInt(request.getParameter("a"));
		int b = Integer.parseInt(request.getParameter("b"));
		
		// [4] 2. 응답을 만들기
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + a + " + " + b + "=" + (a + b) + "')");
		out.println("history.back()");
		// & => 직접 모델에 응답을 만들경우 경로를 history.back, location.href를 자주 사용한다
		out.println("</script>");
		out.close();
		
		// 3. 직접 응답한 경우, actionForward를 반환하지 않는다(요청과 응답이 끝났기 때문)
		// => actionforward가 컨트롤러에서 null처리 되기 때문에, if로 null을 예외처리해야한다
		return null;
	}

}
