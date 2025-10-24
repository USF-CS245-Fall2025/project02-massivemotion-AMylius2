import java.util.Random;

public class QuickSort  extends Sort{

    @Override
    public String toString() {
        return "Quick Sort";
    }

    Random rand = new Random();

    public double[] sort(double[] arr) {
        copyArray(arr);
        timerStart();
        quickSort(0, array.length-1);
        long timeElapsed = timerStop();
        writeToFile( timeElapsed, arr.length);
        return array;
    }
    protected void sort() {
        quickSort(0, array.length-1);
    }

    private void quickSort(int low, int high) { //code for this section is based on the pseudocode provided by https://www.youtube.com/watch?v=Hoixgm4-P4M and implementations by geeksforgeeks.org
        if (low<high) {
            int pivotIndex = partition(low, high); // sort values to the left or right of the pivot

            quickSort(low, pivotIndex-1); //call quicksort again on newly formed partitions
            quickSort(pivotIndex+1, high);

        }

    }

    private void swap(int a, int b) {//swap function since it's called 3 times
        double temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int partition(int low, int high) {
        //quickly choose pivot (random selection and swap with highest index of the partition
//        int pivotIndex = rand.nextInt(low, high+1);
//        double pivot = array[pivotIndex];
//        swap(pivotIndex, high);
//
        int pivotIndex = high;
        double pivot = array[high];

        int i=low-1;
        for(int j=low; j<high; j++) {
            if (array[j]<pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i+1, high);
        return i+1;
    }
}
