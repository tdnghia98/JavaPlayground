public class Main {
    public static void main(String[] args) {
        int[][] m = {
                {4, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0},
                {2, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int[][] m2 = {
                {4, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0},
                {2, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        Level lvl1 = new Level(m, 1, 1);
        Level lvl2 = new Level(m2, 2, 2);
        Terrain terrain = new Terrain(lvl2);
        Personnage p = new Personnage(terrain);
        JavPlay playWindow = new JavPlay(terrain,p);




    }
}
