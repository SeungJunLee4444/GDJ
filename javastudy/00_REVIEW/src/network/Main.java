package network;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int result1 = a * ((b % 100) % 10); // 1자리
		int result2 = (a * ((b % 100) / 10)); // 100자리 곱하기
		int result3 = (a * ((b / 100))); // 100자리 곱하기

//		int totalResult = result1 + (result2 * 10) + (result3 * 100);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(a * b);

	}
}