import java.util.Random;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.sqrt;

public class MapGenerator {
    private final int SIZE = 50;
    private Random rand = new Random();
    private int vizibilitate[][] = new int[SIZE][SIZE], mobilitate[][] = new int[SIZE][SIZE];

    final String RESET = "\u001B[0m";

    final String BG_BRIGHT_GREEN = "\u001B[102m";

    final String BG_BLUE = "\u001B[44m";
    final String BG_BROWN = "\u001B[48;5;94m";

    final String BG_BLACK = "\u001B[40m";
    final String BG_DEFAULT = "\u001B[47m";

    public void generateMap(){
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                vizibilitate[x][y] = 100;
                mobilitate[x][y] = 66;
            }
        }

        for (int i = 0; i < 4; i++) {
            int cx = rand.nextInt(SIZE);
            int cy = rand.nextInt(SIZE);
            int radius = 5 + rand.nextInt(8);

            for (int x = max(cx - radius, 0); x < min(cx + radius + 1, SIZE); x++) {
                for (int y = max(0, cy - radius); y < min(cy + radius + 1, SIZE); y++) {
                    if (sqrt((cx - x) * (cx - x) + (cy - y) * (cy - y)) < radius) {
                        vizibilitate[x][y] = 75;
                        mobilitate[x][y] = 25;
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            int cx = rand.nextInt(SIZE);
            int cy = rand.nextInt(SIZE);
            int radius = 5 + rand.nextInt(8);

            for (int x = max(cx - radius, 0); x < min(cx + radius + 1, SIZE); x++) {
                for (int y = max(0, cy - radius); y < min(cy + radius + 1, SIZE); y++) {
                    if (sqrt((cx - x) * (cx - x) + (cy - y) * (cy - y)) < radius) {
                        mobilitate[x][y] = 0;
                        vizibilitate[x][y] = 100;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int cx = rand.nextInt(SIZE);
            int cy = rand.nextInt(SIZE);
            int radius = 5 + rand.nextInt(6);

            for (int x = max(cx - radius, 0); x < min(cx + radius + 1, SIZE); x++) {
                for (int y = max(0, cy - radius); y < min(cy + radius + 1, SIZE); y++) {
                    if (sqrt((cx - x) * (cx - x) + (cy - y) * (cy - y)) < radius && rand.nextDouble() < 0.15) {
                        vizibilitate[x][y] = 0;
                        mobilitate[x][y] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            int y = rand.nextInt(SIZE);
            for (int x = 0; x < SIZE; x++) {
                vizibilitate[x][y] = 100;
                mobilitate[x][y] = 100;
                if (rand.nextDouble() < 0.3) y += rand.nextInt(3) - 1;
                if (y >= SIZE) y = SIZE - 1;
                if (y < 0) y = 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            int x = rand.nextInt(SIZE);
            for (int y = 0; y < SIZE; y++) {
                vizibilitate[x][y] = 100;
                mobilitate[x][y] = 100;
                if (rand.nextDouble() < 0.2) x += rand.nextInt(3) - 1;
                if (x >= SIZE) x = SIZE - 1;
                if (x < 0) x = 0;
            }
        }

    }

    char symbol(int t) {
        return switch (t) {
            case 0 -> 'X';
            case 106 -> ' ';
            case 110 -> '_';
            case 77 -> 'f';
            case 100 -> '~';
            default -> '?';
        };
    }

    public void printColoredMap() {

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {

                String color = getColor(vizibilitate[x][y]+mobilitate[x][y]/10);

                char simbol = symbol(vizibilitate[x][y]+mobilitate[x][y]/10);
                // "  " = tile mai mare, arată mai bine
                System.out.print(color + " " + simbol + " " + RESET);
            }
            System.out.println();
        }
    }

    String getColor(int tile) {
        return switch (tile) {
            case 106 -> BG_DEFAULT;
            case 110 -> BG_BROWN;
            case 77 -> BG_BRIGHT_GREEN;
            case 100 -> BG_BLUE;
            case 0 -> BG_BLACK;
            default -> RESET;
        };
    }
}