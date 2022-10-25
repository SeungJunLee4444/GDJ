package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardDetailService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// <a href="detail.do?no=1">제목</a> : 이런 요청은 no=1을 그대로 사용
		// <a href="detail.do">제목</a>      : 이런 요청은 no=0으로 사용
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		long no = Long.parseLong(optNo.orElse("0"));
			
		// & 조회수 증가 연습문제-------------------------------------------------------------------------------
		// 1. BoardDetailService가 사용되는 3가지 경우
		//     1) 목록보기에서 제목을 클릭했을 때          referer는 http://localhost:9090/Dbcp_Practice/list.do
		//     2) 상세보기에서 편집버튼을 클릭했을 때      referer는 http://localhost:9090/Dbcp_Practice/detail.do?no=1
		//     3) 수정화면에서 수정완료 버튼을 클릭했을 때 referer는 http://localhost:9090/Dbcp_Practice/modify.do
		// 2. 목록보기에서 제목을 클릭한 경우만 상세보기가 진행된 것으로 보고 조회수를 증가한다.
		// 3. 상세보기가 진행되면 session에 updateHit를 등록하고 목록보기로 빠져 나갈 때 updateHit를 제거한다. 
		
		// & 개인해석#####################################################################################
		// - 목록보기에서 제목을 클릭한 경우에만 조회수를 증가하도록 만들겠다는 뜻
		// 조건에 해당하는 두 경우
		// (1) 이전주소가 list.do였을때				
		// (2) session의 updateHit속성이 null값일때
		
		// 1) request.getHeader("referer") : 헤더를 통해 얻을 수 있는 이전주소
		// 2) referer.endsWith("list.do") : list.do로 끝나는 문자열인지 확인
		// - endswith메서드는 ()안의 문자열로 끝나는 문자열인지 boolean 값으로 응답한다
		// 3) session.getAttribute("updateHit") == null : 업데이트 속성이 아직 올라가지 않은 경우
		//#####################################################################################
		
		
		String referer = request.getHeader("referer");  // referer는 이전 주소를 의미합니다.
		HttpSession session = request.getSession();
		if(referer.endsWith("list.do") && session.getAttribute("updateHit") == null) {  // 목록보기에서 제목을 클릭했다. + session에 updateHit 속성이 없다.
			// 조회수 늘리기 (조회수 증가 여부는 체크하지 않는다.)
			BoardDAO.getInstance().updateHit(no);
			// 조회수 증가를 했다는 의미로 session에 updateHit 속성을 저장해 둔다.
			session.setAttribute("updateHit", "done");
		}
		
		// 조회 결과 가져오기
		BoardDTO board = BoardDAO.getInstance().selectBoardByNo(no);
		
		// 조회 결과가 없는 경우
		 if(board == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('조회 결과가 없습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		// 조회 결과가 있는 경우
		} else {
			request.setAttribute("board", board);
			return new ActionForward("board/detail.jsp", false);
		}
		
	}

}
