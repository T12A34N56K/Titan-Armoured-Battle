public class MisriahArmoury {
    public Ranged buildRailgun(){
        return new Ranged(100, 1, 10, 50, 95, true);
    }

    public Ranged buildThermiteLouncher(){
        return new Ranged(110, 1, 2, 20, 80, true);
    }

    public Ranged buildRevolver(){
        return new Ranged(10, 6, 0, 20, 50, false);
    }

    public Melee buildKnife(){
        return new Melee(20, 5, 80, false);
    }

    public Melee buildSword(){
        return new Melee(110, 2, 90, true);
    }

    @Override
    public String toString() {
        return "Catalog:\n 1. Railgun\n 2. Thermite Louncher\n 3. Revolver\n 4. Knife\n 5. Sword";
    }
}
