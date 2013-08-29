package q2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * ������ ���� �⸻��� �ǽ� 2�� ����
 * ������ ã�Ƽ� ��θ� ������ִ� ���α׷�
 * �ۼ��� : �ڼ���(2013. 8. 29)
 */

public class FileSearch {
	
	public static void main(String[] args) throws IOException {
		
		// Ž���� ������ ���丮 �̸��� �Է¹޴´�.
		System.out.println("input directory name :");
		Scanner scanner1 = new Scanner(System.in);
		String directoryName = scanner1.next();
		
		// ã�� ������ �̸��� �Է¹޴´�.
		System.out.println("input file name you want to search :");
		Scanner scanner2 = new Scanner(System.in);
		String searchingFileName = scanner2.next();

		// ���丮�� ��ȸ�ϸ鼭 ���� �̸��� ��ġ�ϴ� ������ ã�� ��θ� ���Ϲ޴´�.
		String filePath = searchFile(new File(searchingFileName), new File(directoryName));
		
		// ���� ��ΰ� ������ ����Ѵ�.
		if(!(filePath==null)) System.out.println(filePath);
		else System.out.println("������ �����ϴ�.");
	}
	
	public static String searchFile(File searchingFile, File directory){
		// �˻����� ���� ���丮�� ��
		if(directory.isDirectory()){
			// ���丮 ���� ���� ����Ʈ�� �����Ѵ�.
			File[] fileList = directory.listFiles();
			
			// ���� ����Ʈ�� ��ȸ�ϸ鼭 �̸��� ������ Ȯ���Ѵ�.
			for(File file : fileList){
				if(searchingFile.getName().equals(file.getName()))
					return file.getAbsolutePath();
			}

			// ���� ����Ʈ�� ������� ������ ������ ������ ��� ��ȸ�Ѵ�.
			if(fileList!=null){
				for(File nextFile : fileList)
					searchFile(searchingFile, nextFile);
			}
		}
		return null;
	}
	
}
