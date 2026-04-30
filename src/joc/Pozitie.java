package joc;

public class Pozitie {
    private int x, y;

    public Pozitie(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x * 100 + y);
    }
}
