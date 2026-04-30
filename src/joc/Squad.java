package joc;

import componente.Titan;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private List<Titan> unitati;
    private String nume;

    Squad(){
        unitati = new ArrayList<Titan>();

        unitati.add(new Titan());
        unitati.add(new Titan());
        unitati.add(new Titan());
        unitati.add(new Titan());
        unitati.add(new Titan());
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void schimbaUnitateaX (int pozitie, Titan unitateaNoua){
        unitati.set(pozitie, unitateaNoua);
    }

    public Titan iaUnitateaX (int pozitie){
        return unitati.get(pozitie);
    }

    @Override
    public String toString() {
        String raspuns = "";
        for(int i = 0; i < 5; i++){
            raspuns += (i + 1) + ". " + unitati.get(i) + "\n\n";
        }

        return raspuns;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}