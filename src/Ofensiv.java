public class Ofensiv extends Ranged implements Utilitate{
    Ofensiv (int daune, int atacuri, int minRange, int maxRange, int precize){
        super(daune, atacuri, minRange, maxRange, precize, false);
    }

    @Override
    public String toString() {
        return "Umar: " + super.toString();
    }
}
