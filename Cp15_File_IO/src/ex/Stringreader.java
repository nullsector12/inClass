package ex;

import java.io.*;

public class Stringreader {
	public static void main(String[] args) throws IOException {
		
		FileReader reader = new FileReader("news.txt");
		BufferedReader bReader = new BufferedReader(reader);
		
		String str = "";
		
		while(true) {
			
			str = bReader.readLine();
			
			if(str == null) {
				break;
			}
			System.out.println(str);
			
		}
	}

}
