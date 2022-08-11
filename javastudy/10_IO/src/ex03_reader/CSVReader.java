package ex03_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static void main(String[] args) {

		
		File file = new File("c:\\storage", "product.csv") ;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			br.readLine();	// *1 첫행 읽어서 저장 안해버리기
			
			// # 한줄 읽어서 product 객체 생성하고 arraylist에 저장하기
			List<Product> products = new ArrayList<Product>();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				Product product = new Product();
				product.setNumber(arr[0]);
				product.setName(arr[1]);
				product.setPrice(Integer.parseInt(arr[2]));
				products.add(product);
				}
			// # arraylist 확인(반복문)
			for(Product product : products) {
				System.out.println(product);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
