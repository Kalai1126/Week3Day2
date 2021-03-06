package week3.Day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		List<String> inputList = new ArrayList<String>();
		List<String> reverseList = new ArrayList<String>();

			for(int i=0; i<input.length; i++) {
				inputList.add(input[i]);
		}
		System.out.println("The List before sorting: "+ inputList);
		Collections.sort(inputList);
		System.out.println("The List after sorting: "+ inputList);
			for (int i=(inputList.size()-1); i>=0; i--) {
				reverseList.add(inputList.get(i));
		}
		System.out.println("The List after reversing using for loop and getting in another arraylist: "+ reverseList);
}
}
