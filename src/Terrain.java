public class Terrain {
    Level l;
    public int[][] map;  // Le plan du terrain
    boolean fini = false;
    int scoreMax;
    int nbCai;
    int nbDia;
    int pDx;    // Position de depart x
    int pDy;    // Position de depart y
    int dirD;   // Direction de depart

    public Terrain(Level l) {
        /* 0: case vide
        1: case final
        2: diamants
        3: caillou
        4: personnage
        */
        this.l = l;
        map = l.map;
        scoreMax = l.diamond; // =nb Diamants
        nbCai = l.caillou;
        pDx = 0;
        pDy = 0;
        dirD = 2;
    }
}
