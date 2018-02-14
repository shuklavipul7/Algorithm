package practice;

public class MergeSort {
	
	public static void main(String[] args){
		int[] input = {15,5,6,7,1,19,12,4};
		mergeSort(input);
		
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
	}

	
	public static void mergeSort(int[]input){
		int n = input.length;
		if(n<2){
			return;
		}
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		for(int i=0;i<mid;i++){
			left[i]=input[i];
		}
		
		for(int j=mid;j<n;j++){
			right[j-mid]=input[j];
		}
		
		mergeSort(left);
		mergeSort(right);
		merge(left,right,input);
	}
	
	public static void merge(int[] left, int[]right,int[]input){
		int leftSize=left.length, rightSize=right.length;
		int leftIndex=0, rightIndex=0, inputIndex=0;
		
		while(leftIndex<leftSize && rightIndex<rightSize){
			if(left[leftIndex]<right[rightIndex]){
				input[inputIndex]=left[leftIndex];
				leftIndex++;
			}else{
				input[inputIndex]=right[rightIndex];
				rightIndex++;
			}
			inputIndex++;
		}
		
		while(leftIndex<leftSize){
			input[inputIndex]=left[leftIndex];
			inputIndex++;
			leftIndex++;
		}
		
		while(rightIndex<rightSize){
			input[inputIndex]=right[rightIndex];
			rightIndex++;
			inputIndex++;
		}
	}
}
