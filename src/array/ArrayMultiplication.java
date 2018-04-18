package array;
//In this problem we find out the multiplication of whole array except the position we are currently at
public class ArrayMultiplication {

	public static void main(String[] args) {
		int[]arr = {2,3,4,5,6,7,8,9};
		int[] sol=new int[arr.length];
		int product=1;
		for(int i=0;i<arr.length;i++){
			product = product*arr[i];
			System.out.print(arr[i]+" ");
		}
		
		for(int i=0;i<arr.length;i++){
			sol[i] = product/arr[i];
		}
		System.out.println("");
		System.out.println("product "+product);
		System.out.println("");
		
		for(int i=0;i<sol.length;i++){
			System.out.print(sol[i]+" ");
		}
	}

}
