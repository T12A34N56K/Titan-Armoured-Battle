package componente;

public class Titan {
    private Sasiu sasiu;
    private Arma manaStanga, manaDreapta;
    private Utilitate utilitateStanga, utilitateDreapta;

    public Titan(){
        sasiu = null;
        manaDreapta = null;
        manaStanga = null;
        utilitateDreapta = null;
        utilitateStanga = null;
    }

    Titan(Sasiu sasiu, Arma manaDreapta, Arma manaStanga, Utilitate utilitareStanga, Utilitate utilitateDreapta){
        this.sasiu = sasiu;
        this.manaDreapta = manaDreapta;
        this.manaStanga = manaStanga;
        this.utilitateDreapta = utilitateDreapta;
        this.utilitateStanga = utilitareStanga;
    }

    @Override
    public String toString() {
        return "Titan:\n Sasiu: " + sasiu + "\n Arma Mana Stanga: " + manaStanga + "\n Arma Mana Dreapta: " + manaDreapta + "\n Umar Stang: " + utilitateStanga + "\n Umar Drept: " + utilitateDreapta;
    }

    public void setSasiu(Sasiu sasiu) {
        this.sasiu = sasiu;
    }

    public void setUtilitateDreapta(Utilitate utilitateDreapta) {
        this.utilitateDreapta = utilitateDreapta;
    }

    public void setUtilitateStanga(Utilitate utilitateStanga) {
        this.utilitateStanga = utilitateStanga;
    }

    public void setManaDreapta(Arma manaDreapta) {
        this.manaDreapta = manaDreapta;
        if (manaDreapta.isDouaMaini() || (this.manaStanga != null && this.manaStanga.isDouaMaini())){
            this.manaStanga = null;
        }
    }

    public void setManaStanga(Arma manaStanga) {
        this.manaStanga = manaStanga;
        if (manaStanga.isDouaMaini() || (this.manaDreapta != null && this.manaDreapta.isDouaMaini())){
            this.manaDreapta = null;
        }
    }

    public int iaDaune(int daune){
        if(utilitateStanga.getClass()==Scut.class){
            daune = ((Scut) utilitateStanga).opresteDMG(daune);
        }
        if(utilitateDreapta.getClass()==Scut.class){
            daune = ((Scut) utilitateStanga).opresteDMG(daune);
        }

        return sasiu.iaDMG(daune);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
