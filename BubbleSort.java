public class BubbleSort extends Sort {

    @Override
    public String toString() {
        return "Bubble Sort";
    }

    protected void sort() {
        int lowestSorted = array.length;
        boolean sorted = false;
        for(int i=0; i<array.length && !sorted; i++) {
            sorted = true;
            for(int j=0; j<lowestSorted-1; j++) {
                if (array[j] > array[j+1]) {
                    double temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            lowestSorted--;
        }

    }

}
