package week3.Day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesUsingSetList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Str = "PayPal India";
		char[] CharArray = Str.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
			for(int i = 0; i<=CharArray.length-1;i++) {
				charSet.add(CharArray[i]);		
			}
			System.out.println("The Character set is created as: "+ charSet);
			List<Character> listChar = new ArrayList<Character>(charSet);
			for (int i = 0; i<charSet.size();i++) {
				if(listChar.get(i)!=' '){
					System.out.print(listChar.get(i));
				}
			}
	}
}
