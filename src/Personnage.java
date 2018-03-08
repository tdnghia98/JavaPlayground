public class Personnage {
    int px; // Position x
    int py; // Position y
    int cote;   // La direction
    Terrain t;
    int[][] map;

    public Personnage (Terrain terre){
        t = terre;
        map = t.map;
        // Chercher la position de depart (case no 5)
        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j< map[0].length; j++) {
                if(map[i][j] == 5) {
                    px = j;
                    py = i;
                }
            }
        }

        /* Cote du personnage
        0: nord
        2: sud
        1: est
        3: ouest
         */
        cote = (int) Math.random()*4;

    }

    public void checkDevant (int i) {
        switch (cote) {
            case 0:
                if (map[py-1][px] == i) {
                    py--;
                }
            case 2:
                if (map[py+1][px] == i) {
                    py++;
                }
            case 1:
                if (map[py][px+1] == i) {
                    px++;
                }
            case 3:
                if (map[py][px-1] == i) {
                    px--;
                }
            default:
                break;
        }
        if (map[py][px] == 1) {
            t.fini = true;
        } else {
            map[py][px] = 4;
        }

    }

    public void avance() {
        checkDevant(1);
        checkDevant(0);
    }

    public void gauche() {
        cote--;
        // Au cas ou on fait 0-1
        if (cote == -1) {
            cote = 3;
        }
    }

    public void droite() {
        cote++;
        // Au cas ou on fait 3+1
        if (cote == 4) {
            cote = 0;
        }
    }

    public void collect() {
        checkDevant(1);
    }
}

