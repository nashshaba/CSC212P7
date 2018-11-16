package edu.smith.cs.csc212.p7;

import java.util.ArrayList;

//import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	private static int[] data1 = {2,4,6};
	private static int[] data2 = {3,5,7,11,13};
	
	@Test
	public void testSelectionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
			
		}
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		SelectionSort.selectionSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testInsertionSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe2 = new ArrayList<>();
		for (int y : data2) {
			sortMe2.add(y);
		}
		InsertionSort.insertionSort(sortMe2);
		Assert.assertTrue(checkSorted(sortMe2));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe2);
		InsertionSort.insertionSort(sortMe2);
		Assert.assertTrue(checkSorted(sortMe2));
	}
	
	@Test
	public void testMergeSort() {
		// See if the data can be reversed:
		List<Integer> sortMe = new ArrayList<>();
		List<Integer> secondSortMe = new ArrayList<>();
		
		for (int y : data1) {
			sortMe.add(y);
		}
		secondSortMe.addAll(sortMe);
		
		List<Integer> sortMe1 = new ArrayList<>();
		List<Integer> secondSortMe1 = new ArrayList<>();
		
		for (int y : data2) {
			sortMe1.add(y);
		}
		secondSortMe1.addAll(sortMe1);
		
		
		List<Integer> sortMe2 = new ArrayList<>();
		for (int y : data) {
			sortMe2.add(y);
		}
		
		List<Integer>finalList = MergeSort.join(sortMe, sortMe1);
		Assert.assertTrue(checkSorted(finalList));
		
//		List<Integer> copyFinalList = MergeSort.join(secondSortMe, secondSortMe1);
//		Collections.shuffle(copyFinalList);
//		MergeSort.join(secondSortMe, secondSortMe1);
//		Assert.assertTrue(checkSorted(copyFinalList));
//		
		
		
		//For good measure, let's shuffle it and sort it again to see if that works, too.
		List<Integer> mergedRecursive = MergeSort.recursive(sortMe);
		Assert.assertTrue(checkSorted(mergedRecursive));
		
		
		Collections.shuffle(mergedRecursive);
		MergeSort.recursive(sortMe);
		Assert.assertTrue(checkSorted(mergedRecursive));
		

		
	}


}
