package stringrelated;

//This class returns the first match of pattern p in Text t
//This algorithm uses the brute force method
public class PatternFinder {

	public static void main(String[] args) {
		String t = "vipulshukla";
		String p = "ukl";
		//should return 3
		int indexOfFirstMatch = findIndexOfFirstMatch(t, p);
		System.out.println(indexOfFirstMatch);
	}

	//Running Time = O(n^2)
	private static int findIndexOfFirstMatch(String t, String p) {
		int lenOfT = t.length();
		int lenOfP = p.length();
		
		for (int i = 0; i < lenOfT - lenOfP; i++) {
			int j = 0;
			while (j < lenOfP && t.charAt(i + j) == p.charAt(j)) {
				j++;
			}
			if (j == lenOfP) {
				return i;
			}
		}
		return -1;
	}

}
