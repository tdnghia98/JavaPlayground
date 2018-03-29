import java.util.Arrays;

public class Personnage {
    int px; // Position x
    int py; // Position y
    int dir;   // La direction
    Terrain t;
    int[][] map;
    final int[][] map_org;
    int[][] map_mod;
    int score = 0;
    int scoreMax;

    public Personnage (Terrain terre){
        t = terre;
        scoreMax = t.scoreMax;
        map = t.map;
        // Recopier le plan du terrain
        map_org = new int[map.length][map[0].length];
        map_mod = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map_org[i][j] = map[i][j];
                map_mod[i][j] = map[i][j];
            }
        }
        // Chercher la position de depart (case no 5)
        for (int i = 0; i < map_org.length; i++) {
            for (int j = 0; j < map_org[0].length; j++) {
                if (map_org[i][j] == 4) {
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
        dir = 2;
    }

    public void checkDevant() {
        int oldX = px;
        int oldY = py;
        int oldCase = map[py][px];
        System.out.println("Checking");
        System.out.println("Actual position: x = " + px + ". py = " + py + " , dir = " + dir);
        switch (dir) {
            case 0: //nord
                if (py - 1 >= 0) {
                    if (map[py - 1][px] != 3) {
                        py--;
                    }
                }
                break;
            case 2: //sud
                if (py + 1 < map.length) {
                    if (map[py + 1][px] != 3) {
                        py++;
                    }
                }
                break;
            case 1: //est
                if (px + 1 < map[0].length) {
                    if (map[py][px + 1] != 3) {
                        px++;
                    }
                }
                break;
            case 3: //ouest
                if (px - 1 >= 0) {
                    if (map[py][px - 1] != 3) {
                        px--;
                    }
                }
            default:
                break;
        }
        map[py][px] = 4;
        if (map_mod[oldY][oldX] == 0 || map_mod[oldY][oldX] == 4) { // Si la case ancienne est juste l'herbe || OU la case de depart
            map[oldY][oldX] = 0;
        } else {
            map[oldY][oldX] = map_mod[oldY][oldX];
        }
        switch (map[py][px]) {
            case 1:
                if (score == scoreMax) {
                    t.fini = true; // Case finale
                } else {
                    System.out.println("Pas fini car pas assez de diamants");
                }
                break;
            case 2: // Diamond
                break;
            case 3: // Caillou
                break;
            default:
                map[py][px] = 4;    // Colorer la case en couleur du personnage
                break;
        }

    }

    public void avance() {
        checkDevant();
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

    public void collect() {
        System.out.println("Collect method");
        if (map_mod[py][px] == 2) { // Verifier si c'est bien un diamant
            System.out.println("It's a diamond!");
            score++;   // Augmenter la note
            map_mod[py][px] = 0; // Diamant collecte
        }

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

    public void reset() {
        // Remettre la position et la direction aux celles de depart
        px = t.pDx;
        py = t.pDy;
        dir = t.dirD;
        // Reset le plan du terrain
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = map_org[i][j];
            }
        }
        // Set player's score to 0
        score = 0;
        // Set fini to false
        t.fini = false;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "px=" + px +
                ", py=" + py +
                ", dir=" + dir +
                ", t=" + t +
                ", map=" + Arrays.toString(map) +
                ", map_org=" + Arrays.toString(map_org) +
                ", score=" + score +
                ", scoreMax=" + scoreMax +
                '}';
    }
}

