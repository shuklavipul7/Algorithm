package maths;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 1, y = 4;
		int xor = x ^ y;
		int count = 0;
		
		while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        
		System.out.println(count);

	}

}
