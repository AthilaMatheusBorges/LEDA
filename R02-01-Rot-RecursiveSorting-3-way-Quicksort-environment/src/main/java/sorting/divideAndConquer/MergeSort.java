package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int meio;
		if (leftIndex < rightIndex) {
			meio = (leftIndex + rightIndex)/2;
			sort(array,leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			intercalar(array, leftIndex, rightIndex, meio);
		}
	}

	private void intercalar(T[] array, int leftIndex, int rightIndex, int meio) {
		T[] auxiliar =(T[]) new Comparable[array.length];
		for (int i = leftIndex; i <= rightIndex; i++) {
			auxiliar[i] = array[i];
		}

		int i = leftIndex;
		int j = meio + 1;
		int k = leftIndex;

		while (i <= meio && j <= rightIndex) {
			if (auxiliar[i].compareTo(auxiliar[j]) < 0) {
				array[k] = auxiliar[i];
				i++;
			} else {
				array[k] = auxiliar[j];
				j++;
			}
			k++;
		}

		while (i <= meio) {
			array[k] = auxiliar[i];
			i++;
			k++;
		}

		while (j <= rightIndex) {
			array[k] = auxiliar[j];
			j++;
			k++;
		}
		
	}
}
