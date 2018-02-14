package practice;

public class BinarySearchFirstOccurance {

	public static void main(String[] args) {
		int[]input={1,2,3,4,4,4,5,6,7,8,9,10};
		System.out.print(binarySearchFirstOccurance(input, 4));
	}
	
	static int binarySearchFirstOccurance(int[]nums,int num){
		int start=0, end=nums.length-1, answer=-1;
		while(start<=end){
			int mid=start+(end-start)/2;
			if(nums[mid]==num){
				answer= mid;
				end=mid-1;
			}else if(nums[mid]>num){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		return answer;
	}

}
