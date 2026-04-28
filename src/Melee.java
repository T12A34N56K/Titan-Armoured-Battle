import java.util.Random;

public class Melee implements Arma{
    private final int daune, atacuri, precizie;
    private final boolean douaMaini;

    Melee(int daune, int atacuri, int precizie, boolean douaMaini){
        this.daune = daune;
        this.atacuri = atacuri;
        this.precizie = precizie;
        this.douaMaini = douaMaini;
    }

    public boolean isDouaMaini() {
        return douaMaini;
    }

    @Override
    public int atac(Titan inamic) {
        Random r = new Random();

        for (int i = 0; i < atacuri; i++) {
            if(r.nextInt(100) < precizie){
                inamic.iaDaune(daune);
                return 0;
            }
        }

        return 1;
    }

    @Override
    public String toString() {
        return daune + "x" + atacuri + " " + precizie+ "% " + " | " + douaMaini;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Melee(daune, atacuri, precizie, douaMaini);
    }
}
