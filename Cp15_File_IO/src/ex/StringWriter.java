package ex;

import java.io.*;

public class StringWriter {
	public static void main(String[] args) throws IOException {
		
		FileWriter writer = new FileWriter("news.txt");
		BufferedWriter bWriter = new BufferedWriter(writer);
		
		bWriter.write("손흥민 해병대 훈련 수료 완료");
		bWriter.newLine();
		bWriter.write("꿀빨았쥬?");
		bWriter.newLine();
		bWriter.write("코로나 ㅗ");
		
		bWriter.close();
		
		System.out.println("기사 작성 완료");
		
	}

}
