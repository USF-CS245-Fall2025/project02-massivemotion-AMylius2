public interface Body {

    public int getX();
    public int getY();
    public int getSize();
    public void update();
    public boolean outOfBounds(int maxXm, int maxY);
}
