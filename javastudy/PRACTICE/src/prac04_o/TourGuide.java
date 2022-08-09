package prac04_o;

public class TourGuide {
	
	
	private Tour tour;
	

	public TourGuide(Tour tour) {
		super();
		this.tour = tour;
		
	}
	
	public void sightseeing() {
		tour.sightseeing();
	}
	
	public void leisure() {
		tour.leisure();
	}
	
	// * 인터페이스를 필드값으로 가지고 있으면,
	// => 해당 인터페이스의 메서드, 오버라이딩 된 메서드들을 출력할 수 있다
	

	
	
	


	
	
	
	

}
