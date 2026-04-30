package joc;

import componente.Titan;

public class Inamic extends Titan{
    private Pozitie pos;

    public void ai(){
        Titan tinta = null;

//        for (int i = 0; i < 5; i++){
//            if()
//        }
    }
}

//public class DijkstraGrid {
//
//    // 8 directions: cardinal (cost 1) + diagonal (cost √2)
//    private static final int[][] DIRS = {
//            { 0, -1}, { 0,  1}, {-1,  0}, { 1,  0},  // N S W E
//            {-1, -1}, {-1,  1}, { 1, -1}, { 1,  1}   // diagonals
//    };
//    private static final double SQRT2 = Math.sqrt(2);
//
//    /**
//     * Finds shortest paths from (startX, startY) to every reachable cell.
//     *
//     * @param grid      2-D boolean array; true = passable, false = wall
//     * @param startX    column index of the source cell
//     * @param startY    row index of the source cell
//     * @return          dist[y][x] = shortest distance from start, or
//     *                  Double.MAX_VALUE if unreachable
//     */
//    public static double[][] dijkstra(
//            boolean[][] grid, int startX, int startY) {
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        double[][] dist = new double[rows][cols];
//        for (double[] row : dist) Arrays.fill(row, Double.MAX_VALUE);
//        dist[startY][startX] = 0.0;
//
//        // Min-heap: { distance, x, y }
//        PriorityQueue<double[]> pq = new PriorityQueue<>(
//                Comparator.comparingDouble(e -> e[0])
//        );
//        pq.offer(new double[]{0.0, startX, startY});
//
//        while (!pq.isEmpty()) {
//            double[] cur = pq.poll();
//            double d  = cur[0];
//            int    cx = (int) cur[1];
//            int    cy = (int) cur[2];
//
//            // Skip stale entries
//            if (d > dist[cy][cx]) continue;
//
//            for (int[] dir : DIRS) {
//                int nx = cx + dir[0];
//                int ny = cy + dir[1];
//
//                if (nx < 0 || ny < 0 || nx >= cols || ny >= rows) continue;
//                if (!grid[ny][nx]) continue;  // wall
//
//                // Diagonal move iff both dx and dy are non-zero
//                boolean diagonal = (dir[0] != 0) && (dir[1] != 0);
//                double stepCost = diagonal ? SQRT2 : 1.0;
//                double newDist  = dist[cy][cx] + stepCost;
//
//                if (newDist < dist[ny][nx]) {
//                    dist[ny][nx] = newDist;
//                    pq.offer(new double[]{newDist, nx, ny});
//                }
//            }
//        }
//        return dist;
//    }
//
//    /**
//     * Reconstructs the path from start to (endX, endY).
//     * Requires a separate prev[][] pass — call dijkstraWithPath() below.
//     */
//    public static List<int[]> reconstructPath(
//            int[][][] prev, int startX, int startY,
//            int endX, int endY) {
//
//        LinkedList<int[]> path = new LinkedList<>();
//        int[] cur = {endX, endY};
//        while (cur[0] != startX || cur[1] != startY) {
//            path.addFirst(cur);
//            int[] p = prev[cur[1]][cur[0]];
//            if (p == null) return Collections.emptyList(); // unreachable
//            cur = p;
//        }
//        path.addFirst(new int[]{startX, startY});
//        return path;
//    }
//
//    /** Full version: returns both dist[][] and prev[][][] for path tracing. */
//    public static Object[] dijkstraWithPath(
//            boolean[][] grid, int startX, int startY) {
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        double[][] dist = new double[rows][cols];
//        int[][]   [] prev = new int[rows][cols][];
//        for (double[] row : dist) Arrays.fill(row, Double.MAX_VALUE);
//        dist[startY][startX] = 0.0;
//
//        PriorityQueue<double[]> pq = new PriorityQueue<>(
//                Comparator.comparingDouble(e -> e[0])
//        );
//        pq.offer(new double[]{0.0, startX, startY});
//
//        while (!pq.isEmpty()) {
//            double[] cur = pq.poll();
//            double d  = cur[0];
//            int    cx = (int) cur[1];
//            int    cy = (int) cur[2];
//
//            if (d > dist[cy][cx]) continue;
//
//            for (int[] dir : DIRS) {
//                int nx = cx + dir[0];
//                int ny = cy + dir[1];
//                if (nx < 0 || ny < 0 || nx >= cols || ny >= rows) continue;
//                if (!grid[ny][nx]) continue;
//
//                boolean diagonal = (dir[0] != 0) && (dir[1] != 0);
//                double newDist = dist[cy][cx] + (diagonal ? SQRT2 : 1.0);
//
//                if (newDist < dist[ny][nx]) {
//                    dist[ny][nx] = newDist;
//                    prev[ny][nx] = new int[]{cx, cy};
//                    pq.offer(new double[]{newDist, nx, ny});
//                }
//            }
//        }
//        return new Object[]{dist, prev};
//    }
//}
