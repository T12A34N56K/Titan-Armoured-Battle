package joc;

import utilitati.Utilitati;

import java.util.Scanner;

import static buiders.MapGenerator.generateMap;
import static buiders.MapGenerator.printColoredMap;
import static joc.Inamic.dijkstra;
import static utilitati.Utilitati.Bresenham;

public class Main {
    public static void main(String[] args) {
        generateMap();

        printColoredMap();

        Bresenham(new Pozitie(2, 7), new Pozitie(35, 40), 20);

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
                    joc.Jucator.getInstance().creazaEchipa();
                    break;
                case 2:
                    joc.Jucator.getInstance().alegeEchipa();
                    break;
                case 3:
                    System.out.println("Alege din:\n" + joc.Jucator.getInstance());

                    optiune = scanner.nextInt();

                    System.out.print("\033[F");
                    System.out.print("\033[2K");

                    System.out.print("\033[F");
                    System.out.print("\033[2K");

                    joc.Jucator.getInstance().modificaEchipa(optiune);

                    break;
                case 4:
                    gata = false;
                    break;
            }
        }
//        generateMap();
//
//        printColoredMap();
//
//        dijkstra(25, 25, 3);
    }
}