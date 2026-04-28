public class Sasiu {
    private int viata, viteza, optica;

    Sasiu(int viata, int viteza, int optica){
        this.viata = viata;
        this.viteza = viteza;
        this.optica = optica;
    }

    public int iaDMG(int daune){
        viata -= daune;
        return viata;
    }

    @Override
    public String toString() {
        return "Sasiu: " + viata + "hp, " + viteza + "m, " + optica + "m";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Sasiu(viata, viteza, optica);
    }
}
