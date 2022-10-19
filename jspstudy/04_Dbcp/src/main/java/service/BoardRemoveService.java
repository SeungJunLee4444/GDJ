package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardRemoveService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
		int board_no = Integer.parseInt(opt.orElse("0"));
		// => board_no라는 파라미터가 올 수 있는데 null이 있을 수 있으니 optional로 감싼다
		// => null이 되면 오류(integer.parseint떄문 => null 예외발생)
		// => 데이터가 없는 경우(null) => orElse 메서드로 0을 호출
		// => board_no가 0번인 게시글은 없기 때문에, controller의 삭제메서드에 던져지면 삭제되지 않는다(0이 아니어도 -99999등 없는 데이터를 입력해도된다)
		
		// DB로 board_no로 보내서 삭제
		int result = BoardDao.getInstance().deleteBoard(board_no);
		
		// 삭제 성공/실패 여부를 콘솔에 출력
		System.out.println("삭제 여부 :" + result);
		
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/board/list.do");	// redirect할 때는 매핑으로 이동하는 것이 기본(요청이 두번 들어가야함)
		af.setRedirect(true);										// delete 이후에는 redirect
		return af;				
		
		// & 리다이렉트(요청을 두번 만들어줘야함)
		// (1)
		// (2)
	}

}
