package common;

public class ActionForward {
	
	private String view; 			// 이동경로를 저장할 변수
	private boolean isRedirect;		// 이동방식(true면 redirect, false면 forward)

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
	
	

}
