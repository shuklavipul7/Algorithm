package string;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

	
	public static void main(String[] args) {
		String string = "This_is_a_string";
		Map<Character,Integer>map = new HashMap<>();
		int max = 0;
		int end = 0;
		int start=0;
		for(;end<string.length();end++){
			if(!map.containsKey(string.charAt(end))){
				map.put(string.charAt(end), end);
			}else{
				int lastPosition = map.get(string.charAt(end));
				start = lastPosition+1;
				max = Math.max(max, map.size());
				map.put(string.charAt(end), end);
			}
			
		}
		
		System.out.println("Max : "+ max);
		System.out.println("start: "+start);
		System.out.println("end: "+end);
	}

}
