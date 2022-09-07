package repository;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ContactDAO {
	
	
	
	
	
	// ------------------------------------singleton pattern---------------------------------------------------
	
	//  DAO
	// - DB에 접근하는 객체는 오직 하나 뿐이야함
	// * singleton pattern이어야함
	// * DB에 접근하는 객체는 오직 하나뿐이어야함
	// * 만들어진 객체를 가져다 쓰는것만 가능
	// * 외부에서는 새로운 객체를 생성할 수 없음
	// DAO는 하나의 객체만 생성할 수 있도록, singleton pattern으로 생성
	// (INSERT문과 SELECT문이 동시에 이루어질 수 없기 때문)
	
	// 1. ContactDAO 객체를 하나 만들어둔다
	private static ContactDAO contactDAO = new ContactDAO();			// (1.클래스 내부에 해당 클래스의 객체를 생성)
	
	// 2. 외부에서는 ContactDao 객체를 못만들도록 제한한다
	
	private ContactDAO() {												// (2.private 제한자로 외부에서 생성자 호출 x)
		
	}
	
	// 3. 만들어둔 ContactDAO 객체를 외부에 반환한다
	
	public static ContactDAO getInstance() {							// (3.클래스 내에서 만든 객체를 외부에 반환)
		return contactDAO;												// static은 static 필드값만 호출할 수 있다(static과 관련된것들만 가능)
		
	}
	

//	public static void main(String[] args) {
//		
//	// 4. ContactDAO 객체 만들기
//	ContactDAO dao1 = ContactDAO.getInstance();	
//	ContactDAO dao2 = ContactDAO.getInstance();	
//		
//	System.out.println(dao1 == dao2);			// 같음, 객체의 주소값을 달라야 하지만, 클래스기 때문에 동일
//		
//	}
	
	// ------------------------------------field---------------------------------------------------
	
	// 5. 데이터베이스에 접근할 때 사용하는 공통 요소
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	// ------------------------------------method---------------------------------------------------
	
	// 6. 모든 데이터베이스 작업(CRUD : CREATE/READ/UPDATE/DELETE)의 공통작업은 2가지
	//(CREATE가 INSERT, READ가 SELECT를 의미)
	// 1) Connection 객체생성
	// 2) close
	
	// 1) Connection 메서드
	
	public Connection getConnection() throws Exception {	// (예외처리방법 : (1) 내부에서 try-catch 							x
															// 				   (2) throws해서 메서드 사용하는 곳에서 try-catch)	o
		//(1) OracleDriver 클래스 로드								=> (2) 예외들은 전부 CRUD 작업에서 try-catch 처리
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		// (2)Connection 객체 반환
		// db.properties 파일에 접속정보 읽기
		Properties p = new Properties();
		p.load(new FileReader("db.properties"));			// (경로없는 파일은 프로젝트 디렉터리에 있다는 뜻, 14_JDBC//db.properties)
															// (url, 아이디, 비번 파일은 텍스트 파일이니 reader)
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		return DriverManager.getConnection(url, user, password);
		
															// (개인정보가 전혀 안보이는 상태)
		
	}
	
	// 2) close 메서드
	public void close() {
		try {
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			ContactDAO dao = ContactDAO.getInstance();
			Connection con = dao.getConnection();
			
			System.out.println("접속성공");
			
		} catch (Exception e) {
			System.out.println("오류");
		}
		
	}
	
	
	
	
	
}




