package practice;

public class LCM {

	public static void main(String[] args) {
		int[] input = {2, 3};
		int ans = input[0];
		for(int i=1; i<input.length; i++){
			ans = lcm(ans, input[i]);
		}
		System.out.println(ans);
	}
	
	public static int lcm(int a, int b){
		return (a*b)/(gcd(a,b));
	}
	
	public static int gcd(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		} else if (a == b) {
			return a;
		} else if (a > b) {
			return gcd(a - b, b);
		} else {
			return gcd(a, b - a);
		}
	}

}
