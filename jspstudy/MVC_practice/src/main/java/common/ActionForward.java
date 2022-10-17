package common;

public class ActionForward {
	
	// [jsp 파일로의 이동을 위한 클래스(포워트, 리다이렉트)]
	
	private String view;			// 응답할 jsp 이름
	private boolean isRedirect; 	// 이동방식(true면 리다이렉트, false면 포워드)
	
	
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

	
	
}
