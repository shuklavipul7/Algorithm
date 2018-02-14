package practice;

public class BinarySearchRecusive {
public static void main(String[] args){
	int[]nums={1,2,3,4,5,6,7,8,9};
	System.out.print(binarySearchRecursive(nums, 0, nums.length-1, 13));
}

static int binarySearchRecursive(int[]nums,int start, int end,int num){
	int mid=(start+end)/2;
	if(start>end){
		return -1;
	}
	if(nums[mid]==num){
		return mid;
	}else if(nums[mid]>num){
		return binarySearchRecursive(nums, start, mid-1, num);
	}else{
		return binarySearchRecursive(nums, mid+1, end, num);
	}
	}
}
