package ex02_writter;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {
	
	public static void m1() {
		
		// 1. JSON ( * 매우중요)
		// => 자바스크립트 객체 표기법
		// ex) "name" : "100"
		
		// => 객체는 {}, 배열은 [], 숫자와 텍스트는 자바와 동일
		
		// 1) JSON-JAVA 라이브러리
		// => JSONObject: 객체(Map기반)
		// => JSONArray	: 배열(List기반,arrayList와 사용이 거의 같음)
		
		
		// ** jasonobject는 map과 동일한 메서드를 사용한다
		JSONObject obj = new JSONObject();
		// * 생성시 map을 전달하면, json으로 변화시켜줌
		obj.put("name", "가나다");	// Map 프레임워크와 동일
		obj.put("age", "15");
		obj.put("man", "true");
		obj.put("height", "180.5");
		System.out.println(obj);
		System.out.println(obj.toString());
		
		// 결과 : {"name":"가나다","man":"true","age":"15","height":"180.5"}
	}
	
	public static void m2() {
		
		// 2) 예시
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "제임스");
		obj1.put("age", 30);

		JSONObject obj2 = new JSONObject();
		obj2.put("name", "에밀리");
		obj2.put("age", 40);
		
		// ** 두 object 객체를 arr 배열에 입력
		JSONArray arr = new JSONArray();	// * collection소속 set와 list를 불러올수있음
		arr.put(obj1);
		arr.put(obj2);
		
		System.out.println(arr);
		System.out.println(arr.toString());
		
		}
	
	public static void m3() {
		
		String str = "{\"name\":\"가나다\",\"man\":\"true\",\"age\":\"15\",\"height\":\"180.5\"}";
		// * 공공api한테 받아온 데이터
		// => 라이브러리는 각 데이터를 뽑아 나눌수있음
		
		JSONObject obj = new JSONObject(str);	// * map이라 생각
		String name = obj.getString("name");
		// 문제1) 반환값은 object인데 저장은 string
		// => String으로 강제 캐스팅
		
		boolean man = obj.getBoolean("man");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		
		System.out.println(name);
		System.out.println(man);
		System.out.println(age);
		System.out.println(height);
		
		// 결과 : * 배열값을 각 데이터로 나눠서 출력
		// 가나다
		// true
		// 15
		// 180.5
	}
		
	public static void m4() {
			
		}

	public static void main(String[] args) {
		
		//m1();
		//m2();
		m3();
	}

	
}
