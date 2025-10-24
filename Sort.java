import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Sort {


    double array[];
    long startTime = 0;
    long endTime = 0;

    //
    public double[] startSort(double[] arr) {
        copyArray(arr);
        timerStart();
        sort();
        long timeElapsed = timerStop();
        writeToFile( timeElapsed, arr.length);
        return array;
    }

    protected abstract void sort();  //this method will be overwritten by the child classes.

    // method which copies an input array into the instance variable of Array
    public void copyArray(double[] arr) {
        array = new double[arr.length];
        for (int i=0; i<arr.length; i++) {
            array[i] = arr[i];
        }
    }


    //timer methods
    protected void timerStart() {
        startTime = System.currentTimeMillis();
    }

    protected long timerStop() {
        if (startTime == 0) {
            System.out.println("ERROR: Timer never started");
            System.exit(0);
        }
        endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        startTime = 0;
        endTime = 0;
        return timeElapsed;
    }


    //Verification method
    protected boolean verifySorted() {
        for (int i=0; i<array.length-1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }



    protected void writeToFile(long time, int items) {
        try { //file output stream which writes to a txt file that is easily readable by humans and logs it on the console
            FileOutputStream fos = new FileOutputStream("src/output.txt", true);
            String out = this.toString() + ": " + time + " ms for "+ items + " items. Sorted: " + verifySorted() + "\n";
            byte[] outBytes = out.getBytes();
            fos.write(outBytes);
            fos.close();
            System.out.printf("|%-20s|%10d|%20d|%n", this.toString(), items, time); //console print statement to check time and completion

        } catch (FileNotFoundException fnfe) {
            System.out.println("ERROR:" + fnfe);
        } catch (IOException ioe) {
            System.out.println("ERROR: + ioe");
        }

        try { //file output stream which writes to a csv file which can be more easily interpreted by a graphing system such as google charts
            FileOutputStream fos = new FileOutputStream("src/data.csv", true);
            String out = Long.toString(time) + ",";
            if (this.toString().equals("Merge Sort")) {
                out = Integer.toString(items)+ "," + out;
            } else if (this.toString().equals("Modified Merge Sort")) {
                out = out + "\n";
            }
            byte[] outBytes = out.getBytes();
            fos.write(outBytes);
            fos.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("ERROR:" + fnfe);
        } catch (IOException ioe) {
            System.out.println("ERROR: + ioe");
        }

    }

}
