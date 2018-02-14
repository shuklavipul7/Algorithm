package practice;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input={1,2,3,4,6,7,9,14,15,20};
		System.out.println(binarySearch(input,15));
	}
	
	static int binarySearch(int[] input,int num){
		int start=0,end=input.length-1;
		while(start<=end){
			int mid=(start+end)/2;
			if(input[mid]==num){
				return mid;
			}else if(input[mid]>num){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		return -1;
	}

}
