package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given a substring find longest substring w/o repeating characters
 * Brute force approach. Running time: O(n^2)
 * eg:- 
 * input:  abcdeasd
 * output:  bcdeas   
 * 
 * */
public class LongestSubstringWoRepeatingCharacters {

	public static void main(String[] args) {
		String input = "bbbbbb";
		LongestSubstringWoRepeatingCharacters l = new LongestSubstringWoRepeatingCharacters();
		String result = l.findLongestSubstringWORepeatingCharacters(input);
		System.out.println(result);
	}

	private String findLongestSubstringWORepeatingCharacters(String input) {
		String result = "";
		for(int i=0;i<input.length();i++){
			for(int j=i+1;j<input.length();j++){
				if(isUnique(input,i,j)){
					if(input.substring(i, j+1).length()>result.length()){
						result = input.substring(i, j+1);
					}
				}
			}
		}
		if(result.length()==0){
			result = input.charAt(0)+"";
		}
		return result;
	}

	private boolean isUnique(String input, int i, int j) {
		Set<Character>set = new HashSet<>();
		for(int k=i; k<=j; k++){
			if(!set.contains(input.charAt(k))){
				set.add(input.charAt(k));
			}else{
				return false;
			}
		}
		return true;
	}

	
}
