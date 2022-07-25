package calculater;



public class Calculater {

	public static void main(String[] args) {

		String fullName = "apple.jpg";
		String fileName = ""; // apple
		String extName = ""; //jpg
		
		int idxOfDot = fullName.lastIndexOf(".");
		fileName = fullName.substring(0, idxOfDot);
		extName = fullName.substring(idxOfDot + 1);
		System.out.println(fileName);
		System.out.println(extName);
		
		
		
	}


} 