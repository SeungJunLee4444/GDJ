package service;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface Myservice {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	// & 추상클래스와 인터페이스의 차이
	// 추상클래스 : 추상 클래스를 상속받아서 기능을 이용하고 확장
	// 인터페이스 : 인터페이스에는 함수의 껍데기만 있으며, 상속받은 클래스에서 해당 메서드를 강제 구현시키기 위함

}
