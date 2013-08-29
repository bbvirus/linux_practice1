package q1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * ������ ���� �⸻��� �ǽ� 1�� ����
 * ���� ��θ� �Է¹޾� �������� Ȯ���ؼ� ������ �������ִ� ���α׷�
 * �ۼ��� : �ڼ���(2013. 8. 29)
 */

public class FileCopy {

	public static void main(String[] args) throws IOException {
		
		// ������ �ҽ����� ��θ� �Է¹޴´�.
		// ��) /Users/ParkSeHun/Documents/2ndTerm/linux_practice/test.txt
		System.out.println("input src file path~");
		Scanner scanner1 = new Scanner(System.in);
		String srcFilePath = scanner1.next();

		// �����ؼ� �ٿ����� ��θ� �Է¹޴´�.
		// ��) /Users/ParkSeHun/Documents/linux_final_exam/test.txt
		System.out.println("input dst file path~");
		Scanner scanner2 = new Scanner(System.in);
		String dstFilePath = scanner2.next();

		// �ҽ� ��ο� ������ ���� ������ �´��� Ȯ���Ѵ�.
		File srcFile = new File(srcFilePath);
		if(!srcFile.isFile()){
			System.out.println("is not file.");
			return;
		}
		else {
			// �ҽ������� �о���� inputStream��
			// �ٿ����� outputStream�� �����Ѵ�.
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
			// ��� �۾��� ������ stream�� �ݴ´�.
			bis.close();
			bos.close();
	
		}
	}
}
