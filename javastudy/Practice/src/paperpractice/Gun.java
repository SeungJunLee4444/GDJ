package paperpractice;

public class Gun {
	
	// # 필드
	private String mod;
	private int bul;
	// # 1로하면 기본값이 1이 되버리니까 안됨
	private final int Full_BULLET = 6;
	// # 총알 6개가 최대 장전수임을 필드값에 고정하는방법이 있음 *
	
	// # 생성자
	public Gun(String mod) {
		this.mod = mod;
//		this.bul = bol;
	}
	// # shoot
	public void shoot() {
		if(bul < 0) { 
			bul = 0;
			System.out.println("총알이 없다");
		}
		bul--;
		System.out.println("빵!" + bul +"발 남았다");
			return;
	}
	
	// # reload
	public void reload(int bul) {
		this.bul += bul * 3;
		if(this.bul > Full_BULLET) {
			this.bul = Full_BULLET;
		}
	}
	
	// # info(정보)
	
	public void info() {
		System.out.println(mod + "("+  bul + ")");
	}
	

	
	
}
