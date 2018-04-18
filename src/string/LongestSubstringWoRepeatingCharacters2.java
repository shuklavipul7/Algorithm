package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a substring find longest substring w/o repeating characters
 * Sliding Window approach. Running time: O(n)
 * eg:- 
 * input:  abcdeasd
 * output:  bcdeasd   
 * 
 * */
public class LongestSubstringWoRepeatingCharacters2 {

	public static void main(String[] args) {
		String input = "geeksforgeeks";
		LongestSubstringWoRepeatingCharacters2 l = new LongestSubstringWoRepeatingCharacters2();
		String result = l.findLongestSubstringWORepeatingCharacters(input);
		System.out.println("===============");
		System.out.println(result);

	}

	private String findLongestSubstringWORepeatingCharacters(String input) {
		int result = 0;
		String subStringToReturn = "";
		if(input==null){
			return subStringToReturn;
		}
		Map<Character, Integer>pos = new HashMap<>();
		int begin = 0, end = 0;
		
		for(;end<input.length();end++){
			char c = input.charAt(end);
			if(!pos.containsKey(c)){
				pos.put(c, end);
				//result = Integer.max(result, (end-begin+1));
				if( (end-begin+1) > result){
					result = (end-begin+1);
					subStringToReturn = input.substring(begin, end+1);
				}
			}else{
				if(begin<=pos.get(c)){
					begin = pos.get(c)+1;
				}
				//result = Integer.max(result, (end-begin+1));
				if( (end-begin+1) > result){
					result = (end-begin+1);
					subStringToReturn = input.substring(begin, end+1);
				}
				pos.put(c, end);
			}
		}
		return subStringToReturn;
	}

	/*private String findLongestSubstringWORepeatingCharacters(String input) {
		Map<Character, Integer>positions = new HashMap<>();
		List<StringBuilder>list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<input.length();i++){
			if(!positions.containsKey(input.charAt(i))){
				positions.put(input.charAt(i),i);
				sb.append(input.charAt(i));
			}else{
				i = positions.get(input.charAt(i))+1;
				positions.put(input.charAt(i),i);
				list.add(sb);
				sb = new StringBuilder();
			}
		}
		for(StringBuilder s : list){
			System.out.println(s);
		}
		return null;
	}*/

}
