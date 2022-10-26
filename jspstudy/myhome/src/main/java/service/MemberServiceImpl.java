package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Member;
import memberDao.MemberDao;

public class MemberServiceImpl implements MemberService {

	@Override
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {
		
		// [로그인서비스]
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.build();
		
		Member login = MemberDao.getInstance().login(member);
		if(login != null) {
			// # 성공
			// 로그인정보는 session에 저장
			// * session은 request를 이용해 session을 얻을 수 있다
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			return new ActionForward(request.getContextPath(), true);	// getContextPath : index.jsp로 넘어가는것
		} else {
			try {	// 입출력이니 예외처리
			PrintWriter out = response.getWriter();		// => jsp페이지로 반환하기 때문에 script문을 사용하는것
			out.println("<script>");
			out.println("alert('로그인실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;	// * 반환값이 있는 메서드에서, if - else 문 둘다 return이 들어가야한다
		}

	}

	@Override
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		
		// [로그아웃 서비스]
		
		// 세션에 저장된 값을remove
		HttpSession session = request.getSession();
		session.invalidate();						// 세션 초기화
		
		
		return new ActionForward(request.getContextPath(), true);
		

	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancel(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
