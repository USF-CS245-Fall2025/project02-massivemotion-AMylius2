public class Star implements Body{
    static int x, y;
    static int xspd, yspd;
    static int size;

    //constructor which initializes variables
    Star(int X, int Y, int Size, int Xspd, int Yspd) {
        x = X;
        y = Y;
        xspd = Xspd;
        yspd = Yspd;
        size = Size;
    }

    //updates x and y values
    public void update() {
        x += xspd;
        y += yspd;
    }

    /**returns true if the star is more than 10
     * pixels outside the edge of the specified JFrame
     * @param maxX - width of the frame
     * @param maxY - height of the frame
     * @return true if the star is out of bounds.
     */
    public boolean outOfBounds(int maxX, int maxY) {
        return (x > maxX + 10 || x < -10 || y > maxY + 10 || y < -10);
    }

    //getter for x
    public int getX() {
        return x;
    }

    //getter for y
    public int getY() {
        return y;
    }

    //getter for size
    public int getSize() {
        return size;
    }
}
