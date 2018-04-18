package matrix;


//This program rotates the matrix by 90 degrees
public class RotateMatrix {

	public static void main(String[] args) {
		int[][]matrix = initializeMatrix(3);
		printMatrix(matrix);
		rotateAntiClockwise(matrix);
		System.out.println("\n\n");
		System.out.println("Rotated Matrix (Anticlock-wise)");
		printMatrix(matrix);
		
		System.out.println("\n\n");
		int[][]matrix2 = initializeMatrix(3);
		printMatrix(matrix2);
		rotateClockwise(matrix2);
		System.out.println("\n\n");
		System.out.println("Rotated Matrix (Clock-wise)");
		printMatrix(matrix2);
	}

	private static void rotateAntiClockwise(int[][] matrix) {
		findTranspose(matrix);
		swapRows(matrix,0,matrix.length-1);
	}
	
	private static void rotateClockwise(int[][]matrix){
		findTranspose(matrix);
		swapColumns(matrix);
	}

	private static void findTranspose(int[][] matrix) {
		for(int row=0;row<matrix.length;row++){
			for(int column=row+1;column<matrix[row].length;column++){
				swap(matrix, row, column);
			}
		}
	}
	
	private static void swapColumns(int[][]matrix){
		//swapping column is basically reversing all the rows internally
		for(int row=0;row<matrix.length;row++){
			reverse(matrix[row]);
		}
	}
	
	private static void reverse(int[]array){
		int start = 0;
		int end = array.length-1;
		while(start<end){
			int temp = array[start];
			array[start]  = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

	private static void swap(int[][] matrix, int row, int column) {
		int temp = matrix[row][column];
		matrix[row][column] = matrix[column][row];
		matrix[column][row] = temp;
	}

	private static void swapRows(int[][] matrix, int start, int end) {
		while(start<end){
			int[]temp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = temp;
			start++;
			end--;
		}
	}

	private static void printMatrix(int[][] matrix) {
		for(int row=0; row<matrix.length; row++){
			System.out.println(" ");
			for(int column=0; column<matrix[row].length; column++){
				if(matrix[row][column]<10){
					System.out.print(matrix[row][column]+"     ");
				}else{
					System.out.print(matrix[row][column]+"    ");
				}
			}
		}
	}

	private static int[][] initializeMatrix(int n) {
		int[][]matrix = new int[n][n];
		int count = 1;
		for(int row = 0; row<n; row++){
			for(int column=0; column<n; column++){
				matrix[row][column]=count;
				count++;
			}
		}
		return matrix;
	}

}
