package q3;

import java.util.Random;

/*
 * ������ ���� �⸻��� �ǽ� 3�� ����
 * ��Ƽ������� ����/4 ����ϱ�
 * �ۼ��� : �ڼ���(2013. 8. 29)
 */

public class GetPI implements Runnable{

	static final int NUMBER_OF_TOTAL_DOTS = 10000000;
	static final int NUMBER_OF_THREAD = 4;
	static int numberOfDotsInCircle = 0;
	
	@Override
	public void run() {
		Random random = new Random();
		
		// �� �����尡 ������ ���� ���� = �� �� ���� / ������ ��
		int numberOfDots = NUMBER_OF_TOTAL_DOTS / NUMBER_OF_THREAD;
		
		// �� �ȿ� ���� ���� ����
		int dotsInCircle = 0;
		
		// for-loop �� ���鼭 �� ����
		for(int i=0; i<numberOfDots; i++){
			double x = random.nextDouble();
			double y = random.nextDouble();
			
			// ���� ���� �������κ����� �Ÿ��� 1���ϸ� dotsInCircle ���� ��
			if(Math.sqrt(x*x+y*y) <= 1)
				dotsInCircle++;
		}

		// �� �����忡�� ���� �� �ȿ� ���� �� ������ ������ ���Ѵ�.
		synchronized(this){
			numberOfDotsInCircle = numberOfDotsInCircle + dotsInCircle;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		double startTime = System.currentTimeMillis();
		System.out.println("start!\n");

		GetPI getPI = new GetPI();
		Thread[] threads = new Thread[NUMBER_OF_THREAD];
		
		for(int i=0; i<NUMBER_OF_THREAD; i++){
			threads[i] = new Thread(getPI);
			threads[i].start();
		}
		
		for(Thread thread : threads){
			thread.join();
		}
		
		System.out.printf("PI/4�� %f�̴�.\n", (double)numberOfDotsInCircle / NUMBER_OF_TOTAL_DOTS);
		double endTime = System.currentTimeMillis();
		System.out.printf("end!\n �ҿ�ð�: %f ms\n", endTime - startTime);
	}

}
