package utilitati;

import joc.Pozitie;

import static buiders.MapGenerator.getVizibilitateInXY;
import static java.lang.Math.abs;

public class Utilitati {
    public static boolean Bresenham(Pozitie pos1, Pozitie pos2, float vizibilitateRamasa) {
        int x1 = pos1.getX(), y1 = pos1.getY(), x2 = pos2.getX(), y2 = pos2.getY();

        int itt = 1;

        if (abs(x2 - x1) > abs(y2 - y1)) {
            int m_new = 2 * abs(y2 - y1);
            int slope_error_new = m_new - 2 * abs(x2 - x1);

            if (x2 < x1) {
                itt = -1;
            }

            for (int x = x1, y = y1; x - x2 != itt; x += itt) {
                vizibilitateRamasa = (vizibilitateRamasa - 1) * getVizibilitateInXY(x, y) / 100;
                System.out.printf("\033[%d;%dH", x, y);

                if (vizibilitateRamasa < 1){
                    return false;
                }
                // Add slope to increment angle formed
                slope_error_new += m_new;

                // Slope error reached limit, time to
                // increment y and update slope error.
                if (slope_error_new >= 0) {
                    if (y1 < y2) {
                        y++;
                    } else {
                        y--;
                    }
                    slope_error_new -= 2 * abs(x2 - x1);
                }
            }
        } else {
            int m_new = 2 * abs(x2 - x1);
            int slope_error_new = m_new - 2 * abs(y2 - y1);
            System.out.println("aici");
            if (y2 < y1) {
                itt = -1;
            }

            for (int x = x1, y = y1; y - y2 != itt; y += itt) {
                vizibilitateRamasa = (vizibilitateRamasa - 1) * getVizibilitateInXY(x, y) / 100;

                System.out.printf("\033[%d;%dH", x, y);

                if (vizibilitateRamasa < 1){
                    return false;
                }

                // Add slope to increment angle formed
                slope_error_new += m_new;

                // Slope error reached limit, time to
                // increment y and update slope error.
                if (slope_error_new >= 0) {
                    if (x1 < x2) {
                        x++;
                    } else {
                        x--;
                    }
                    slope_error_new -= 2 * abs(y2 - y1);
                }
            }
        }

        return true;
    }

    // This code is contributed by Anant Agarwal.
}
