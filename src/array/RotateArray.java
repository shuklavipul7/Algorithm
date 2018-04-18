package array;

public class RotateArray {

	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int[]nums = {1,2};
		rotateArray.rotate(nums, 3);
	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
        k = k % len;
        int[]toReturn = new int[len];
        
        for(int i=len-k; i<len; i++){
            toReturn[i-len+k]=nums[i];
        }
        for(int i=0; i<len-k; i++){
            toReturn[i+k] = nums[i];
        }
      
        nums = toReturn;
        System.out.println(" ");
        for(int i=0;i<len;i++){
        	System.out.print(nums[i]+" ");
        }
	}

	/*public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[]toReturn = new int[len];
        for(int i=k; i<len; i++){
            toReturn[i-k]=nums[i];
        }
        for(int i=0; i<k; i++){
            toReturn[len-k+i] = nums[i];
        }
        for(int i=0;i<len;i++){
        	System.out.print(toReturn[i]+" ");
        }
        
        nums = toReturn;
        System.out.println(" ");
        for(int i=0;i<len;i++){
        	System.out.print(nums[i]+" ");
        }
    }*/
}
