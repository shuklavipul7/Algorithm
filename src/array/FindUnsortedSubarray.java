package array;

public class FindUnsortedSubarray {

	public static void main(String[] args) {
		int[]nums = {1,3,4,5,2};
		FindUnsortedSubarray f = new FindUnsortedSubarray();
		int len = f.findUnsortedSubarray(nums);
		System.out.println(len);
	}
	
	int findUnsortedSubarray(int[]nums){
		int begin=nums.length-1;
		int end=0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]>nums[i+1]){
				begin = i;
				break;
			}
		}
		
		for(int i=nums.length-1;i>1;i--){
			if(nums[i]<nums[i-1]){
				end = i;
				break;
			}
		}
		
		int minOfSubArray = Integer.MAX_VALUE;
		int maxOfSubArray = Integer.MIN_VALUE;
		
		for(int i=begin;i<=end;i++){
			minOfSubArray = Math.min(minOfSubArray, nums[i]);
			maxOfSubArray = Math.max(maxOfSubArray, nums[i]);
		}
		
		int startIndex=begin;
		for(int i = begin-1;i>=0; i--){
			if(minOfSubArray<nums[i]){
				startIndex = i;
			}
		}
		
		int endIndex = end;
		for(int i=end+1;i<nums.length;i++){
			if(maxOfSubArray>nums[i]){
				endIndex = i;
			}
		}
		
		if(startIndex == nums.length-1 && endIndex==0){
			return 0;
		}else{
			return endIndex-startIndex+1;
		}
	}
	
	
}
