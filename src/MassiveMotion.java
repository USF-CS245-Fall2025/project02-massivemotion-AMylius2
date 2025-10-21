import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

public class MassiveMotion extends JPanel implements ActionListener {
    //celestial body variables
    private List<Body> bodyList;
    double genX;
    double genY;

    //timer variables
    static Timer tm;

    //window specs
    private static int windowSizeX, windowSizeY;

    //getter methods for window variables
    public static int getWindowSizeX() {return windowSizeX;}
    public static int getWindowSizeY() {return windowSizeY;}

    /** takes in file name as an argument and calls the "readFile" method
        to set up a JFrame based on it
     */
    public static void main(String[] args) {
        MassiveMotion m = new MassiveMotion();

        m.readFile(args[0]);
        JFrame jf = new JFrame();
        m.setBackground(Color.LIGHT_GRAY);
        jf.setTitle("Massive Motion");
        jf.setSize(windowSizeX, windowSizeY);
        jf.add(m);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Loops through List of Celestial bodies, draws them on the JFrame
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ListIterator<Body> it = bodyList.iterator();
        while(it.hasNext()) {
            Body body = it.next();
            if (body instanceof Star) {
                g.setColor(Color.RED);
            } else { g.setColor(Color.BLACK); }

            g.fillOval(body.getX(), body.getY(), body.getSize(), body.getSize());
        }

        tm.start();
    }

    /**
     * Updates celestial bodies when the timer goes off,
     * calls the repaint function, which repaints them before
     * updating using an iterator
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        repaint();
        ListIterator<Body> it = bodyList.iterator();
        while (it.hasNext()) {
            Body body = it.next();
            body.update();
            if (body.outOfBounds(windowSizeX, windowSizeY)) {
                it.remove();
            }

        }
        Random rand = new Random();
        if (rand.nextDouble() < genX) {
            if (rand.nextDouble() < 0.5) {
                CelestialBody cb = new CelestialBody("left");
                bodyList.add(cb);
            } else {
                CelestialBody cb = new CelestialBody("right");
                bodyList.add(cb);
            }
        }

        if (rand.nextDouble() < genY) {
            if (rand.nextDouble() < 0.5) {
                CelestialBody cb = new CelestialBody("top");
                bodyList.add(cb);
            } else {
                CelestialBody cb = new CelestialBody("bottom");
                bodyList.add(cb);
            }
        }


    }

    /**
     *  initializes variables based on their values in the text file
     * @param name of the file
     */
    private void readFile(String name) {

        Properties prop = new Properties();
        try {
            //initialize class loader
            ClassLoader classLoader = MassiveMotion.class.getClassLoader();

            //
            URL res = Objects.requireNonNull(classLoader.getResource(name),
                    "Can't find configuration file " + name);

            //create
            InputStream is = new FileInputStream(res.getFile());
            prop.load(is);

            //load timer delay and list type
            tm = new Timer(Integer.parseInt(prop.getProperty("timer_delay")), this);
            switch (prop.getProperty("list")) {
                case "arraylist":
                    bodyList = new ArrayList<>();
                    break;
                case "single":
                    bodyList = new LinkedList<>();
                    break;
                case "double":
                    bodyList = new DoublyLinkedList<>();
                    break;
                case "dummyhead":
                    bodyList = new DummyHeadLinkedList<>();
                    break;
                default:
                    System.out.println("Invalid list type");
                    System.exit(0);
            }

            //load window variables
            windowSizeX = Integer.parseInt(prop.getProperty("window_size_x"));
            windowSizeY = Integer.parseInt(prop.getProperty("window_size_y"));

            //load celestial body variables
            genX = Double.parseDouble(prop.getProperty("gen_x"));
            genY = Double.parseDouble(prop.getProperty("gen_y"));
            CelestialBody.size = Integer.parseInt(prop.getProperty("body_size"));
            CelestialBody.maxSpd = Integer.parseInt(prop.getProperty("body_velocity"));

            //load star variables
            Star theStar = new Star(Integer.parseInt(prop.getProperty("star_position_x")), Integer.parseInt(prop.getProperty("star_position_y")), Integer.parseInt(prop.getProperty("star_size")), Integer.parseInt(prop.getProperty("star_velocity_x")), Integer.parseInt(prop.getProperty("star_velocity_y")));
            bodyList.add(theStar);

        } catch (IOException e) {
            System.out.println("Error reading from file");
        } catch (NullPointerException npe) {
            System.out.println("Error: File not found");
            System.exit(0);
        }
    }
}
