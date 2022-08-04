package library_o;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor	// # 디폴트생성자
@Setter
@Getter
@AllArgsConstructor	// # 개발자생성자

@ToString


public class Book {
	
	private int bookNo;
	private String title;
	private String author;

}
