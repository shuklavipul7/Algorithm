package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates {

	public static void main(String[] args) {
		int[]arr = {3,3};
		ContainsDuplicates c = new ContainsDuplicates();
		System.out.println(c.containsDuplicate2(arr));

	}
	
	public boolean containsDuplicate(int[] nums) {
		Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = map.getOrDefault(nums[i],0);
            map.put(nums[i],++val);
        }
        for(Integer key:map.keySet()){
            if(map.get(key)>1){
                return true;
            }
        }
        return false;
    } 
	
	public boolean containsDuplicate2(int[] nums) {
		int[]clone = nums.clone();
		Arrays.sort(clone);
		int len = clone.length;
		for(int i=0;i<len-1;i++){
			if(clone[i]==clone[i+1]){
				return true;
			}
		}
        return false;
    } 

}
