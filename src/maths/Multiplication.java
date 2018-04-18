package maths;
//In this problem we are multiplying two numbers without using multiplication operator
public class Multiplication {

	public static void main(String[] args) {
		int result = multiply(9,4);
		System.out.println(result);
	}

	private static int multiply(int first, int second) {
		int count=0;
		for(int i=0;i<second;i++){
			count=count+first;
		}
		return count;
	}
}
                                                                      