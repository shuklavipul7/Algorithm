package array;

public class RotateArray2 {

	public static void main(String[] args) {
		RotateArray2 r = new RotateArray2();
		int[] nums = {1,2,3,4,5,6,7};
		System.out.println("Original array");
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		
		int rotateBy = 3;
		r.rotateArray(nums, rotateBy);
		System.out.println(" ");
		System.out.println("Rotated Array By "+rotateBy);
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
		
	}
	
	void rotateArray(int[]nums, int k){
		int len = nums.length;
		k=k%len;
		reverse(nums,0,len-1);
		reverse(nums,0,k-1 );
		reverse(nums,k,len-1);
	}

	void reverse(int[] nums, int start, int end) {
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		
	}

}
