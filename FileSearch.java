package q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * 리눅스 연습 기말고사 실습 2번 문제
 * 파일을 찾아서 경로를 출력해주는 프로그램
 * 작성자 : 박세훈(2013. 8. 29)
 */

public class FileSearch {
	
	public static void main(String[] args) throws IOException {
		
		// 탐색을 시작할 디렉토리 이름을 입력받는다.
		System.out.println("input directory name :");
		Scanner scanner1 = new Scanner(System.in);
		String directoryName = scanner1.next();
		
		// 찾을 파일의 이름을 입력받는다.
		System.out.println("input file name you want to search :");
		Scanner scanner2 = new Scanner(System.in);
		String searchingFileName = scanner2.next();

		// 디렉토리를 순회하면서 파일 이름이 일치하는 파일을 찾고 경로를 리턴받는다.
		String filePath = searchFile(new File(searchingFileName), new File(directoryName));
		
		// 파일 경로가 있으면 출력한다.
		if(!(filePath==null)) System.out.println(filePath);
		else System.out.println("파일이 없습니다.");
	}
	
	public static String searchFile(File searchingFile, File directory){
		// 검색중인 곳이 디렉토리인 경
		if(directory.isDirectory()){
			// 디렉토리 안의 파일 리스트를 생성한다.
			File[] fileList = directory.listFiles();
			
			// 파일 리스트를 순회하면서 이름이 같은지 확인한다.
			for(File file : fileList){
				if(searchingFile.getName().equals(file.getName()))
					return file.getAbsolutePath();
			}

			// 파일 리스트가 비어있지 않으면 다음번 파일을 계속 순회한다.
			if(fileList!=null){
				for(File nextFile : fileList)
					searchFile(searchingFile, nextFile);
			}
		}
		return null;
	}
	
}
