package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.MemberDao;

public class MemberListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 7장 특징 : dao에서 가지고온 목록을 json으로 만들어서 직접 응답 
			
		// 응답데이터 형식(json)
		response.setContentType("application/json; charset=UTF-8");
		// => jsp는 오직 하나 뿐이기 때문에 html을 사용하지 않는다
		
		
		// 응답 데이터 만들기
		/* => 1) 예시와 같은 제이슨 만들기
		  {
		  	"count" : 3,
		  	"members" : [
		  		{
		  			"memberNo" : 1,
		  			"id" : "user1",
		  			"name" : "회원1",
		  			"gender" : "F",
		  			"grade" : "gold",
		  			"address" : "jeju"
		  		},
		  		{
		  			"memberNo" : 2,
		  			"id" : "user2",
		  			"name" : "회원3",
		  			"gender" : "M",
		  			"grade" : "silver",
		  			"address" : "seoul"
		  		},
		  		{
		  			"memberNo" : 3,
		  			"id" : "user3",
		  			"name" : "회원3",
		  			"gender" : "F",
		  			"grade" : "bronze",
		  			"address" : "yeosu"
		  		}	
		  	]
		  }
		 */
		JSONObject obj = new JSONObject();
		obj.put("count", MemberDao.getInstance().selectAllMembersCount());	// return된 멤버수가 속성값으로 저장된다
		obj.put("members", MemberDao.getInstance().selectAllMembers());		// 라이브러리로 
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());			// JSON 문자열 응답
		out.close();
		
		// 응답확인 url(index.jsp 또는 postman) : http://localhost:9090/07_Ajax/member/list.do
		
		
		
		
		
		
		
	}

}
