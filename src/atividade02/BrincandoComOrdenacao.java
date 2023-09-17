package atividade02;
import java.util.Random;

public class BrincandoComOrdenacao {
    public static void main(String[] args) throws Exception {
        calcular_media(4000, 50);
        calcular_media(7000, 50);
        calcular_media(10000, 50);
    }


    public static void calcular_media(int tamVetor, int iter){
        System.out.printf("================ TESTES COM VETOR TAMANHO %d ================", tamVetor);
        Ordenacao orden = new Ordenacao();
        int arrayCrescente[] = cria_arrayCrecente(tamVetor);
        int arrayDecrescente[] = cria_arrayDecrescente(tamVetor);
        int arrayAleatorio[] = cria_arrayAleatorio(tamVetor); 

        long mergeTime = 0;
        long quickTime = 0;
        long selectionTime = 0;
        long insertionTime = 0;
        long countingTime = 0;
        long bubbleTime = 0;
        long random_quickTime = 0;
        long java_quickTime = 0;

        for(int i = 0; i<=iter; i++){
            mergeTime += orden.mergeSort(arrayCrescente.clone());
            quickTime += orden.quickSort(arrayCrescente.clone());
            random_quickTime += orden.random_quickSort(arrayCrescente.clone());
            java_quickTime += orden.quickSort_Java(arrayCrescente.clone());
            selectionTime += orden.selectionSort(arrayCrescente.clone());
            countingTime += orden.countingSort(arrayCrescente.clone());
            insertionTime += orden.insertionSort(arrayCrescente.clone());
            bubbleTime += orden.bubbleSort(arrayCrescente.clone());
        }
        
        System.out.printf("""
            \n\nVetor em Ordem Crescente:
                bubbleSort time:      %d
                insertionSort time:   %d
                selectionSort time:   %d
                mergeSort time:       %d
                quickSort time:       %d
                randomQuickSort time: %d
                javaQuickSort time:   %d
                countingSort time:    %d
                """, bubbleTime, insertionTime, selectionTime, mergeTime, quickTime, random_quickTime, java_quickTime, countingTime);

         mergeTime = 0;
         quickTime = 0;
         selectionTime = 0;
         insertionTime = 0;
         countingTime = 0;
         bubbleTime = 0;
         random_quickTime = 0; 
         java_quickTime = 0;

         for(int i = 0; i<=iter; i++){
            mergeTime += orden.mergeSort(arrayDecrescente.clone());
            quickTime += orden.quickSort(arrayDecrescente.clone());
            random_quickTime += orden.random_quickSort(arrayDecrescente.clone());
            java_quickTime += orden.quickSort_Java(arrayDecrescente.clone());
            selectionTime += orden.selectionSort(arrayDecrescente.clone());
            countingTime += orden.countingSort(arrayDecrescente.clone());
            insertionTime += orden.insertionSort(arrayDecrescente.clone());
            bubbleTime += orden.bubbleSort(arrayDecrescente.clone());
            
            
        }

        System.out.printf("""
            \n\nVetor em Ordem Descrescente:
                bubbleSort time:      %d
                insertionSort time:   %d
                selectionSort time:   %d
                mergeSort time:       %d
                quickSort time:       %d
                randomQuickSort time: %d
                javaQuickSort time:   %d
                countingSort time:    %d
                """, bubbleTime, insertionTime, selectionTime, mergeTime, quickTime, random_quickTime, java_quickTime, countingTime);
        
         for(int i = 0; i<=iter; i++){
            mergeTime += orden.mergeSort(arrayAleatorio.clone());
            quickTime += orden.quickSort(arrayAleatorio.clone());
            random_quickTime += orden.random_quickSort(arrayAleatorio.clone());
            java_quickTime += orden.quickSort_Java(arrayAleatorio.clone());
            selectionTime += orden.selectionSort(arrayAleatorio.clone());
            countingTime += orden.countingSort(arrayAleatorio.clone());
            insertionTime += orden.insertionSort(arrayAleatorio.clone());
            bubbleTime += orden.bubbleSort(arrayAleatorio.clone());
        }

        System.out.printf("""
            \n\nVetor aleatório:
                bubbleSort time:      %d
                insertionSort time:   %d
                selectionSort time:   %d
                mergeSort time:       %d
                quickSort time:       %d
                randomQuickSort time: %d
                javaQuickSort time:   %d
                countingSort time:    %d
                """, bubbleTime, insertionTime, selectionTime, mergeTime, quickTime, random_quickTime, java_quickTime, countingTime);
        
    }

    public static int[] cria_arrayCrecente(int tam){
        int array[] = new int[tam];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        return array;
    }

    public static int[] cria_arrayDecrescente(int tam){
        int array[] = new int[tam];
        for(int i = 0; i<tam; i++){
            array[tam-i-1] = i;
        }
        return array;
    }
    
    public static  int[] cria_arrayAleatorio(int tam){
        int array[] = new int[tam];
        Random rand = new Random();
        for(int i = 0; i < tam; i++){
            array[i] = rand.nextInt(5001);
        }
        return array;
    }
}

