package matrix;
//Given a matrix print it in zig-zag order
public class ZigZagMatrix {

	public static void main(String[] args) {
		int[][]matrix = {
							{1,    2,    3,    4},
							{5,    6,    7,    8},
							{9,   10,    11,  12},
							{13,  14,    15,  16}
						};
		/*Expected Output
		 * 1 2 3 4     8 7 6 5     9 10 11 12     16 15 14 13
		 * */
		
		int totalNumberOfRows = matrix.length;
		int totalNumberOfColumns = matrix[0].length;
		int dir = 1; //dir=1 for moving forward and dir=-1 for moving backward
		
		for(int currentRow=0; currentRow<totalNumberOfRows; currentRow++){
			if(dir==1){
				int currentColumn=0;
				while(currentColumn<totalNumberOfColumns){
					System.out.print(matrix[currentRow][currentColumn]+" ");
					currentColumn++;
				}
				dir=-1;
			}else if(dir==-1){
				int currentColumn=totalNumberOfColumns-1;
				while(currentColumn>=0){
					System.out.print(matrix[currentRow][currentColumn]+" ");
					currentColumn--;
				}
				dir=1;
			}
		}
	}

}
