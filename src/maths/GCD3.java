package maths;

public class GCD3 {

	public static void main(String[] args) {
		System.out.println(findGCD(6, 20));
	}

	static int findGCD(int a, int b){
        if (a == 0)
           return b;
        
        if(b==0)
        	return a;
      
        // base case
        if (a == b)
            return a;
      
        // a is greater
        if (a > b)
            return findGCD(a-b, b);
        return findGCD(a, b-a);
	}
}
