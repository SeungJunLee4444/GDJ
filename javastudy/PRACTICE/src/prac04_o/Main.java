package prac04_o;

public class Main {

	public static void main(String[] args) {

		Tour tour1 = new KoreaTour();
		TourGuide guide1 = new TourGuide(tour1);
		
		guide1.sightseeing(); 	// 출력 : 광화문 여행
		guide1.leisure();		// 출력 : 한강유람선
		
		
		Tour tour2 = new GuamTour();
		TourGuide guide2 = new TourGuide(tour2);
		guide2.sightseeing(); 	// 출력 : 사랑의 절벽
		guide2.leisure();		// 출력 : 패들보트
		
//		 * 어떻게 guide와 메서드를 연결?
		// => tour을 필드값으로 가져와서, 다시 메서드로 만들면 된다
	}

}
