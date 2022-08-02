package library;

import java.util.Scanner;

// #1 내부에서만 메서드를 사용하도록 private 사용, 오직 다른 public 메서드를 통해 모든 작업이 가능하게 만든다

public class Library {
	
	private Scanner sc; 	// # 객체의 선언 (생성은 안된상태) *
	private Book[] books; 	// # 배열의 선언 (생성은 안된상태) *
	private int idx;		// # 책의 개수
	
	public Library() {
		sc = new Scanner(System.in);	// # 객체 생성	/ system.im 키보드연결
		books = new Book[100];			// # 배열 생성
	}									// * 배열 선언과 생성을 잘 구분할것

	private void addBook() {			// # 책등록
		if(idx == books.length) {		// # idx가 1씩 늘어나다가 배열의 길이와 같아질 때 재고가 꽉차게됨
										// => idx++ => if조건이 범위가 아닌이유
			System.out.println("더 이상 등록할 수 없습니다"); 
			return;
		}
		System.out.println("=== 책등록 ===");
		System.out.print("제목 입력 >>>"); // # print를 쓰면 출력문 옆에 입력 가능
		String title = sc.next();
		System.out.print("저자 입력 >>>");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);	// @AllArgsConstructor => 개발자생성자 추천
		books[idx++] = book; 			// # 입력받은 book의 값을 books 배열에 저장하고 idx 1증가
	}
	
	private void removeBook() {		// # 책 제거(책의 이름 또는 책의 번호로 코드작성 가능)
		System.out.println("=== 책제거 ===");
		System.out.print("삭제할 책의 번호(1~" + idx + ")>>> ");
		int bookNo = sc.nextInt() -1;		// 책값을 인덱스값으로(bookNo = idx)
		if(bookNo < 0 || bookNo >= idx) {		// # 책번호가 1보다 작거나 idx보다 많거나 클때 잘못입력
			System.out.println("책 번호가" + (bookNo + 1) + "인 책은 없습니다");
			return;
		}
		System.arraycopy(books, bookNo + 1, books, bookNo, idx - bookNo -1);
		// # 원본, 복사되는 곳, 배열의 길이?
		books[--idx] = null; // 2) 3) 한꺼번에 / idx는 책의 개수이니 인덱스면 하나 빼고 실행
		//book[i] = null / idx--;
		System.out.println("책 번호가" + (bookNo + 1) + "인 책을 삭제했습니다");
		
		// * 책을 지우는 법
		// 1) 9번째 책을, 8번째에 저장
		// 2) 맨 마지막 9번째 배열을 =null; 초기화
		// 3) idx--;	책 개수 줄이기
		// => arraycopy를 활용
		
	}
	
	private void findBook() {		// # 책 조회
		System.out.println("=== 책조회 ===");
		if(idx == 0) {
			System.out.println("등록된 책이 한 권도 없습니다"); 
			return;
		}
		System.out.println("=== 책조회 ===");
		System.out.println("조회할 책제목 입력 >>> ");
		String title = sc.next();					// # 조회할 책의 제목 : title
		for(int i = 0; i < idx; i++) {
			books[i].getTitle();					// # String 동등비교 : equal()
			if(books[i].getTitle().equals(title)) { // # 조회한 책과 저장된 책이 같은지?
				System.out.println(books[i]);
				return; // 책을 찾으면 findBook 메서드 종료, break로 for문을 끝내면 안됨
			}									// # 저장된 책의 제목 : books[i].title
		} 										// => books가 private에 저장되있기 때문에 book 클래스 메서드 호출?
		System.out.println("제목이" + title + "인 책은 없습니다");	// # 못찾았으면 실행문
												
												
	}
	
	private void printAllBooks() {	// # 전체 조회
		if(idx == 0) {				
			System.out.println("등록된 책이 한 권도 없습니다"); // # 등록된 책이 0권일때
			return;
		}
		System.out.println("=== 전체조회 ===");
		for(int i = 0; i < idx; i++) {	// # idx가 5권이면 5번 반복 ?
			System.out.println(books[i]);	// # books[i]는 배열에 저장된 하나의 책
			
			// => library.Book@735f7ae5 : 배열의 주소값이 출력 
		}
		
		
	}
	
	public void manage() {
		
		while(true) {				// # 무한루프
			System.out.print("1.추가 2.삭제 3.조회 4.전체목록 0.프로그램종료 >>> "); 
			int choice = sc.nextInt();		// # 입력받은 값을 저장해야함
			sc.nextLine();		// # 입력후 enter를 먹는 코드
								// => 불필요한 enter 제거하는 법
			switch(choice) {
			case 1: addBook(); break;	// # 1을 누르면 책을 추가하고 addbook메서드 호출
			case 2: removeBook(); break;
			case 3: findBook(); break;
			case 4: printAllBooks(); break;
			case 0 : System.out.println("Library 프로그램 종료"); 
					return; // # manage() 메서드 종료
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요");
		
			// # 무한 반복문은 조건에 맞지 않으면 다시 입력할 수 있게만들어준다
			
			}
			
		}
		
		
		
		
	}
	
	
}
