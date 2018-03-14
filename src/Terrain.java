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
        5: case depart
         */
        int[][] m = {
            {5,0,0,0},
            {0,0,3,0},
            {2,0,1,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };
        map = m;
    }
}
