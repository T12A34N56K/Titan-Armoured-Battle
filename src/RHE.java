import java.util.Random;

public class RHE {
    public Ofensiv buildShoulderRockets(){
        return new Ofensiv(15, 6, 15, 40, 90);
    }

    public Ofensiv buildShoulderMinigun(){
        return new Ofensiv(5, 30, 0, 20, 20);
    }

    public Scut buildLightShield(){
        return new Scut(30, 1);
    }

    public Scut buildHeavyShield(){
        return new Scut(100, 4);
    }

    public Scut buildReflectorShield(){
        return new Scut(20, 1){
            public int atac(Titan inamic) {
                Random r = new Random();

                if(r.nextInt(100) < 50) {
                    inamic.iaDaune(viata - ramas);
                    return 0;
                }

                return 1;
            }
        };
    }

    @Override
    public String toString() {
        return "Catalog:\n 1. Shoulder Rockets\n 2. Shoulder Minigun\n 3. Light Shield\n 4. Heavy Shield\n 5. Reflector Shield";
    }
}
