package array;

public class MatrixTranspose {

	public static void main(String[] args) {
		int[][]matrix = initialiseMatrix(4);
		System.out.println("Original Matrix");
		print(matrix);
		findTranspose(matrix);
		System.out.println("\n\n");
		System.out.println("After Transpose");
		print(matrix);
	}
	
	static void findTranspose(int[][]matrix){
		for(int row=0;row<matrix.length;row++){
			for(int column=row;column<matrix[row].length;column++){
				swap(matrix,row,column);
			}
		}
	}
	
	static void swap(int[][]matrix,int row, int column){
		int temp = matrix[row][column];
		matrix[row][column] = matrix[column][row];
		matrix[column][row] = temp;
	}
	
	static void print(int[][]matrix){
		for(int row=0;row<matrix.length;row++){
			System.out.println(" ");
			for(int column=0;column<matrix[row].length;column++){
				if(matrix[row][column]<10){
					System.out.print(matrix[row][column]+"    ");
				}else{
					System.out.print(matrix[row][column]+"   ");
				}
			}
		}
	}
	
	static int[][] initialiseMatrix(int n){
		int[][]matrix = new int[n][n];
		int counter = 1;
		for(int row=0;row<n;row++){
			for(int column=0;column<n;column++){
				matrix[row][column] = counter;
				counter++;
			}
		}
		return matrix;
	}

}
