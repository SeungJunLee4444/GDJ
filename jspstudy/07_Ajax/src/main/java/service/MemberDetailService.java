package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDao;

public class MemberDetailService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터(회원번호)
		Optional<String> opt = Optional.ofNullable(request.getParameter("memberNo"));
		
		// & request.getParameter
		// => (클라이언트)가 요청한 멤버 번호값
		// (요청한 http요청은 파라미터에 저장되있음)
		
		// 왜 파라미터?
		int memberNo = Integer.parseInt(opt.orElse("0"));
		
		// 응답 데이터 형식 json
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 만들기
		/* 
		  1) 조회된 회원이 있는경우
		  {
		  	"exist" : true,
		  	"member" : {
		  			"memberNo" : 1,
		  			"id" : "user1",
		  			"name" : "회원1",
		  			"gender" : "F",
		  			"grade" : "gold",
		  			"address" : "jeju"
		  	}
		  }
		  
		  
		  2) 조회된 회원이 없는경우
		  
		  {
		  	"exist" : false
		  }
		 */
		Member member = MemberDao.getInstance().selectMemberByNo(memberNo);
		// & memberNo의 파라미터값 사용 이유
		// (1) 요청을 통해 전달받은 memberNo 파라미터값(null일 경우 0으로 처리, 위에 코드참고)
		// (2) selectMemberByNo 메서드를 통해 memberNo를 전달하면 해당 Memeber의 학생정보를 전달받는다 
		boolean exists = member != null;	// 멤버가 존재하면 exists
		
		JSONObject obj = new JSONObject();
		obj.put("exists", exists);
		if(exists) {
			obj.put("member", new JSONObject(member));
		}
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.close();
		
		

	}

}
