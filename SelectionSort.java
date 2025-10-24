public class SelectionSort extends Sort {

    @Override
    public String toString() {
        return "Selection Sort";
    }

    @Override
    protected void sort() {

        for (int i=0; i<array.length; i++) { //loop through array
            int min = i;
            for (int j=i; j<array.length; j++) { //scan array for minimum value
                if(array[j] < array[min])  {
                    min = j;
                }
            }
            //swap minimum of array and first non-sorted index
            double temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

}
