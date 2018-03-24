public class Personnage {
    int px; // Position x
    int py; // Position y
    int dir;   // La direction
    Terrain t;
    int[][] map;
    int score = 0;

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

        /* dir du personnage
        0: nord
        1: est
        2: sud
        3: ouest
         */
        dir = 0;

    }

    public void checkDevant (int i) {
        int oldX = px;
        int oldY = py;
        if (!((py - 1 < 0 && dir == 0) || (px - 1 < 0 && dir == 3) || (px + 1 >= map[0].length && dir == 1) || (py + 1 >= map.length && dir == 2))) {
            switch (dir) {
                case 0:
                    if (map[py - 1][px] == i) {
                        py--;
                    }
                case 2:
                    if (map[py + 1][px] == i) {
                        py++;
                    }
                case 1:
                    if (map[py][px + 1] == i) {
                        px++;
                    }
                case 3:
                    if (map[py][px - 1] == i) {
                        px--;
                    }
                default:
                    break;
            }
            map[oldY][oldX] = 0;
        }
        if (map[py][px] == 1) {
            t.fini = true;
        } else {
            map[py][px] = 4;
        }

    }

    public void avance() {
        checkDevant(0);
    }

    public void gauche() {
        dir--;
        // Au cas ou on fait 0-1
        if (dir == -1) {
            dir = 3;
        }
    }

    public void droite() {
        dir++;
        // Au cas ou on fait 3+1
        if (dir == 4) {
            dir = 0;
        }
    }

    public void avanceAndCollect() {
        checkDevant(1);
        score ++;
    }

    public String getDir() {
        String s;
        switch (dir) {
            case 0:
                s = "nord";
                break;
            case 1:
                s = "est";
                break;
            case 2:
                s = "sud";
                break;
            case 3:
                s = "ouest";
                break;
            default:
                s = "unknown direction";
                break;
        }
        return s;
    }
}

