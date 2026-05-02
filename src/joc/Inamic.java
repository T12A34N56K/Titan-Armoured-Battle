package joc;

import componente.Titan;

import java.util.*;

public class Inamic extends Titan{
    private Pozitie pos;

    public void ai(){
        Titan tinta = null;

//        for (int i = 0; i < 5; i++){
//            if()
//        }
    }
    private static final int[][] DIRS = {
            { 0, -1}, { 0,  1}, {-1,  0}, { 1,  0},  // N S W E
            {-1, -1}, {-1,  1}, { 1, -1}, { 1,  1}   // diagonals
    };
    private static final double SQRT2 = Math.sqrt(2);


    public static void dijkstra(int startX, int startY, int maxMove) {
        int SIZE = 50;

        HashMap<Pozitie, Double> ramas = new HashMap<>();

        ramas.put(new Pozitie(startX, startY), (double) maxMove);

        PriorityQueue<double[]> pq = new PriorityQueue<>(
                Comparator.comparingDouble(e -> e[0])
        );
        pq.offer(new double[]{(double) maxMove, startX, startY});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            double d  = cur[0];
            int cx = (int) cur[1];
            int cy = (int) cur[2];

            if(d > maxMove) continue;

            for (int[] dir : DIRS) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;

                boolean diagonal = (dir[0] != 0) && (dir[1] != 0);
                double stepCost = diagonal ? SQRT2 : 1.0;
                double newDist  = ramas.getOrDefault(new Pozitie(cx, cy), 0d) - stepCost;

                if (newDist > ramas.getOrDefault(new Pozitie(nx, ny), -0.1d) && newDist >= 0) {
                    ramas.put(new Pozitie(nx, ny), newDist);
                    pq.offer(new double[]{newDist, nx, ny});
                }
            }
        }

        for (var i : ramas.entrySet()){
            System.out.println(i);
        }
    }
}