class SuperClass {
	SuperClass() {
		System.out.println("Super Constructor");
	}
	
	{
		System.out.println("Instance block of Super class");
	}
	
	static{
		System.out.println("Static Initialization block of Super class");
	}
}

public class Final extends SuperClass{
	Final() {
		System.out.println("Subclass constructor");
	}
	
	static{
		System.out.println("Static Initialization block of Sub class");
	}

	{
		System.out.println("Instance block 1 of Sub Class");
	}
	
	{
		System.out.println("Instance Block 2 of Sub Class");
	}
	
	public static void main(String[] args) {
		Final final1 = new Final();
	}

}
