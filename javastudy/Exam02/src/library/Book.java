package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor	// # new Book()
@AllArgsConstructor	// # new Book(1, "어린왕자", "생텍쥐베리")
@Getter				// # getBookNo(), getTitle(), getAuthor() : 값 불러오기
@Setter				// # setBookNo(), setTitle(), setAuthor() : 값 저장하기

@ToString			// # 출력된 배열의 주소값을 문자열로 변경해줌(source에도 자동완성 있음)

public class Book {
	
	private int bookNo;			// # 책 1~100번까지 자동으로 부여, 나머지는 사용자 입력
	private String title;		// # 
	private String author;

}
