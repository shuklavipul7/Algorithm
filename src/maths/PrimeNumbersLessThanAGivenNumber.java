package maths;

import org.omg.CosNaming.IstringHelper;

public class PrimeNumbersLessThanAGivenNumber {

	public static void main(String[] args) {
		System.out.println(primeNumbersLessThanAGivenNumber(8));
	}

	private static int primeNumbersLessThanAGivenNumber(int number) {
		if(number<3){
			return 0;
		}
		if(number==3){
			return 1;
		}
		int count = 1;
		for(int i=3;i<number;i++){
			if(isPrime(i)){
				count++;
			}
		}
		return count;
	}
	
	private static boolean isPrime(int n){
		if(n==1){
			return false;
		}
		if(n==2){
			return true;
		}
		int temp = 0;
		for(int i=2;i<n;i++){
			if(n%i==0){
				temp++;
				break;
			}
		}
		if(temp>0){
			return false;
		}else{
			return true;
		}
	}

}
