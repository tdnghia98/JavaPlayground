public class Terrain {
    public int[][] map;  // Le plan du terrain
    boolean fini = false;
    int scoreMax;
    int pDx;    // Position de depart x
    int pDy;    // Position de depart y
    int dirD;   // Direction de depart
    public Terrain(int sMax) {
        /* 0: case vide
        1: case final
        2: diamants
        3: caillou
        4: personnage
        */
        int[][] m = {
            {4,0,0,0,0,0},
            {0,0,3,0,0,0},
            {2,0,1,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };

        int[][] m2 = {{4, 0, 0, 0, 0, 0}, {3, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0}, {0, 3, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0}, {0, 0, 0, 3, 0, 0}, {0, 0, 0, 0, 3, 2}, {0, 0, 0, 0, 0, 3}, {0, 2, 0, 0, 0, 1}

        };
        map = m;
        scoreMax = sMax;
        pDx = 0;
        pDy = 0;
        dirD = 2;
    }
}
