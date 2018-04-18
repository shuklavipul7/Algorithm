package designpatterns;

public class SingletonExample {

	public static void main(String[] args) {
	}
}

class Singleton {
	private static Singleton singleInstance;
	
	private Singleton(){}
	
	static Singleton getInstance(){
		if(singleInstance==null){
			singleInstance = new Singleton();
		}
		return singleInstance;
	}
}
