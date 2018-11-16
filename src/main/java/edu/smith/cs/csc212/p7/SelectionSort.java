package edu.smith.cs.csc212.p7;

import java.util.ArrayList;

import java.util.List;


/**
 * SelectionSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class SelectionSort {
	
		/**
		 * Selection Sort is done! And it is easy to do in-place.
		 * @param input - the list to be sorted.
		 */
		public static void selectionSort(List<Integer> input) {
			//create new list
			List <Integer> sortedList= new ArrayList<>();
			
			while(input.size()> 0) {
				//assign currentSmallestIndex variable 0 for now
				int currentSmallestIndex=0;
				
				// while the input list is not empty loop through the list
				for (int i=0; i<=input.size()-1; i++) {
					//if value at one index is smaller than value for our currentSmallestIndex
					//update urrentSmallestIndex
					if (input.get(i) < input.get(currentSmallestIndex)) {
						currentSmallestIndex=i;
						}
					
				}
				
				//add the the smallest value to the sorted list and remove it from the input
				sortedList.add(input.get(currentSmallestIndex));
				input.remove(currentSmallestIndex);
				
				
				
				}

			// add all the elements of sorted list to the input so that the input is now sorted
			input.addAll(sortedList);
		}
	}
	
