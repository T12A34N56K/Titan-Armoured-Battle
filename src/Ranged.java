import java.util.Random;

public class Ranged implements Arma{
    private final int daune, atacuri, minRange, maxRange, precizie;
    private final boolean douaMiani;

    Ranged(int daune, int atacuri, int minRange, int maxRange, int precize, boolean douaMiani){
        this.daune = daune;
        this.atacuri = atacuri;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.precizie = precize;
        this.douaMiani = douaMiani;
    }

    @Override
    public int atac(Titan inamic) {
        Random r = new Random();

        for (int i = 0; i < atacuri; i++) {
            if(r.nextInt(100) < precizie) {
                inamic.iaDaune(daune);
                return 0;
            }
        }

        return 1;
    }

    @Override
    public boolean isDouaMaini() {
        return douaMiani;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    @Override
    public String toString() {
        return daune + "x" + atacuri + ", " + precizie+ "%, " + minRange + " - " + maxRange + "m | " + douaMiani;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Ranged(daune, atacuri, minRange, maxRange, precizie, douaMiani);
    }
}
