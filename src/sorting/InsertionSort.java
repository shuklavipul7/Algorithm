package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[]nums = {55,14,17,5,23,6,11};
		InsertionSort is = new InsertionSort();
		int[] result = is.insertionSort(nums);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
	
	//Insertion sort runs in O(n^2) time
	int[] insertionSort(int[] nums){
		for(int i=1;i<nums.length;i++){
			int value = nums[i];
			int hole = i;
			while(hole>0 && nums[hole-1]>value){
				nums[hole]=nums[hole-1];
				hole--;
			}
			nums[hole]=value;
		}
		return nums;
	}

}
