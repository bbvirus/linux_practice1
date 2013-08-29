package q1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 리눅스 연습 기말고사 실습 1번 문제
 * 파일 경로를 입력받아 파일인지 확인해서 파일을 복사해주는 프로그램
 * 작성자 : 박세훈(2013. 8. 29)
 */

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		// 복사할 소스파일 경로를 입력받는다.
		// 예) /Users/ParkSeHun/Documents/2ndTerm/linux_practice/test.txt
		System.out.println("input src file path~");
		Scanner scanner1 = new Scanner(System.in);
		String srcFilePath = scanner1.next();

		// 복사해서 붙여넣을 경로를 입력받는다.
		// 예) /Users/ParkSeHun/Documents/linux_final_exam/test.txt
		System.out.println("input dst file path~");
		Scanner scanner2 = new Scanner(System.in);
		String dstFilePath = scanner2.next();

		// 소스 경로에 지정된 것이 파일이 맞는지 확인한다.
		File srcFile = new File(srcFilePath);
		if(!srcFile.isFile()){
			System.out.println("is not file.");
			return;
		}
		else {
			// 소스파일을 읽어오는 inputStream과
			// 붙여넣을 outputStream을 생성한다.
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFilePath));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstFilePath));
			
			System.out.println("file copy start~!");

			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while((bytesRead = bis.read(buffer))!=-1){
				bos.write(buffer, 0, bytesRead);
				bos.flush();
			}
			
			System.out.println("file copy finish~");
			// 모든 작업이 끝나면 stream을 닫는다.
			bis.close();
			bos.close();
	
		}
	}
}
