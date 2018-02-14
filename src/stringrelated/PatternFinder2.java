package stringrelated;
//This also uses the brute force approach
//However here we are using some built-in methods of String class
public class PatternFinder2 {

	public static void main(String[] args) {
		String text = "vipulshukla";
		String pattern = "kla";
		int index = findPatternInText(text, pattern);
		System.out.println(index);
	}

	private static int findPatternInText(String text, String pattern) {
		int lenOfPattern = pattern.length();
		for(int startIndex=0;;startIndex++){
			int endIndex = startIndex + lenOfPattern;
			if(endIndex>text.length()){
				break;
			}
			String subString = text.substring(startIndex,endIndex);
			if(subString.equals(pattern)){
				return startIndex;
			}
		}
		return -1;
		
	}

}
