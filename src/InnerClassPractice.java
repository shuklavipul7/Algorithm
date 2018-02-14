
public class InnerClassPractice {
	private int variable;
	
	class InnerClass{
		int innerVariable;
		
		public void innerMethod(){
			variable = 10;
			innerVariable = 20;
		}
	}
	
	public void outerMethod(){
		variable = 100;
		//innerVariable = 200;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
