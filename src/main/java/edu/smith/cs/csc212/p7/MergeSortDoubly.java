package edu.smith.cs.csc212.p7;



/**
 * MergeSortDoubly.
 * @author jfoley
 *
 */
public class MergeSortDoubly {
	/**
	 * Merge Sort with P6 Doubly-Linked List
	 * @param input1 - the first sorted Doubly-Linked List to be combined.
	 * @param input1 - the second sorted Doubly-Linked List to be combined.
	 */
	public static DoublyLinkedList<Integer> Djoin(DoublyLinkedList<Integer> input1, DoublyLinkedList<Integer> input2) {
		
		//create a new list
		DoublyLinkedList<Integer> mergedList = new DoublyLinkedList<Integer>();
		
		boolean x= true; 
		
		while(x) {
			//if first node of input1 is smaller the first node of input2 add that
			//node from input1 to mergedList
			if (input1.getIndex(0) < input2.getIndex(0)) {
				mergedList.addBack(input1.getIndex(0));
				//remove the node you added to mergedList from the input list o that it isn't the first node anymore
				input1.removeIndex(0);
				
				} 
			else {
				//else add the first node of input2 to mergedList
				mergedList.addBack(input2.getIndex(0));
				//then remove it from input2 so that it isn't the first node anymore
				input2.removeIndex(0);
				
				}

			
		if (input1.size()*input2.size()==0) {
			//break out of the loop when one input list is empty
			x=false;
		}
		
	}
		
			
		if (input1.size()==0 && input2.size()!=0) {
			//if input1 list is empty and input2 is not then add whatever is remaining from input2 to mergedList
			for (int j= 0; j<input2.size(); j++) {
				mergedList.addBack(input2.getIndex(j));
			}
		}
		if (input2.size()==0 && input1.size()!=0) {
			//if input2 list is empty and input2 is not then add whatever is remaining from input1 to mergedList
			for (int i= 0; i<input1.size(); i++) {
				mergedList.addBack(input1.getIndex(i));
			}
		}
		

		return mergedList;
	}
	

	
	
	/**
	 * Iterative Merge Sort for Doubly-Linked list.
	 * @param input - the Doubly-Linked list to be sorted.
	 */
	public static DoublyLinkedList<Integer> Diterative(DoublyLinkedList<Integer> input ) {
		DoublyLinkedList<DoublyLinkedList<Integer>> singleList= new DoublyLinkedList<>();
		
		//place each node of the original list into a new singleton list
		//store all the singleton lists in a list of lists
		for (int i=0; i<input.size();i++) {
		    DoublyLinkedList <Integer> list = new DoublyLinkedList <>();
		    list.addFront(input.getIndex(i));
		    singleList.addBack(list);
		}
		//While more than one list remains, take the first two lists from your work queue and merge them
		while (singleList.size()>1) {
			DoublyLinkedList <Integer> mergeTwo = MergeSortDoubly.Djoin(singleList.getFront(),singleList.getIndex(1));
			//remove the singleton lists from the front of list of lists
			singleList.removeFront();
			singleList.removeFront();
			//add the combined singleton lists to the back of the list of lists
			singleList.addBack(mergeTwo);
			
			
			}
		//return the combined list
		return singleList.getIndex(0);	
		
		}
	
	/**
	 * Recursive Merge Sort.
	 * @param input - the list to be sorted.
	 */
	public static DoublyLinkedList<Integer> Drecursive(DoublyLinkedList<Integer> input ) {

		
		 if (input.size()>1) {
			 //if there's more than one element in the input list then divide the size of list by 2 
			int midIndex = input.size()/2;
			
			DoublyLinkedList <Integer> left = new DoublyLinkedList <>();
			
			//Split the list in half:
			//create a list that contains nodes from the first half of the input list 
			for (int i=0; i<midIndex; i++) {
				left.addBack(input.getIndex(i));
			}
			//keep splitting into halves
			DoublyLinkedList <Integer> splitLeft = Drecursive(left);
			
			
			
			//create a list that contains nodes from the second half of the input list 
			DoublyLinkedList <Integer> right = new DoublyLinkedList <>();
			for (int i=midIndex; i<input.size(); i++) {
				right.addBack(input.getIndex(i));
			}
			//keep splitting into halves
			DoublyLinkedList <Integer> splitRight = Drecursive(right);
			
			
			
			
			
			//combine the halves to create a mergedList
			DoublyLinkedList<Integer> merged= MergeSortDoubly.Djoin(splitLeft,splitRight);
			return merged;
			
			
			
		
		} 
		
		return input;
		
	}
//Test	
//	public static void main(String[] args) {
//		DoublyLinkedList<Integer> newList= new DoublyLinkedList<>();
//		newList.addFront(4);
//		newList.addBack(2);
//		newList.addBack(50);
//		newList.addBack(11);
//		newList.addBack(100);
//		DoublyLinkedList<Integer> idc= Diterative(newList);
//		idc.printD();
//		
//		
//
//		
//	}
		
		
	}
	



