
public class GCD {
public static void main(String[] args) {
	GCD gcd=new GCD();
	System.out.print(gcd.findGCD(17,19));
}

int findGCD(int a, int b){
	int initialValue=0,answer=1;
	if(a==b){
		answer=a;
		return answer;
	}else if(a<b){
		if(b%a==0){
			answer=a;
			return answer;
		}
		initialValue=a;
	}else if(b>a){
		if(a%b==0){
			answer=b;
			return answer;
		}
		initialValue=b;
	}
	for(int i=initialValue/2;i>1;i--){
		if(a%i==0 && b%i==0){
			answer = i;
			return answer;
		}
	}
	return answer;
}
}
