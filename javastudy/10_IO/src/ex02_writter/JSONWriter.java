package ex02_writter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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
		
		
		
		// & 
		// jsonobject를 통해, 해당 클래스의 메서드를 호출 가능해진다
		// => map과 비슷한 put 등의 메서드를 사용가능하며, 
		// ex) 값을 가져올때는 get
		// => 이때 value값에 맞는 타입을 저장하기 위한 get~ 등의 메서드를 사용한다
		
		
		
		
		
		
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
		
		// 3. jsonobject로 각 데이터별로 나눠서 출력
		
		String str = "{\"name\":\"가나다\",\"man\":\"true\",\"age\":\"15\",\"height\":\"180.5\"}";
		
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
		
		// 4. 18일차
		
		String str = "[{\"name\":\"제임스\",\"age\":30},{\"name\":\"에밀리\",\"age\":40}]";
			
		JSONArray arr = new JSONArray(str);
		
		// * 일반 for문
		
		for(int i = 0, length = arr.length(); i < length; i++) {
			// * 저장이 되있는 요소는 총 두개있다
			JSONObject obj = arr.getJSONObject(i);
			// => str 배열의 요소 0번째
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + "," + age);
		}
		
		// * 향상 for문
		// => 기본적으로 get()메서드로 동작
		// => arr의 타입은 object기 때문에, jsonobject와 타입이 맞지 않아 오류발생
		for(Object o : arr) {
			JSONObject obj = (JSONObject)o;
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + "," + age);
			
		}
		
		}

	public static void main(String[] args) {
		
		m1();
		m2();
		//m3();
		//m4();
		
		List<String> product1 = Arrays.asList("100", "새우깡", "1500");
		List<String> product2 = Arrays.asList("101", "양파링", "2000");
		List<String> product3 = Arrays.asList("102", "홈런볼", "3000");
		
		List<List<String>> list = Arrays.asList(product1, product2, product3);
		
		// # list를 json string으로 만들고 c:\\storage\\product.json 파일에 write
		
		JSONArray arr = new JSONArray(list);	// * collection 선택지로 list, set 전달가능
		System.out.println(arr);
		
		// 결과 : [["100","새우깡","1500"],["101","양파링","2000"],["102","홈런볼","3000"]]
		// => json 데이터의 모습이 아님(json은 map 형태)
		
		for(List<String> line : list) {
			// * 향상 for문은 전하는 타입과 받는 타입이 동일해야한다
			JSONObject obj = new JSONObject();
			obj.put("number", line.get(0));
			obj.put("name", line.get(1));
			obj.put("price", line.get(2));
			arr.put(obj);
			// * list 데이터를 jsonobj객체에 형식에 맞게 저장하고, 이를 jsonarray에 저장
		}
		System.out.println(arr);
		
		File file = new File("c:\\storage", "product.json");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
			bw =new BufferedWriter(fw);
			bw.write(arr.toString());	// * arr의 데이터를 문자열로 변환
		} catch (IOException e) {
			e.printStackTrace();  // * 오류를 화면에 그대로 찍어줌
		} finally {
			try {
			if(bw != null) {
				bw.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}
