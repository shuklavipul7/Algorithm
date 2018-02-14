package stringrelated;

import java.util.ArrayList;
import java.util.List;

public class AnagramIndexRetriver2 {

	public static void main(String[] args) {
		String s= "cbaebabacd";
		String p= "abc";
		int[] intArrayForPattern = generateIntegerArray(p);
		List<Integer>result = new ArrayList<>();
		int lenOfPattern = p.length();
		for(int startingIndex=0;;startingIndex++){
			int endIndex = startingIndex+lenOfPattern;
			if(endIndex>s.length()){
				break;
			}
			String subString = s.substring(startingIndex,endIndex);
			int[]intArrayForSubString = generateIntegerArray(subString);
			if(stringsAreAnagrams(intArrayForSubString, intArrayForPattern)){
				result.add(startingIndex);
			}
		}
		System.out.println(result);
	}

	
	private static boolean stringsAreAnagrams(int[] intArrayForSubString, int[] intArrayForPattern) {
		for(int i=0;i<intArrayForSubString.length;i++){
			if(intArrayForSubString[i]!=intArrayForPattern[i]){
				return false;
			}
		}
		return true;
	}


	private static int[] generateIntegerArray(String p) {
		int[]arr = new int[26];
		for(int i=0;i<p.length();i++){
			char c = p.charAt(i);
			arr[c-'a']++;
		}
		return arr;
	}

}
