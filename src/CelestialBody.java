import java.util.Random;

public class CelestialBody implements Body{
    int x, y;
    int xspd, yspd;
    static int maxSpd;
    static int size;

    /**
     * constructor, generates from the edge of the screen with
     * velocity which points inside the JFrame
     * @param position - string which determines which side the body spawns on
     */
    CelestialBody(String position) {
        Random rand = new Random();
        switch (position) {
            case "top":
                x = rand.nextInt(MassiveMotion.getWindowSizeX());
                y = 0;
                xspd = getSpeed(maxSpd);
                yspd = rand.nextInt(maxSpd) + 1;
                break;
            case "bottom":
                x = rand.nextInt(MassiveMotion.getWindowSizeX());
                y = MassiveMotion.getWindowSizeY();
                xspd = getSpeed(maxSpd);
                yspd = -rand.nextInt(maxSpd) - 1;
                break;
            case "left":
                x = 0;
                y = rand.nextInt(MassiveMotion.getWindowSizeY());
                xspd = rand.nextInt(maxSpd) + 1;
                yspd = getSpeed(maxSpd);
                break;
            case "right":
                x = MassiveMotion.getWindowSizeX();
                y = rand.nextInt(MassiveMotion.getWindowSizeY());
                xspd = -rand.nextInt(maxSpd) - 1;
                yspd = getSpeed(maxSpd);
                break;
            default:
                System.out.println("Error: couldn't create Object");
        }
    }

    /**
     * generates a random speed value between -maxSpd and maxSpd,
     * excludes 0 as a possibility
     * @param max - max speed
     * @return
     */
    private int getSpeed(int max) {
        Random rand = new Random();
        return (rand.nextBoolean()? rand.nextInt(1, maxSpd + 1): rand.nextInt(-maxSpd -1, -1));
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

    /**
     * 'ticks' the body forward by adding x to xspd and y to yspd
     */
    public void update() {
        x += xspd;
        y += yspd;
    }

    /**returns true if the celestial body is more than 10
     * pixels outside the edge of the specified JFrame
     * @param maxX - width of the frame
     * @param maxY - height of the frame
     * @return true if the body is out of bounds.
     */
    public boolean outOfBounds(int maxX, int maxY) {
        return (x > maxX + 10 || x < -10 || y > maxY + 10 || y < -10);
    }



}
