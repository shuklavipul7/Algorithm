
public class OverLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Superclass1 s1 = new Superclass1();
		s1.method(1, 2.0f);
	}

}


class Superclass1{
	private static void method(){
		System.out.println("Super class method");
	}
	public void method(float int1, float f1){
		System.out.println("Super class overloaded method");
	}
}


class subclass1 extends Superclass1{
	public void method(){
		System.out.println("Super class method");
	}
}
