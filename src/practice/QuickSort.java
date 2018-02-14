package practice;

public class QuickSort {
	public static void main(String[] args){
		int[]input={5,15,11,7,2,1,18,9};
		quickSort(input,0,input.length-1);
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
	}

	static void quickSort(int[]input,int start,int end){
		if(start<end){
		int partitionIndex = partition(input,start,end);
		quickSort(input,start,partitionIndex-1);
		quickSort(input,partitionIndex+1,end);
		}
	}
	
	static int partition(int[]input,int start,int end){
		int pivot = input[end];
		int pIndex=start;
		for(int i=start;i<end;i++){
			if(input[i]<=pivot){
				int temp = input[i];
				input[i] = input[pIndex];
				input[pIndex] = temp;
				pIndex++;
			}
		}
		int temp=input[end];
		input[end]=input[pIndex];
		input[pIndex]=temp;
		return pIndex;
	}
}
