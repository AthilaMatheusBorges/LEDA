package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int j = dividir(array, leftIndex, rightIndex);
			sort(array, leftIndex, j - 1);
			sort(array, j +1, rightIndex);
		}
	}
	
	private static int dividir(T[] array, int leftIndex, int rigthIndex) {
		int i = leftIndex, j = rigthIndex;
		
		while(i < j) {
			while(i < rigthIndex && array[i] <= array[leftIndex] ) {
				i++;
			}
			while(j > leftIndex && array[j] >= array[leftIndex]) {
				j++;
			}
			if(i < j) {
				Util.swap(array, i, j);
				i ++;
				j --;
			}
			Util.swap(array, leftIndex, j);
			return j;
		}
	}
}
