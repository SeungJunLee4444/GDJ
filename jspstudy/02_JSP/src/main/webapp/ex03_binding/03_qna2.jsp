<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 요청 파라미터(name속성)
	request.setCharacterEncoding("UTF-8");
	String createdDate = request.getParameter("created_date");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	// 2. 작성자 ip
	String ip = request.getRemoteAddr();
	
	// 파일명
	// 작성자IP_작성자.txt
	
	// 3. 파일명
	// => 작성자ip_작성자.txt	
	String filename = ip.replaceAll(":", "_").replaceAll("\\.", "_") + "_" + writer + ".txt";
	// => ip에 있는 모든 :, . 을 _로 바꾸기
	// 정규식 => "\\." 또는 [.] : .만 단독으로 사용하면 모든글자 적용
	
	// IPv4
	// 127.0.0.1
	// 127_0_0_1  replaceAll("\\.", "_")
	// IPv6
	// 0:0:0:0:0:0:0:1
	// 0_0_0_0_0_0_0_1  replaceAll(":", "_")

	// 4. 파일경로
	String realPath = application.getRealPath("storage" + File.separator + createdDate);
	// => 경로 생성, 없으면 폴더 만들기
	// & File.separator 
	// => 브라우저에 맞는 자동 구분자 생성
	// ex) 윈도우는 \, 리눅스는 /
	File dir = new File(realPath);
	if(dir.exists() == false){
		dir.mkdirs();
	}
	
	// 5. 생성할 파일 객체
	File file = new File(dir, filename);
	
	// 6. 문자 출력 스트림 생성
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	bw.write("작성일자 : " + createdDate + "\n");
	bw.write("작성자 : " + writer + "\n");
	bw.write("제목 : " + title + "\n");
	bw.write("내용\n" + content + "\n");
	bw.close();
%>
<script>
	var isCreated = <%=file.exists()%>;
	if(isCreated) {
		alert('<%=filename%> 파일이 생성되었습니다.');
	} else {
		alert('파일이 생성되지 않았습니다');
	}
	/* history.back();	// history 객체 : 뒤로 이동 */
</script>







