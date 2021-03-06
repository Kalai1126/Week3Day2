package week3.Day2;

import java.util.LinkedHashSet;
import java.util.Set;


public class RemoveDuplicatesusing2Sets {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String Str = "PayPal India";
			char[] charArray = Str.toCharArray();
			Set<Character> charSet = new LinkedHashSet<Character>();
			Set<Character> dupCharSet = new LinkedHashSet<Character>();
			
				for(int i = 0; i<=charArray.length-1;i++) {
					if(charSet.contains(charArray[i])) dupCharSet.add(charArray[i]);
					else charSet.add(charArray[i]);
				}
					System.out.println(charSet);
					System.out.println(dupCharSet);
				
				
			
				for(int i = 0; i<dupCharSet.size();i++) {
					charSet.remove(charArray[i]);
				}
			
			

				for(char character:charSet) {
					if(character!=' ') System.out.print(character);
				}
				
		}	

}
		
	


