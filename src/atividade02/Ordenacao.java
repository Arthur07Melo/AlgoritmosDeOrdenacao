package atividade02;
import java.util.Random;
import java.util.Arrays;

public class Ordenacao{
    public boolean checaVetorOrdenado(int[] numeros){
        for(int i =0;i<numeros.length;i++) {
			if(numeros[i]>numeros[i+1]) {
				return false;
			}
		}
		return true;
    }
	
    public long bubbleSort(int[] numeros) {
        int n = numeros.length;
        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    swap(numeros, j, j + 1);
                }
            }
        }
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }

    public long selectionSort(int[] numeros) {
        int n = numeros.length;
        long startTime = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[min]) {
                    min = j;
                }
            }
            swap(numeros, i, min);
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return executionTime;
    }
	
	public long insertionSort(int[] numeros){
        long ini = System.nanoTime();
        for (int i = 1; i < numeros.length; i++){
            int key = numeros[i];
            int j = i - 1;

            while(j > 0 && numeros[j] > key){
                numeros[j+1] = numeros[j];
                j = j - 1;
            }
            numeros[j + 1] = key;
        } 
        return System.nanoTime() - ini;
    }
	
	public long mergeSort(int[] numeros){
        long antes = System.nanoTime();
		long depois;
		
		int n = numeros.length;
		auxMerge(numeros, 0, n-1);
		depois = System.nanoTime();
		return depois-antes;
    }

    private static void auxMerge(int[] numeros, int ini, int fim) {
		if(fim<=ini){
            return;
        }
        else {
			int meio = (ini+fim)/2;
			int[] resultante = new int[numeros.length];
			
			auxMerge(numeros, ini, meio);
			auxMerge(numeros, meio + 1, fim);
			
			intercalar(numeros,resultante,ini,meio,fim);
		}
	}
    
    private static void intercalar(int[] numeros,int[] resultante, int ini, int meio, int fim) {
		int esquerda = meio;
		int direita = fim;
		int i = ini;
		int j = meio+1;
		int index = ini;
		
		while(i <= esquerda && j <= direita) {
			if(numeros[i] <= numeros[j]) {
				resultante[index] = numeros[i];
				i++;
			}else {
				resultante[index] = numeros[j];
				j++;
			}
			index++;
		}
		
		while (i<= meio) {
			resultante[index] = numeros[i];
			i++;
			index++;
		}
		while (j<= fim) {
			resultante[index] = numeros[j];
			j++;
			index++;
		}
		
		
		for(int k = ini;k<=fim;k++) {
			numeros[k] = resultante[k];
		}
	}
    //QUICKSORT
    public long quickSort(int[] numeros){
        long inicio = System.nanoTime();
        this.quickSort_auxiliar(numeros, 0, numeros.length-1);
        long fim = System.nanoTime();
        return fim-inicio;
    }

    private void quickSort_auxiliar(int[] numeros, int left, int right){
        if(left<right){
            int pivot = this.quickSort_partition(numeros, left, right);
            quickSort_auxiliar(numeros, left, pivot-1);
            quickSort_auxiliar(numeros, pivot+1, right);
        }
    }

    private int quickSort_partition(int[] numeros, int left, int right){
        int pivot = numeros[left];
        int i = left+1;
        int j = right;
        while(i <= j){
            if(pivot>=numeros[i]){
                i++;
            }
            else if(pivot<numeros[j]){
                j--;
            }
            else{
                swap(numeros, i, j);
            }
        }
        swap(numeros, left, j);
        return j;
    }

    static void swap(int[] numeros, int a, int b){
        int aux = numeros[b];
        numeros[b] = numeros[a];
        numeros[a] = aux;
    }

	public long random_quickSort(int[] numeros){
        long inicio = System.nanoTime();
        this.random_quickSort_auxiliar(numeros, 0, numeros.length-1);
        long fim = System.nanoTime();
        return fim-inicio;
    }

    private void random_quickSort_auxiliar(int[] numeros, int left, int right){
        if(left < right){
            int pivot = random_quickSort_partition(numeros, left, right);
            random_quickSort_auxiliar(numeros, left, pivot-1);
            random_quickSort_auxiliar(numeros, pivot+1, right);
        }
    }

    private int random_quickSort_partition(int[] numeros, int left, int right){
        Random rand = new Random();
        int pivotIndex = rand.nextInt(right-left)+left;
        swap(numeros, pivotIndex, left);
        int pivot = numeros[left];

        int i = left+1;
        int j = right;
        while(i <= j){
            if(pivot>=numeros[i]){
                i++;
            }
            else if(pivot<numeros[j]){
                j--;
            }
            else{
                swap(numeros, i, j);
            }
        }
        swap(numeros, left, j);
        return j;
    }

    public long quickSort_Java(int[] numeros){
        long ini = System.nanoTime();
        Arrays.sort(numeros);
        long fim = System.nanoTime();
        return fim-ini;
    }

    public long countingSort(int[] numeros){
        long ini = System.nanoTime();
        int maxValue = this.maxValueOf(numeros) + 1;
        int aux[] = new int[maxValue];
        int arrayOrdenado[] = new int[numeros.length];
        
        for(int i = 0; i < maxValue; i++){
            aux[i] = 0;
        }
        
        for(int j = 0; j < numeros.length; j++){
            aux[numeros[j]]++;
        }

        for(int i = 1; i < maxValue; i++){
            aux[i] = aux[i] + aux[i-1];
        }
        
        for(int i = numeros.length-1; i >= 0; i--){
            arrayOrdenado[aux[numeros[i]] - 1] = numeros[i];
            aux[numeros[i]]--;
        }
        long fim = System.nanoTime();
        return fim-ini;
    }

    private int maxValueOf(int[] numeros){
        int maior = numeros[0];
        for(int i = 1; i < numeros.length; i++){
            if(maior < numeros[i]){
                maior = numeros[i];
            }
        }
        return maior;
    }
}

