package string;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisits {

	public static void main(String[] args) {
		SubDomainVisits subDomainVisits = new SubDomainVisits();
		String[]input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		System.out.println(subDomainVisits.subdomainVisits(input));
	}
	
	public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<cpdomains.length; i++){
            String input = cpdomains[i];
            String[]inputArray = input.split(" ");
            
            Integer domainCount = Integer.parseInt(inputArray[0]);
            String[] domainNamesArray = inputArray[1].split("\\.");
            String subDomain = new String();
            
            for(int j=domainNamesArray.length-1; j>=0; j--){
                if(subDomain.length()==0){
                    subDomain = (domainNamesArray[j]);
                }else{
                    subDomain = domainNamesArray[j]+(".")+(subDomain);
                }
                map.put(subDomain, map.getOrDefault(subDomain, 0)+domainCount);
            }
        }
        
        List<String>result = new ArrayList<>();
        for(String subDomain : map.keySet()){
            result.add(map.get(subDomain) + " " + subDomain);
        }
        return result;
    }

}
