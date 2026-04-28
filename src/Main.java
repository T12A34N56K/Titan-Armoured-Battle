import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean gata = true;

        while (gata) {
            System.out.println("Ce doresti sa faci?\n 1. O echipa noua\n 2. Sa alegi o echipa\n 3. Modifica o echipa\n 4. Sa joci");

            int optiune = scanner.nextInt();

            for (int i = 0; i < 6; i++) {
                System.out.print("\033[F");
                System.out.print("\033[2K");
            }

            switch (optiune) {
                case 1:
                    Jucator.getInstance().creazaEchipa();
                    break;
                case 2:
                    Jucator.getInstance().alegeEchipa();
                    break;
                case 3:
                    System.out.println("Alege din:\n" + Jucator.getInstance());

                    optiune = scanner.nextInt();

                    System.out.print("\033[F");
                    System.out.print("\033[2K");

                    System.out.print("\033[F");
                    System.out.print("\033[2K");

                    Jucator.getInstance().modificaEchipa(optiune);

                    break;
                case 4:
                    gata = false;
                    break;
            }
        }
        MapGenerator map = new MapGenerator();

        map.generateMap();

        map.printColoredMap();
    }
}