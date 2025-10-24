public class InsertionSort  extends Sort {

    @Override
    public String toString() {
        return "Insertion Sort";
    }

    protected void sort() {
        for(int i=1; i<array.length; i++) {
            double val = array[i];
            int index = i-1;

            while (index>=0 && array[index]>val) {
                array[index+1] = array[index];
                index--;
            }
            array[index+1] = val;
        }
    }
}
