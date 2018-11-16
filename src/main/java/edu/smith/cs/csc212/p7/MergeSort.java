package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;




/**
 * MergeSort is a simple sort.
 * @author jfoley
 *
 */
public class MergeSort {
	/**
	 * join() combines two sorted list into one sorted list.
	 * @param input1 - the first sorted list to be combined.
	 * @param input2 - the second sorted list to be combined.
	 */
	public static List<Integer> join(List<Integer> input1, List<Integer> input2) {
		
		//create a new list
		List<Integer> mergedList = new ArrayList<Integer>();
	
		boolean x= true; 
		
		while(x) {
			//if first element of input1 is smaller the first element of input2 add that
			//element from input1 to mergedList
			if (input1.get(0) < input2.get(0)) {
				mergedList.add(input1.get(0));
				//remove the element you added to mergedList from the input list o that it isn't the first element anymore
				input1.remove(0);
				
				} 
			else {
				//else add the first element of input2 to mergedList
				mergedList.add(input2.get(0));
				//then remove it from input2 so that it isn't the first element anymore
				input2.remove(0);
				
				}

			
		if (input1.size()*input2.size()==0) {
			//break out of the loop when one input list is empty
			x=false;
		}
		
	}
		
			
		if (input1.size()==0 && input2.size()!=0) {
			//if input1 list is empty and input2 is not then add whatever is remaining from input2 to mergedList
			for (int j= 0; j<input2.size(); j++) {
				mergedList.add(input2.get(j));
			}
		}
		if (input2.size()==0 && input1.size()!=0) {
			//if input2 list is empty and input2 is not then add whatever is remaining from input1 to mergedList
			for (int i= 0; i<input1.size(); i++) {
				mergedList.add(input1.get(i));
			}
		}
		

		// return the merged list
		return mergedList;
	}
	/**
	 * Recursive Merge Sort.
	 * @param input - the list to be sorted.
	 */
	
	public static List<Integer> recursive(List<Integer> input ) {

		
		 if (input.size()>1) {
			 //if there's more than one element in the input list then divide the size of list by 2 
			int midIndex = input.size()/2;
			
			//Split the list in half:
			//create a list that contains elements from the first half of the input list 
			List<Integer> firstHalf= new ArrayList<>(input.subList(0, midIndex));
			//create a list that contains elements from the second half of the input list 
			List<Integer> secondHalf= new ArrayList<>(input.subList(midIndex, input.size()));
			
			//keep splitting into halves
			List<Integer> spiltFirstHalf= recursive(firstHalf);
			List<Integer> spiltSecondHalf= recursive(secondHalf);
			
			//combine the halves to create a mergedList
			List<Integer> merged= MergeSort.join(spiltFirstHalf,spiltSecondHalf);
			return merged;
			
			
			
		
		} 
		
		return input;
		
	}
	/**
	 * Iterative Merge Sort.
	 * @param input - the list to be sorted.
	 */
	
	public static List<Integer> iterative(List<Integer> input ) {
		List<List<Integer>> singleList= new ArrayList<>();
		
		//place each element of the original list into a new singleton list
		//store all the singleton lists in a list of lists
		for(int element : input) {
		    List <Integer> list = new ArrayList <>();
		    list.add(element);
		    singleList.add(list);
		}
		//While more than one list remains, take the first two lists from your work queue and merge them
		while (singleList.size()>1) {
			List <Integer> mergeTwo = MergeSort.join(singleList.get(0),singleList.get(1));
			//remove the singleton lists from the front of list of lists
			singleList.remove(0);
			singleList.remove(0);
			//add the combined singleton lists to the back of the list of lists
			singleList.add(mergeTwo);
			
			
			}
		//return the combined list
		return singleList.get(0);	
		
		} 
	

//Test
//	public static void main(String[] args) {
//		List<Integer> newList= new ArrayList<>();
//		List<Integer> newList1= new ArrayList<>();
//		newList.addAll(Arrays.asList(5,1,7,4,9));
//		newList1.addAll(Arrays.asList(15,20,3,87,110,97));
//		System.out.println(recursive(newList1));
//		
//	}
		
		
	}
	



