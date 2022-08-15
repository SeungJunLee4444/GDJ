package file;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class F1_byteinput {
	
	public static void main(String[] args) {
	
			
			File file = new File("c://charlieLee1//f1", "byteinput");
			if(!file.exists())
				file.mkdirs();
			
			FileInputStream fi = null;
			DataInputStream di = null;
			
			try {
				
				di = new DataInputStream(new BufferedInputStream(fi));
				
				int a;
				while ((data = fi.read() != -1)) {
					
				}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}

	
	}
		
	}
	

