package practice;
/*Dan is playing a video game in which his character competes in a hurdle race by jumping over  hurdles with heights . He can initially jump a maximum height of  units, but he has an unlimited supply of magic beverages that help him jump higher! Each time Dan drinks a magic beverage, the maximum height he can jump during the race increases by  unit.

Given , , and the heights of all the hurdles, find and print the minimum number of magic beverages Dan must drink to complete the race.

Input Format

The first line contains two space-separated integers describing the respective values of  (the number of hurdles) and  (the maximum height he can jump without consuming any beverages). 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print an integer denoting the minimum number of magic beverages Dan must drink to complete the hurdle race.
 * */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HurdleRace {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        int magicDrinkCount=0;
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            if(height[i]>k){
                int heightDiff = height[i]-k;
                k = k + heightDiff;
                magicDrinkCount = magicDrinkCount + heightDiff;
            }
        }
        System.out.print(magicDrinkCount);
    }
}
