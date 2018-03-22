import javax.swing.*;
import java.awt.*;

public class PanelTerrain extends JPanel {
    Terrain t;
    private int[][] map;

    public PanelTerrain (Terrain terre) {
        t = terre;
        map = terre.map;

    }

    public void paint (Graphics g) {
        // Dessiner le plan du terrain
        int carre_cote = 50;    // La taille d'une case
        for (int i  = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // On dessine d'abord tout les case
                g.fillRect(i*carre_cote, j*carre_cote,carre_cote,carre_cote);
                // On dessine ensuite des objets

                switch (map[i][j]) {    // Taille d'un carre: 50x50 px
                    case 1: g.setColor(Color.RED); // La case finale
                        g.fillRect(i*carre_cote, j*carre_cote,carre_cote,carre_cote);
                        g.setColor(Color.green);    // Remettre le vert pour les cases
                        break;
                    case 2: g.setColor(Color.CYAN); // Le diamant
                        g.fillRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        g.setColor(Color.green);
                        break;
                    case 3: g.setColor(Color.GRAY); // Le caillou
                        g.fillRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        g.setColor(Color.green);
                        break;
                    case 4: g.setColor(Color.PINK); // Le personnage
                        g.fillRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        g.setColor(Color.green);
                        break;

                }
            }
        }

    }

}
