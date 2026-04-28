public class IMC {
    public Sasiu buildMonarch(){
        return new Sasiu(220, 5, 60);
    }

    public Sasiu buildIon(){
        return new Sasiu(250, 5, 35);
    }

    public Sasiu buildRonin(){
        return new Sasiu(135, 8, 40);
    }

    public Sasiu buildNorthStar(){
        return new Sasiu(115, 7, 80);
    }

    public Sasiu buildScorch(){
        return new Sasiu(400, 3, 35);
    }

    @Override
    public String toString() {
        return "Catalog:\n 1. Monarch\n 2. Ion\n 3. Ronin\n 4. North Star\n 5. Scorch";
    }
}
