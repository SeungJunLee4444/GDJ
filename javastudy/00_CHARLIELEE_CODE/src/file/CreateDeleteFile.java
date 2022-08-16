package file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class CreateDeleteFile {
	
	public static void m1() {
		
		// 1. 폴더 만들고 삭제
		
		File dir = new File("C://charlie");
		if(!dir.exists()) {
			dir.mkdirs(); }
//		} else {
//			dir.deleteOnExit();
//		}
		
	}
	public static void m2() {
		
		// 2. 파일만들기
		
		File file = new File("c://charlie", "1.txt");
		try {
			if(file.exists() == false) {
				file.createNewFile(); }
//			} else {
//				file.delete();
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// * creativenewfile 사용시 ioeexception 발생
		
		
	}
	public static void m3() {
		
		// 3. file 메서드
		File file = new File("c://charlie", "1.txt");
		System.out.println("파일명:" + file.getName());
		System.out.println("경로:" + file.getParent());
		System.out.println("경로 + 파일명:" + file.getPath());
		System.out.println("폴더인가?" + file.isDirectory());
		System.out.println("파일인가?" + file.isFile());
		long lastModifiedDate = file.lastModified();
		System.out.println("마지막 수정날짜" + lastModifiedDate);
		// * simpledateformat로 날짜형식 만들어서 출력
		SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm: yyyy-MM-dd");
		String lastModified = sdf.format(lastModifiedDate);
		System.out.println(lastModified);
		long size = file.length();
		System.out.println("파일의 크기" + size);
		
		// * 마지막 수정날짜, 파일의 용량은 값이 클수 있기 때문에 long타입에 저장
	
		
	}
	public static void m4() {
		
		// 4. 폴더 상 모든 폴더, 파일 목록확인 
		
		File dir = new File("c:\\charlie");
		File[] list = dir.listFiles();
		System.out.println(list);
		// * 배열의 객체를 출력하면 주소값이 나온다
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
		
		// * listfiles 메서드를 사용하면,
		// 해당 폴더 상의 모든 폴더, 파일의 전체경로를 볼 수 있다
		
	}
	public static void m5() {
		
		// 5. 폴더 내 해당 폴더, 파일을 리스트로 출력하기(연습)
		File dir = new File("c:\\charlie");
		File[] list = dir.listFiles();
		
		int dirCnt = 0;
		int fileCnt = 0;
		long totalSize = 0;
		
		for(File file : list) {
			if(file.isHidden()) {
				continue;
			}
			// * ishidden 메서드로 숨김파일 여부 확인
			
			String lastmodified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
			String directory = file.isDirectory() ? "<DIR>" : "    ";
			String size = "";
			
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "";
				dirCnt++;
			} else if(file.isFile()) {
				directory = "";
				size = new DecimalFormat("#,##0").format(file.length());
				// * 파일의 크기(용량) 메서드는 length
				// * decimalformat의 반환값은 string이다
				fileCnt++;
				totalSize += Long.parseLong(size.replace(",", ""));
				System.out.println(size);
				// * decimalformat을 통해 만들어진 ,를 제외한 long값으로 총 용량계산
			}
			String name = file.getName();
			System.out.println(lastmodified + " " + directory + " " + size + " " + name);
		}
		System.out.println(dirCnt + "개 디렉터리");
		System.out.println(fileCnt + "개 파일    총" + totalSize + "바이트");
		
	}
	public static void m6() {
		
		// 6. separator 경로구분자
		
		File file = new File("c:" + File.separator + "charlie" + File.separator + "1.txt");
		// * 윈도우(\\), 리눅스/ 등 브라우저마다 다른 경로구분자를 File.separator로 구분가능
	
	}
	public static void m7() {
		
		// 7. 파일삭제 + separator 응용
		
		String sep = File.separator;
		
		File file = new File("c:" + sep + "charlie", "1.txt");
		if(file.exists()) {
//			file.delete();
		}
		
		File miniDir = new File("c:\\charlie\\minicharlie1");
//		miniDir.mkdir();
		
		File dir = new File("c:" + sep + "charlie");
		if(dir.exists()) {
			file.delete();
			miniDir.delete();
			dir.delete();
		}
		// * 해당 폴더 안에 폴더, 또는 파일이 있으면 삭제되지 않는다
		
		
	}

	public static void main(String[] args) {
	
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();


	}
}
	

