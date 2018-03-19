package string;


public class VowelReverser {

	public static void main(String[] args) {
		String hello = "a.";
		System.out.println(reverseVowels(hello));
	}
	public static String reverseVowels(String s) {
        int start = 0, end = s.length()-1;
        char[]arr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(start<end){
            while(start<end && !vowels.contains(arr[start]+"")){
            	start++;
            }
            while(start<end && !vowels.contains(arr[end]+"")){
            	end--;
            }
            char temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return new String(arr);
    }
}
