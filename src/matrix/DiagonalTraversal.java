package matrix;
//Print all the diagonals of this matrix
public class DiagonalTraversal {

	public static void main(String[] args) {
		int[][]matrix = {
							{1,   2,   3,   4},
							{5,   6,   7,   8},
							{9,  10,  11,  12},
							{13, 14,  15,  16}
						};
		/*The above matrix if printed diagonally will be:-
		 * 1
		 * 5 2
		 * 9 6 3
		 * 13 10 7 4
		 * 14 11 8
		 * 15 12
		 * 16
		*/
		
		/*
		 * First we will traverse the first column
		 * Then we will traverse the last row
		 * Make sure not to traverse the common diagonal twice
		 * In order to print the diagonal we travel (current row number - 1) (current column number + 1)*/
		
		int totalNumberOfRows = matrix.length, totalNumberOfColumns = matrix[0].length;
		
		for(int rowNum=0; rowNum<totalNumberOfRows; rowNum++){
			int currentRow = rowNum;
			int currentCol = 0;
			while(currentRow>=0){
				System.out.print(matrix[currentRow][currentCol]+" ");
				currentRow--;
				currentCol++;
			}
		}
		
		for(int colNum = 1; colNum<totalNumberOfColumns; colNum++){
			int currentRow = totalNumberOfRows-1;
			int currentColumn = colNum;
			while(currentColumn<=totalNumberOfColumns-1){
				System.out.print(matrix[currentRow][currentColumn]+" ");
				currentRow--;
				currentColumn++;
			}
		}
	}

}
