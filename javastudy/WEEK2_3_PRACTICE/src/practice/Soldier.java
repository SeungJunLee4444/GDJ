package practice;

public class Soldier {
	
	// # 필드
	private Gun gun;
	private String name;
	
	// # 생성자
	public Soldier(Gun mod, String name) {
		super();//-----------------------------------------------?
		// # 부모클래스의 생성자를 호출하는 역할을 한다
		// => this랑 함꼐사용x, 생성자 맨 처음에 있어야함
		super()
		this.name = name;
	}
	
	// # 아래의 메서드 코드를 통해 soldier 클래스를 선언하여 gun의 메서드를 
	// 한번에 호출할 수 있다
	
	// # 리로드
	public void reload(int bullet) {
		gun.reload(bullet);
	}
	
	// # 발사
	public void shoot() {
		gun.shoot();
	}
	
	// # info
	public void info() {
		System.out.println("군인이름:" + name);
		gun.info();
	}
	


}
