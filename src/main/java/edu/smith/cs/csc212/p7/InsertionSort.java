package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;


/**
 * InsertionSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class InsertionSort {

	
	/**
	 * Insertion Sort is done! And it is easy to do in-place.
	 * @param input - the list to be sorted.
	 */
	public static void insertionSort(List<Integer> input) {
		// create empty list
		List <Integer> sortedList= new ArrayList<>();
		
		// if the input list isNotEmpty() add the first element to your sorted list
		//then remove it from your input
		if (input.size()>=1) {
			sortedList.add(input.get(0));
			input.remove(0);
		}
		
	
		
		// while input isNotEmpty 
		while(input.size()>0) {
			int i = input.remove(0);
			
			int j=0;
			boolean x = true;
			
			while (x) {
				//if the element of input list is smaller than element of sortedList
				if (i<sortedList.get(j)) {
					//add it to the index before that element of sortedList
					sortedList.add(j,i);
					x= false;
					}
				else  {
					//else add it after it
					j++;
					if (j==sortedList.size()) {
					sortedList.add(sortedList.size(),i);
					x=false;
					}
				}
			}
			
		
		
		}


//clear the input and add the sorted elements
input.clear();
input.addAll(sortedList);

	}
	
}
	
	
	
	
	


