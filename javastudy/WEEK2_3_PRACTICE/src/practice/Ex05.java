package practice;

public class Ex05 {

	public static void main(String[] args) {
		
		// 5
		
		
		String[] names = {"피까츄", "뽀로로", "브레드"};
		
		// # 학생 수만큼의 성적 배열 형성
		int[] scores = new int[names.length];
		
		
		// # for문을 이용해 각 인덱스값에 1~100까지 랜덤의 정수를 넣는다
		for(int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 101);
		}
		// * Math.random에서 * 100을 곱하여 +1 하든, 101을 곱하든 똑같다
		
		// # 
		int total = scores[0]; 
		int max = scores[0];
		int min = scores[0];	// # 초기값을 처음부터 배열 0인덱스값으로
		
		int top = 0;
		int bottom = 0; 
		
		// * top, bottom은 각 score 배열의 최대값, 최소값의 인덱스값을 의미
		
		for(int i = 1; i < scores.length; i++) { // # idx1값부터 2번 
			total += scores[i];
			if(max < scores[i]) {
				max = scores[i];
				top = i;
			}
			// # 조건에 해당되면 if문을 실행
			
			// # 최대값 구하기
			if(min > scores[i]) {
				min = scores[i];
				bottom = i;
			}
			// # 최소값 구하기
			
			// * if문 i는 서로 별개
			// # 최소, 최대값은 idx0부터 참고하고, for문은 idx1부터 길이만큼 비교
			
		}
		
		double average = (double)total / scores.length;
		System.out.println("평균 : " + average + "점");
		System.out.println("1등 점수 : " + max + "점");
		System.out.println("1등 이름 : " + names[top] + "점");
		System.out.println("꼴등 점수 : " + min + "점");
		System.out.println("꼴지 이름 : " + names[bottom] + "점");
		
		
		
		

	}

}
