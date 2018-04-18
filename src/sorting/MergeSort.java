package sorting;

import java.awt.RenderingHints;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mSort = new MergeSort();
		int[]arr = {17,4,8,1,2,3};
		mSort.mergeSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int mid = arr.length / 2;
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for (int i = 0; i < mid; i++) {
				left[i] = arr[i];
			}
			for (int i = mid; i < arr.length; i++) {
				right[i - mid] = arr[i];
			}
			mergeSort(left);
			mergeSort(right);
			merge(left, right, arr);
		}
	}

	private void merge(int[] left, int[] right, int[] arr) {
		int lIndex = 0, rIndex = 0, arrIndex = 0;
		int leftLength = left.length, rightLength = right.length;
		while (lIndex < leftLength && rIndex < rightLength) {
			if (left[lIndex] <= right[rIndex]) {
				arr[arrIndex] = left[lIndex];
				lIndex++;
				arrIndex++;
			} else {
				arr[arrIndex] = right[rIndex];
				rIndex++;
				arrIndex++;
			}
		}

		while (lIndex < leftLength) {
			arr[arrIndex] = left[lIndex];
			lIndex++;
			arrIndex++;
		}

		while (rIndex < rightLength) {
			arr[arrIndex] = right[rIndex];
			rIndex++;
			arrIndex++;
		}
	}

}
