public class Terrain {
    public int[][] map;  // Le plan du terrain
    final int taille = 4;   // La taille du terrain
    boolean fini = false;

    public Terrain() {
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
        map = m;
    }
}
