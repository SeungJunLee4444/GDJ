package ex10_up_down_파일첨부;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 
		 	FileUpload를 위한 COS 라이브러리
		 	- servlets.com
		 	- [Cos File Upload Library] - [Download] - [cos-22.05.zip]
		 	- 압축 해제 후 lib 디렉터리에 cos.jar
		 */
		
		/* 
		 	2. MultiPartRequest 클래스
		 	- cos 라이브러리가 지원하는 클래스(자바,톰캣에x)
		 	- httpservletrequest 클래스는 파일 업로드 처리가 불가능함
		 	- 파일 업로드를 위해서 MultipartRequest 클래스를 사용해야함
		 */
		
		// 1. 요청 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 업로드 할 경로 
		// 		- 실제 서버 경로 사용(물론 일반 드라이브 경로로 바꿀 수 있음)
		//		- ServletContext의 realPath() 메서드 사용
		String realPath = getServletContext().getRealPath("upload");	// => src/main/webapp(web root) 아래 storage
		// => 실무에서는 첨부파일의 경로를 매번 바꿔줄 필요가 있음
		// (첨부되는 파일이 시간이 지날수록 너무 많기 때문)
		
		// 3. 업로드할 디렉토리 생성
		File dir = new File(realPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 4. 업로드
		//	- cos 라이브러리가 지원하는 multipartrequest 객체를 생성하면 업로드가 진행됨
		MultipartRequest multipartRequest = new MultipartRequest(
				// 1) httpservletrequest 
				request,
				// 2) 업로드할 경로
				realPath,
				// 3) 업로드할 파일의 최대크기
				1024 * 1024 * 10,
				// 4) 인코딩
				"utf-8",
				// 5) 파일명 중복처리
				new DefaultFileRenamePolicy()
				// => 중복된 파일은 임의의 이름변경으로 처리
				// & 파일위치 확인
				// // => 파일위치: C:\GDJ\jspstudy\.metadata\.plugins\
				// org.eclipse.wst.server.core\tmp0\wtpwebapps\01_Servlet\업로드
				
				
				);
		// 5. 업로드 결과(& 일반 리퀘스트와 차이점)
		// => 파일 첨부시, 일반 리퀘스트인 httpservletrequest는 사용할 수 없음
		String uploader = multipartRequest.getParameter("uploader");
		String originalName = multipartRequest.getOriginalFileName("filename");	// name파라미터명, /원래이름
		String fileSystemName= multipartRequest.getFilesystemName("filename");	// name파라미터명, /원래이름
		File file = multipartRequest.getFile("filename");
		long size = file.length();				// 파일크기(바이트)
		String strSize = new DecimalFormat("#,##0").format(size);
		long lastModified = file.lastModified();	// 파일의 최종 수정일(타임스탬프값)
		String strLastModified = new SimpleDateFormat("yyyy-mm-dd a h:mm").format(new Date(lastModified));
		
		
		// => 파일첨부는 파라미터가 아니라 getoriginalfilename 메서드를 사용한다
		
		// ? 왜 전부 string으로 바꿔주지?
		// => html의 텍스트가 되어야하니까?
		
		// 6. 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>작성자:" + uploader + "</h3>");
		out.println("<h3>원래파일명:" + originalName + "</h3>");
		out.println("<h3>저장파일명:" + fileSystemName + "</h3>");
		out.println("<h3>파일크기:" + size + "</h3>");
		out.println("<h3>최종수정일:" + strLastModified + "</h3>");
		out.close();
		
		// => 파일위치: C:\GDJ\jspstudy\.metadata\.plugins\
		// org.eclipse.wst.server.core\tmp0\wtpwebapps\01_Servlet\업로드
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
