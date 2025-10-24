public class MergeSort  extends Sort{

    @Override
    public String toString() {
        return "Merge Sort";
    }

    public void sort() {
        mergeSort(0, array.length);
    }

    protected void mergeSort(int l, int r) {
        if (l<r) { //base case: if right crosses with left, recursion stops
            //calculate mid index
            int mid = l + (r-l)/2;

            //recursive calls for left and right
            mergeSort(l, mid);
            mergeSort(mid+1, r);

            //final merge call
            merge(l, r);
        }
    }

    protected void merge(int l, int r) {
        //save arrays of left and right segments of subarray
        int lLen = (r-l)/2;
        int rLen = (r-l)-(r-l)/2;
        int mid = l + rLen;

        double[] left = new double[lLen];
        double[] right = new double[rLen];

        for (int i=0; i<lLen; i++) {
            left[i] = array[l + i];
        }
        for(int i=0; i<rLen; i++) {
            right[i] = (mid + 1) + i;
        }

        //intialize variables used in while loop
        int leftIndex = 0;
        int rightIndex = 0;
        int i = l;


        while(leftIndex < left.length && rightIndex < right.length) { //fill the array with values until either left or right is empty
            if (left[leftIndex] > right[rightIndex]) {
                array[i++] = right[rightIndex++];
            } else {
                array[i++] = left[leftIndex++];
            }
        }

        while(leftIndex<left.length) { //if left still has unused values, put them into the array
            array[i++] = left[leftIndex++];
        }

        while(rightIndex<right.length) {//if right still has unused values, put them into the array
            array[i++] = right[rightIndex++];
        }
    }

}
