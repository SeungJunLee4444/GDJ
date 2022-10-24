package Common;

public class ActionForward {

	// # ActionForward
	// - MVC방식은 여러 JSP를 이동하기 때문에,
	// 경로 이동시 방법에 대한 클래스가 필요하다(리다이렉트 OR 포워드)
	
	private String view;		// 응답할 jsp 이름
	private boolean isRedirect; // 이동방식(true면 리다이렉트, false면 포워드)
	
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	// - 경로 여부에 대한 내용만 저장, 또는 호출하고
	// 실질적인 경로 이동은 controller에서 실행 
	

}
