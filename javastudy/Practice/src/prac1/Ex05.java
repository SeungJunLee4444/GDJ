package prac1;

public class Ex05 {

	public static void main(String[] args) {
	
		String[] names = {
				"뽀로로",
				"크롱",
				"에디"
		};
		// # 3명의 학생을 배열로 표현
		
		int[] scores = new int[names.length];
		
		// # 이름배열과 같은 길이의 성적 배열 형성
		
		for(int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 101);
		}
		// # 새로만든 성적배열에 임의의 점수 저장
		
		
		int total = scores[0];
		int max = scores[0];	//# 최대값, 최소값
		int min = scores[0];	//# 그냥 배열 첫번쨰로 넣기
		int top = 0;
		int bottom = 0;
		
		// * top, bottom은 각 score 배열의 최대값, 최소값의 인덱스값
		
		for(int i = 1; i < scores.length; i++) {	// # 같은 배열값을 비교안하도록 1부터
			total += scores[i];
			if(max < scores[i]) {
				max = scores[i];
				top = i;
				// # 조건에 해당되면 if문을 실행
			}
			if(min > scores[i]) {
				min = scores[i];
				bottom = i;
			}
		}
		
		double average = (double)total / scores.length;
		System.out.println("평균 : " + average + "점");
		System.out.println("1등 점수 : " + max + "점");
		System.out.println("1등 이름 : " + names[top]);
		System.out.println("꼴등 점수 : " + min + "점");
		System.out.println("꼴등 이름 : " + names[bottom]);
		
	}
	
}
