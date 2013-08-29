package q3;

import java.util.Random;

/*
 * 리눅스 연습 기말고사 실습 3번 문제
 * 멀티스레드로 파이/4 계산하기
 * 작성자 : 박세훈(2013. 8. 29)
 */

public class GetPI implements Runnable{

	static final int NUMBER_OF_TOTAL_DOTS = 10000000;
	static final int NUMBER_OF_THREAD = 4;
	static int numberOfDotsInCircle = 0;
	
	@Override
	public void run() {
		Random random = new Random();
		
		// 각 스레드가 생성할 점의 개수 = 총 점 개수 / 스레드 수
		int numberOfDots = NUMBER_OF_TOTAL_DOTS / NUMBER_OF_THREAD;
		
		// 원 안에 들어가는 점의 개수
		int dotsInCircle = 0;
		
		// for-loop 를 돌면서 점 생성
		for(int i=0; i<numberOfDots; i++){
			double x = random.nextDouble();
			double y = random.nextDouble();
			
			// 만든 점의 원점으로부터의 거리가 1이하면 dotsInCircle 개수 증
			if(Math.sqrt(x*x+y*y) <= 1)
				dotsInCircle++;
		}

		// 각 스레드에서 구한 원 안에 들어가는 점 개수의 총합을 구한다.
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
		
		System.out.printf("PI/4는 %f이다.\n", (double)numberOfDotsInCircle / NUMBER_OF_TOTAL_DOTS);
		double endTime = System.currentTimeMillis();
		System.out.printf("end!\n 소요시간: %f ms\n", endTime - startTime);
	}

}
