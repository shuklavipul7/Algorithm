package string;

public class AnagramUsingArray {

	public static void main(String[] args) {
		AnagramUsingArray a = new AnagramUsingArray();
		String s = "anagram";
		String t = "aaagrnm";
		System.out.print(a.isAnagram(s, t));
	}
	
	public boolean isAnagram(String s, String t) {
        int[]array=new int[26];
        if(s.length()!=t.length()){
            return false;
        }else{
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                array[c-'a']++;
            }
            
            for(int j=0;j<t.length();j++){
                char c = t.charAt(j);
                array[c-'a']--;
            }
            
            for(int i=0;i<26;i++){
                if(array[i]!=0){
                    return false;
                }
            }
            return true;
        }
    }

}
