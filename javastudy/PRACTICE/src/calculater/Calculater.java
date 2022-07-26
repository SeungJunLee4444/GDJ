package calculater;

import java.util.Scanner;

public class Calculater {

	public static void main(String[] args) {

		// 1
		String serial = "1234567";
		int number = Integer.parseInt(serial);
		String result = ((number / 1000000) == 1) ? "남자" : ((number / 1000000) == 2) ? "여자" : "";
		System.out.println(result);
		
		
		// 2
		int a = 7;
		int b = 2;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println((double)a / b);
	
		
		
		
		
		
			
		}
	
		
		
		
	}


