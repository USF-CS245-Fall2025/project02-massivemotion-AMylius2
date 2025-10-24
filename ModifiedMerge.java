public class ModifiedMerge  extends MergeSort {

    public static void main(String[] args) {
        ModifiedMerge mm = new ModifiedMerge();
        mm.startSort(RunSort.randArray(1000000));
    }


    private boolean sorted(int l, int r) {
        for (int i=l; i<r-1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void mergeSort(int l, int r) {
        if (l<r) { //base case: if right crosses with left, recursion stops
            //calculate mid index
            int mid = l + (r-l)/2;

            //recursive calls for left and right, if necessary
            if (!sorted(l, mid)) {
                mergeSort(l, mid);
            }
            if (!sorted(mid+1, r)) {
                mergeSort(mid + 1, r);
            }

            //final merge call
            merge(l, r);
        }
    }

    @Override
    public String toString() {
        return "Modified Merge Sort";
    }

}
