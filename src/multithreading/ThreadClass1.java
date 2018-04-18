package multithreading;

public class ThreadClass1{

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		thread1.start();
		for(int i=0;i<10;i++){
			System.out.println("Inside Main Thread");
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException e){}
		}
	}

}

class Thread1 extends Thread{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Inside thread class");
			try{
				sleep(1000);
			}
			catch(InterruptedException e){}
		}
	}
}
