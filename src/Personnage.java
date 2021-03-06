import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
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
    boolean end;
    JavPlay playWindow;
    Welcome welcome;

    public Personnage (Terrain terre){
        t = terre;
        end = false;
        scoreMax = t.scoreMax;
        map = t.map;
        // Recopier le plan du terrain
        map_org = new int[map.length][map[0].length];
        map_mod = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 4) {
                    map_mod[i][j] = 0;
                } else {
                    map_mod[i][j] = map[i][j];
                }
                map_org[i][j] = map[i][j];
            }
        }
        // Chercher la position de depart (case no 4)
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
        //System.out.println("Checking");
        //System.out.println("old position: x = " + px + ". py = " + py + " , dir = " + dir + " , map = " + map_mod[py][px]);
        int game_over_dialogue;

        switch (dir) {
            case 0: //nord
                if (py - 1 >= 0) {
                    if (map[py - 1][px] != 3) {
                        py--;
                    }
                } else {
                    System.out.println("Out of boundaries !");
                    JOptionPane.showMessageDialog(null, "You are out of boundaries !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2: //sud
                if (py + 1 < map.length) {
                    if (map[py + 1][px] != 3) {
                        py++;
                    }
                } else {
                    System.out.println("Out of boundaries !");
                    JOptionPane.showMessageDialog(null, "You are out of boundaries !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 1: //est
                if (px + 1 < map[0].length) {
                    if (map[py][px + 1] != 3) {
                        px++;
                    }
                } else {
                    System.out.println("Out of boundaries !");
                    JOptionPane.showMessageDialog(null, "You are out of boundaries !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3: //ouest
                if (px - 1 >= 0) {
                    if (map[py][px - 1] != 3) {
                        px--;
                    }
                } else {
                    System.out.println("Out of boundaries !");
                    JOptionPane.showMessageDialog(null, "You are out of boundaries !", "Error", JOptionPane.ERROR_MESSAGE);
                }
            default:
                break;
        }
        map[py][px] = 4;
        if (map_mod[oldY][oldX] == 0) { // Si la case ancienne est juste l'herbe || OU la case de depart
            map[oldY][oldX] = 0;
        } else {
            map[oldY][oldX] = map_mod[oldY][oldX];
        }
        switch (map_mod[py][px]) {
            case 1:
                if (score == scoreMax) {
                    t.fini = true; // Si on atteint la case finale
                    game_over_dialogue = JOptionPane.showConfirmDialog(null, "Congratulations ! You have finished this level, do you want to go to the next ?\n Press 'yes' to go to the next, 'no' to go back to " +
                            "main menu", "Level Finished", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (game_over_dialogue == JOptionPane.YES_OPTION) {
                        end = true;
                    }
                    if (game_over_dialogue ==JOptionPane.NO_OPTION) {
                        System.out.println("closing the windiw level");
                        playWindow.setVisible(false);
                        System.out.println("resetting");
                        playWindow.reset();
                        System.out.println("opening the menu");
                        welcome.setVisible(true);
                    }
                    //if (game_over_dialogue == JO)

                } else {
                    System.out.println("Pas fini car pas assez de diamants");
                    JOptionPane.showMessageDialog(null, "Pas fini car pas assez de diamants", "Error", JOptionPane.ERROR_MESSAGE);
                    playWindow.reset();
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
//        System.out.println("Checking");
//        System.out.println("New position: px = " + px + ". py = " + py + " , dir = " + dir);
//        System.out.println("gameover : " +t.fini);
//        System.out.println("type de case :" + map_mod[py][px]);
//        System.out.println();

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
            System.out.println("It's a diamond! Collecting...");
            System.out.println("type de case :" + map_mod[py][px]);
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
                if (map[i][j] == 4) {
                    map_mod[i][j] = 0;
                } else {
                    map_mod[i][j] = map_org[i][j];
                }
            }
        }
        // Set player's score to 0
        score = 0;
        // Set fini to false
        t.fini = false;
    }

    @Override
    public String toString() {
        return "Personnage{" + "px=" + px + ", py=" + py + ", dir=" + dir + ", t=" + t + ", map=" + Arrays.toString(map) + ", map_org=" + Arrays.toString(map_org) + ", score=" + score + ", scoreMax=" + scoreMax + '}';
    }
}

