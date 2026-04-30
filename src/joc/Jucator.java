package joc;

import buiders.IMC;
import buiders.MisriahArmoury;
import buiders.RHE;
import componente.Titan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jucator {
    private static Jucator instanta = new Jucator();

    private Jucator(){

    }

    public static Jucator getInstance() {
        return instanta;
    }

    private List<Squad> echipe = new ArrayList<>();
    private int alesi;
    private Squad inJoc;

    public void alegeEchipa() {
        if (echipe.isEmpty()){
            return;
        }

        System.out.println("Alege echipa cu care o sa joci:");

        for (int i = 0; i < echipe.size(); i++){
            System.out.println(i + ". " + echipe.get(i).getNume());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            alesi = scanner.nextInt();
            if(alesi >= echipe.size()){
                System.out.println("nu exista!");

                System.out.print("\033[F");
                System.out.print("\033[2K");

                System.out.print("\033[F");
                System.out.print("\033[2K");
            }
            else {
                break;
            }
        }

        for (int i = 0; i < echipe.size() + 2; i++){
            System.out.print("\033[F");
            System.out.print("\033[2K");
        }
    }

    public void modificaEchipa(int pos){
        Scanner scanner = new Scanner(System.in);

        IMC InterstellarManufacturingCorporation = new IMC();
        RHE RothanaHeavyEngineering = new RHE();
        MisriahArmoury MA = new MisriahArmoury();

        while (true) {
            System.out.println("Care componente.Titan vrei sa il schimbi?\n");

            System.out.println(echipe.get(pos));

            System.out.println("Sau 6 daca ai terminat!");

            int option = scanner.nextInt();

            for (int i = 0; i < 40; i++) {
                System.out.print("\033[F");
                System.out.print("\033[2K");
            }

            if (option == 6) {
                break;
            }

            Titan alesul = echipe.get(pos).iaUnitateaX(option - 1);

            boolean gata = true;

            while (gata) {

                System.out.println("Ce componenta doresti sa schimbi?");
                System.out.println("\n" + alesul);
                System.out.println("Sau 6 daca ai terminat!");

                option = scanner.nextInt();

                for (int i = 0; i < 10; i++) {
                    System.out.print("\033[F");
                    System.out.print("\033[2K");
                }

                int alegere;

                switch (option) {
                    case 1:
                        System.out.println(InterstellarManufacturingCorporation);

                        alegere = scanner.nextInt();

                        switch (alegere) {
                            case 1:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildMonarch());
                                break;
                            case 2:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildIon());
                                break;
                            case 3:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildRonin());
                                break;
                            case 4:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildNorthStar());
                                break;
                            case 5:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildScorch());
                                break;
                            default:
                                alesul.setSasiu(InterstellarManufacturingCorporation.buildIon());
                                break;
                        }
                        break;
                    case 2:
                        System.out.println(MA);

                        alegere = scanner.nextInt();

                        switch (alegere) {
                            case 1:
                                alesul.setManaStanga(MA.buildRailgun());
                                break;
                            case 2:
                                alesul.setManaStanga(MA.buildThermiteLouncher());
                                break;
                            case 3:
                                alesul.setManaStanga(MA.buildRevolver());
                                break;
                            case 4:
                                alesul.setManaStanga(MA.buildKnife());
                                break;
                            case 5:
                                alesul.setManaStanga(MA.buildSword());
                                break;
                            default:
                                alesul.setManaStanga(MA.buildRevolver());
                                break;
                        }
                        break;
                    case 3:
                        System.out.println(MA);

                        alegere = scanner.nextInt();

                        switch (alegere) {
                            case 1:
                                alesul.setManaDreapta(MA.buildRailgun());
                                break;
                            case 2:
                                alesul.setManaDreapta(MA.buildThermiteLouncher());
                                break;
                            case 3:
                                alesul.setManaDreapta(MA.buildRevolver());
                                break;
                            case 4:
                                alesul.setManaDreapta(MA.buildKnife());
                                break;
                            case 5:
                                alesul.setManaDreapta(MA.buildSword());
                                break;
                            default:
                                alesul.setManaDreapta(MA.buildRevolver());
                                break;
                        }
                        break;
                    case 4:
                        System.out.println(RothanaHeavyEngineering);

                        alegere = scanner.nextInt();

                        switch (alegere) {
                            case 1:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildShoulderRockets());
                                break;
                            case 2:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildShoulderMinigun());
                                break;
                            case 3:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildLightShield());
                                break;
                            case 4:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildHeavyShield());
                                break;
                            case 5:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildReflectorShield());
                                break;
                            default:
                                alesul.setUtilitateStanga(RothanaHeavyEngineering.buildShoulderRockets());
                                break;
                        }
                        break;
                    case 5:
                        System.out.println(RothanaHeavyEngineering);

                        alegere = scanner.nextInt();

                        switch (alegere) {
                            case 1:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildShoulderRockets());
                                break;
                            case 2:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildShoulderMinigun());
                                break;
                            case 3:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildLightShield());
                                break;
                            case 4:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildHeavyShield());
                                break;
                            case 5:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildReflectorShield());
                                break;
                            default:
                                alesul.setUtilitateDreapta(RothanaHeavyEngineering.buildLightShield());
                                break;
                        }
                        break;
                    default:
                        gata = false;
                        break;
                }

                if (gata) {
                    for (int i = 0; i < 7; i++) {
                        System.out.print("\033[F");
                        System.out.print("\033[2K");
                    }
                }
            }
        }
    }

    public void creazaEchipa(){
        Squad nouaEchipa = new Squad();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cum se v-a numi echipa:");

        nouaEchipa.setNume(scanner.next());

        System.out.print("\033[F");
        System.out.print("\033[2K");

        System.out.print("\033[F");
        System.out.print("\033[2K");

        echipe.add(nouaEchipa);

        modificaEchipa(echipe.size() - 1);
    }

    @Override
    public String toString() {
        String raspuns = "";

        for (int i = 0; i < echipe.size(); i++){
            raspuns += i + ". " + echipe.get(i).getNume() + "\n";
        }

        return raspuns;
    }

    public void incepeJoc(){
        try {
            inJoc = (Squad) echipe.get(alesi).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Squad getInJoc() {
        return inJoc;
    }
}
