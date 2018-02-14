package practice;

public class GCD {

	public static void main(String[] args) {
		int[] input = {5,24};
		int ans = input[0];
		for (int i = 1; i < input.length; i++) {
			ans = gcd(ans, input[i]);
		}
		System.out.println(ans);
	}

	public static int gcd(int a, int b) {
		/*if (a == 0 || b == 0) {
			return 0;
		} else if (a == b) {
			return a;
		} else if (a > b) {
			return gcd(a - b, b);
		} else {
			return gcd(a, b - a);
		}*/
		
		while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
	}

}
