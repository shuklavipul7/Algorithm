package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle. In a new kind of PDF viewer, the selection of each word is independent of the other words; this means that each rectangular selection area forms independently around each highlighted word. For example:

PDF-highighting.png

In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters in the word times the width of a letter, and the height is the maximum height of any letter in the word.

Consider a word consisting of lowercase English alphabetic letters, where each letter is  wide. Given the height of each letter in millimeters (), find the total area that will be highlighted by blue rectangle in  when the given word is selected in our new PDF viewer.

Input Format

The first line contains  space-separated integers describing the respective heights of each consecutive lowercase English letter (i.e., ). 
The second line contains a single word, consisting of lowercase English alphabetic letters.

Constraints

, where  is an English lowercase letter.
Word contains no more than  letters.
Output Format

Print a single integer denoting the area of highlighted rectangle when the given word is selected. The unit of measurement for this is square millimeters (), but you must only print the integer.

*Sample Input

1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
abc

Sample Output
9
*/
public class DesignerPDFViewer {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i=0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        
        Map<Character, Integer> hMap = new HashMap<Character, Integer>();
        hMap.put('a',h[0]);
        hMap.put('b',h[1]);
        hMap.put('c',h[2]);
        hMap.put('d',h[3]);
        hMap.put('e',h[4]);
        hMap.put('f',h[5]);
        hMap.put('g',h[6]);
        hMap.put('h',h[7]);
        hMap.put('i',h[8]);
        hMap.put('j',h[9]);
        hMap.put('k',h[10]);
        hMap.put('l',h[11]);
        hMap.put('m',h[12]);
        hMap.put('n',h[13]);
        hMap.put('o',h[14]);
        hMap.put('p',h[15]);
        hMap.put('q',h[16]);
        hMap.put('r',h[17]);
        hMap.put('s',h[18]);
        hMap.put('t',h[19]);
        hMap.put('u',h[20]);
        hMap.put('v',h[21]);
        hMap.put('w',h[22]);
        hMap.put('x',h[23]);
        hMap.put('y',h[24]);
        hMap.put('z',h[25]);
        
        int area = 0;
        int maxHeight=0;
        
        for(int i=0; i<word.length();i++){
            int height = hMap.get(word.charAt(i));
            if(height > maxHeight){
                maxHeight = height;
            }
        }
        area = maxHeight * word.length();
        System.out.print(area);
    }
}
