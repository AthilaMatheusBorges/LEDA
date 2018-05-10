package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int maior = maior(array,leftIndex,rightIndex);
		int[] temp = new int[maior];
		
		//Inicializa
		for(int i = 0; i < temp.length; i++){
			temp[i] = 0;
		}
		
		//Contagem
		for (int i = leftIndex; i < rightIndex; i++) {
			temp[array[i]] += 1;
		}
		
		//Complementa
		for (int i = leftIndex; i < maior; i++) {
			temp[i] = temp[i] + temp[i - 1];

		}
		
		//Ordena 
		int[] b = new int[array.length];

		for (int i = rightIndex; i > leftIndex; i--) {
			b[temp[array[i]]] = array[i];
			temp[array[i]] -= 1;
		}
		
		//Muda array principal
		for (int i = leftIndex; i < rightIndex; i++){
			array[i] = b[i];
		}
	}

	public static int maior(Integer[] array, int left, int rigth) {
		int maior = 0;
		for (int i = left; i < rigth; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}

}
