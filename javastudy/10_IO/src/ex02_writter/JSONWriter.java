package ex02_writter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONWriter {
	
	public static void m1() {
		
		// 1. JSON ( * 매우중요)
		// => 자바스크립트 객체 표기법
		// => 객체는 {}, 배열은 [], 숫자와 텍스트는 자바와 동일
		// ex) "name" : "100"
		
		// 1) JSON-JAVA 라이브러리
		// (1) JSONObject	: 객체(Map기반)
		// => map과 동일한 메서드를 사용 가능해짐
		// (2) JSONArray	: 배열(List기반,arrayList와 사용이 거의 같음)
		
	
		// 2. jsonobject객체에 데이터 저장
		
		JSONObject obj = new JSONObject();	// => 생성시 map을 전달하면, json으로 변화시켜줌
		obj.put("name", "가나다");	
		obj.put("age", "15");
		obj.put("man", "true");
		obj.put("height", "180.5");
		System.out.println(obj);
		System.out.println(obj.toString());
		
		// 결과 : {"name":"가나다","man":"true","age":"15","height":"180.5"}
		// => map의 출력과 유사, 객체라 {}
	}
	
	public static void m2() {
		
		// 3. jsonobject 객체를 jsonarray에 저장
		// => jsonarray는 list 기반이기 때문에, collection 소속인 set과 list를 생성자에 불러올 수 있다
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
		
		// 결과 : [{"name":"제임스","age":30},{"name":"에밀리","age":40}]
		// => [] 배열로 변환되었기 때문에 대괄호 등장
		
		}
	
	public static void m3() {
		
		// 4. jsonobject로 각 타입별로 데이터를 나눠서 출력
		
		String str = "{\"name\":\"가나다\",\"man\":\"true\",\"age\":\"15\",\"height\":\"180.5\"}";
		
		JSONObject obj = new JSONObject(str);	// * map이라 생각
		String name = obj.getString("name");
		boolean man = obj.getBoolean("man");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		// * jsonobject를 통해 get 메서드로 타입별로 데이터를 나눠서 저장할 수 있다
		
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
		
		// 5. 복수의 데이터를 배열에 저장하여 원하는 데이터값만 출력
		
		String str = "[{\"name\":\"제임스\",\"age\":30},{\"name\":\"에밀리\",\"age\":40}]";
		// => 두개의 데이터

		JSONArray arr = new JSONArray(str);
		System.out.println(arr);
		
		// * 일반 for문으로 순회
		
		for(int i = 0, length = arr.length(); i < length; i++) {

			JSONObject obj = arr.getJSONObject(i); 
			// => 객체선언
			String name = obj.getString("name");
			int age = obj.getInt("age");
			System.out.println(name + "," + age);
			// => obj에 속한 get 메서드로 타입별 데이터 저장 후 호출
		}
		
		// * 향상 for문
		// => 기본적으로 get()메서드로 동작
		// => arr의 타입은 object기 때문에, jsonobject와 타입이 맞지 않아 오류발생
		
		// * arr의 데이터 타입이 여러가지기 때문에, 모든 타입을 받을 수 있는 object타입을 선언
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
		m3();
		m4();
		
		// 6.
		
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
			// * jsonobj는 key, value타입으로 데이터를 저장한다
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
