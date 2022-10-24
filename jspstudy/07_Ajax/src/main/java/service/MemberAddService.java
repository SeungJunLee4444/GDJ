package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDao;

public class MemberAddService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터(member.jsp로부터)
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String address = request.getParameter("address");
		
		// 파라미터로 저장한 값들을 member dto에 삽입
		Member member = Member.builder()
				.id(id)
				.name(name)
				.gender(gender)
				.grade(grade)
				.address(address)
				.build();
		
		// 만든 dto를 바탕으로 삽입메서드 실행 
		int result = 0;
			
		try {
			
			result = MemberDao.getInstance().insertMember(member);
			
			
			// * 응답을 둘 중 하나로 고름
			// 응답
			response.setContentType("application/json; charset=utf-8");
			
			// 응답데이터 형식(일반텍스트)
			/* 
			 	1) 삽입성공
			 	{
			 	"isSuccess" : true
			 	}
			 	
			 	2) 삽입실패
			 	{
			 	"isSuccess"	: false
			 	}
			 */
			
			// 제이슨
			JSONObject obj = new JSONObject();
			obj.put("isSuccess", result > 0);	// 0보다 크면 true, 아니면 false
			
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.close();
			
			
		} catch (Exception e) {
			// 예외처리 응답 형식(ajax의 error 프로퍼티로 응답)
			response.setContentType("text/plain; charset=utf-8");
			
			// 예외처리 응답 
			PrintWriter out = response.getWriter();
			out.println("신규 회원 등록이 실패했습니다. \n입력데이터를 확인하세요");
			out.close();
		}
		
		// try,catch문 뒤에는 어떤 코드도없음(규칙)?
		
		
		
	}

}
