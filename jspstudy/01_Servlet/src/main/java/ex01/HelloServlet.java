package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
 * [servlet]
 * - ���� : �� ȭ���� ����� �ڹ� Ŭ����
 * - jsp/servlet container(tomcat)�� ���� ����
 * - ������ �����ϸ� �� �������� ����ȴ�
 * - url
 * 		- ���� : ��������://ȣ��Ʈ:��Ʈ��ȣ/���ؽ�Ʈ�н�/URLmAPPING(����)
 * 		(1) ���ؽ�Ʈ�н�: ������Ʈ �̸�
 * 		(2) URLMapping	: ���� �̸�
 * 		http://localhost:9090/01_Servlet/HelloServlet
 * 
 * 		& ���ؽ�Ʈ�н�(context path(root))
 * 		- was(��Ĺ)���� �� ���ø����̼��� �����ϱ� ���� path
 * 		& URLMapping
 * 
 * 1) HttpServlet
 * - ��� servlet Ŭ������ httpservlet�� ����� �޴´�
 * */


@WebServlet("/HelloServlet")	// URLMapping��

public class HelloServlet extends HttpServlet {	// Servlet Ŭ������ HttpServlet�� ��ӹ����� �ȴ�
	/* 
	 * 1. ������(HelloServlet()
	 * 	- ���� ���� ����ȴ�
	 * 	- ������ ȣ�� �� init() �޼��尡 ȣ��			*1
	 * */
    public HelloServlet() {
        super();
        System.out.println("������");
        // TODO Auto-generated constructor stub
    }
    
    /* 
     * 2. �ʱ�ȭ(init)
     * 	- ���� �ʱ�ȭ ���� ����
     *  - ���� ȯ�漳�� ó��
     *  - init() �޼��� ȣ�� �� service() �޼��� ȣ��	*2
     * 	- conf(config) Ű����� �ʱ�ȭ�� �ǹ� 
	*/
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}
	
	/* 
	 *	3. ����(service) 
	 * - Ŭ���̾�Ʈ�� ��û���� �Ź� ȣ��
	 * - ó�� ����� (1) �����ذ��ϰų�, (2) doGET, doPOST�� ����� ó��
	 * => ��ó�� (2)�� ����Ѵ�
	 * 
	 * (1) GET ��� : doGET() �޼��� ȣ��
	 * (2) POST ��� : doPOST() �޼��� ȣ��
	*/

	/**		// /** �ڹٵ� : �ּ��ƴ�?
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		
		// * service �۾��� �ܿ��ʿ����(������ �˾Ƽ� ó����)
		
		// service �޼��常 �����ϴ� ��� dGET(), doPOST() �� �ڵ����� ȣ����� �ʱ� ������
		// �ڵ带 ���� �ۼ�

		// ��û �޼��� Ȯ�� : request.getMethod()
		switch(request.getMethod()) {
		case "GET" : 
			doGet(request, response); break;	// �Ű����� request, response�� �޾� doGet�޼����� �Ű������� ����
		case "POST" :
			doPost(request, response); break;
		}
	}
	
	/* 
	 * 4. doGet
	 * 	- GET ����� ��û�� ó��
	 *  - & �ּ�â�� ���� �̿��ؼ� �̵��ϴ� ����� get ����̶� �Ѵ�
	 *  	(1) ajax
	 *  	$.ajax({
	 *  		'type' : 'GET';
	 *  		'URL' : '01_Servlet/HelloServlet'
	 *  	})
	 *  	(2) ��ũ 
	 *  	<a href="http://localhost:9090/01_Servlet/HelloServlet">��ũ</a>
	 *  	(3) ��
	 *  	<form method="GET" action="http://localhost:9090/01_Servlet/HelloServlet""> �Ǵ� <form> (����Ʈ�� get)
	 *  	(4) js : location.href='http://localhost:9090/01_Servlet/HelloServlet'	?
	 * 		(5) js : open('http://localhost:9090/01_Servlet/HelloServlet')			?
	 * */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// response : ����ڿ��� �����ϰڴ�
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// => �����ϴ� �޼���		
	}

	/* 
	 * 5. doPost
	 *  - POST ����� ��û�� ó��
	 *  - ��û �޼��尡 post�� ���
	 *  	(1) $.ajax({
	 *  		'type' : 'post'
	 *  		'URL' : '01_Servlet/HelloServlet'
	 *  })
	 *  	(2) ��
	 *  	<form method="post" action="http://localhost:9090/01_Servlet/HelloServlet""> �Ǵ� <form> (����Ʈ�� get)
	 
	 * 	& http://localhost:9090/01_Servlet/HelloServlet�� ���ּҿ� ���� �Է��ϸ� ����� �� �ֳ�?
	 * - ��Ĺ�� ���������� ���డ��, �ƴϸ� �Ұ���
	 * 
	 * 
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// ��û�� ���������� doGet()�� �ѱ�(���� ����ó���� doGet()
		doGet(request, response);
	}

}
