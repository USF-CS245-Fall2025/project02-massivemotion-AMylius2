import java.util.Random;

public class RunSort {
    public static void main(String[] args) {

        //create array of sorting alg Objects of type Sort
        Sort[] algs = new Sort[2];

//        algs[0] = new BubbleSort();
//        algs[1] = new SelectionSort();
//        algs[2] = new InsertionSort();
//        algs[3] = new QuickSort();
        algs[0] = new MergeSort();
        algs[1] = new ModifiedMerge();

        for (int i=50000; i<=500000; i+= 50000) {
            //create random array
            double[] randomArr = randArray(i);
            //loop through algs and run sort(randArray)
            for (int j=0; j<algs.length; j++) {
                Sort alg = algs[j];
                alg.startSort(randomArr);
            }
        }
    }

    public static double[] randArray(int length) { //method which generates an array of random values
        Random rand = new Random();
        double[] toReturn = new double[length];

        for (int i=0; i<length; i++) {
            toReturn[i] = rand.nextDouble();
        }

        return toReturn;
    }


}