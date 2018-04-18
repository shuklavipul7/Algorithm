package maths;
//This program uses Euclidian algorithm to find GCD
public class GCD2 {

	public static void main(String[] args) {
		System.out.println(findGCD(24, 18));
	}

	
	static int findGCD(int a, int b){
		if(a==0){
			return b;
		}
		return findGCD(b%a, a);
	}
}
