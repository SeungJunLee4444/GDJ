package practice;

public class 빈문자열 {
	
	public static void main(String[] args) {
		
		String str1 = "";
		System.out.println(str1.isEmpty());	// true
		
		String str2 = " ";
		System.out.println(str2.isEmpty());	// fasle
		
		String str3 = " ";
		System.out.println(str3.trim().isEmpty());	// true
		
		System.out.println(str1 == null);	// false
		System.out.println(str2 == null);	// false
		System.out.println(str2 == null);	// false
		
		
		
		
	}

}
