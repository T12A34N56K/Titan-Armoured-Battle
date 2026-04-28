public class Scut implements Utilitate{
    protected int ramas, asteptare;
    protected final int viata, reincarcare;

    Scut(int viata, int reincarcare){
        this.viata = viata;
        ramas = viata;
        this.reincarcare = reincarcare;
        asteptare = reincarcare;
    }

    public int opresteDMG(int daune){
        if (daune == 0){
            return 0;
        }

        ramas -= daune;
        asteptare = 0;
        if (ramas < 0){
            daune = -ramas;
            ramas = 0;
            return daune;
        }

        return  0;
    }

    public boolean isRecharging(){
        return !(asteptare == reincarcare);
    }

    public void iterateAsteptare() {
        this.asteptare++;

        if (asteptare == reincarcare){
            ramas = viata;
        }
    }

    @Override
    public String toString() {
        return "Scut. Rezistenta: " + viata + " Regenerare: " + reincarcare;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Scut(viata, reincarcare);
    }
}
