package library_o;

import java.util.Scanner;

public class Library {
	
	private Scanner sc;
	private Book[] books;
	private int idx;		// 인트값
	
	public Library() {
		sc = new Scanner(System.in);
		books = new Book[100];		
	}
	
	private void addBook() {
		if(idx == books.length) {
			System.out.println("더 이상 등록할 수 없습니다");
			return;
		} 
		System.out.println(" === 책등록 === ");
		System.out.println("제목 입력 >>>");
		String title = sc.next();
		sc.nextLine();
		System.out.println("저자 입력 >>>");
		String author = sc.next();
		Book book = new Book(idx + 1, title, author);	// idx에 +1 한것이 bookNo
		books[idx++] = book;
		
	}
	
	private void removeBook() {
		if(idx == 0) {
			System.out.println("제거할 책이 없습니다");
			return;
		}
		System.out.println(" === 책삭제 === ");
		System.out.println("삭제할 책의 번호 >>>");
		int bookNo = sc.nextInt();
		for(int i = 0; i < idx; i++) {
			if(books[i].getBookNo() == bookNo) {
				System.arraycopy(books, i + 1, books, i, idx -i -1);	
				// 해석 : 제거하려는 책 바로 뒤의 배열값들을 한칸씩 앞당기는 코드
				books[--idx] = null;
				// * idx는 책 추가 이후 최종적으로 배열의 길이값이되기 떄문에(인덱스 +1)
				// 해석 : 뒤에 남은 배열값을 null로 초기화
				System.out.println("책 번호가" + bookNo + "인 책을 삭제했습니다");
				return;
			
			}
		}
		System.out.println("책 번호가" + bookNo + "인 책은 없습니다");
		
		
		
	}
	
	private void findBook() {
		System.out.println("=== 책 조회 ===");
		if(idx == 0) {
			System.out.println("등록된 책이 없습니다");
			return;
		}
		System.out.println("=== 책 조회 ===");
		System.out.println("조회할 책제목 입력 >>>");
		String title = sc.next();			// next는 줄바꿈 못읽음, nextLine은 줄바꿈읽음
		sc.nextLine(); // ?
		for(int i = 0; i < idx; i++) {
			if(books[i].getTitle().equals(title)) {
				System.out.println(books[i]);
				return;
			}
		}
		System.out.println("제목이" + title + "인 책은 없습니다");
		
		
	}
	
	private void printAllBook() {
		if(idx == 0) {
			System.out.println("등록된 책이 한권도 없습니다");
			return;
		}
		System.out.println("=== 전체조회 ===");
		for(int i = 0; i < idx; i++) {
			System.out.println(books[i]);	// # tostring으로 문자값 출력
		}
	}
	
	public void manage() {
		
		while(true) {
			System.out.println("1. 추가 2. 삭제 3. 조회 4. 전체목록 0. 프로그램 종료");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : addBook(); break;
			case 2 : removeBook(); break;
			case 3 : findBook(); break;
			case 4 : printAllBook(); break;
			case 0 : System.out.println("프로그램 종료");
					return;
			default : System.out.println("알 수 없는 명령입니다. 다시 시도하세요");
			}	
			
		}
	
		
	}
	
	
	
	
	
	
	
	

}
