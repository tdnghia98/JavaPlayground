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
        g.setColor(Color.green);    // La couleur de la case
        for (int i  = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                // On dessine d'abord tout les case
                g.drawRect(i*carre_cote, j*carre_cote,carre_cote,carre_cote);
                // On dessine ensuite des objets

                switch (map[i][j]) {
                    case 1: g.setColor(Color.RED); // La case finale
                        g.drawRect(i*carre_cote, j*carre_cote,carre_cote,carre_cote);
                        break;
                    case 2: g.setColor(Color.CYAN); // Le diamant
                        g.drawRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        break;
                    case 3: g.setColor(Color.GRAY); // Le caillou
                        g.drawRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        break;
                    case 4: g.setColor(Color.PINK); // Le personnage
                        g.drawRect(i*carre_cote + 5, j*carre_cote + 5,40,40);
                        break;

                }
            }
        }

    }

}
