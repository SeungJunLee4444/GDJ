package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyService {
	
	// [3] 모든 서비스(모델)은 인터페이스로 통일한다
	
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
