package Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.ActionForward;

public interface MyService {
	
	// # actionforward를 반환하는 모든 서비스의 인터페이스 메서드 생성
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
