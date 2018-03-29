import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PanelTerrain extends JPanel {
    Terrain t;
    private int[][] map;
    Personnage person;


    public PanelTerrain(Terrain terre, Personnage p) {
        person = p;
        t = terre;
        map = terre.map;
        setLayout(null);
    }

    public void paintComponent (Graphics g) {
        // Dessiner le plan du terrain
        int carre_cote = 50;    // La taille d'une case
        g.setColor(Color.green);
        for (int i  = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                System.out.println("i = " + i + " , j = " +j);
                // On dessine d'abord toutes les cases

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(5));
                g2.setColor(Color.black);
                g2.drawRect(j * carre_cote, i * carre_cote, carre_cote, carre_cote);
                g2.setColor(Color.green);
                g.fillRect(j * carre_cote, i * carre_cote, carre_cote, carre_cote);
//                System.out.println("Coordonne carre: y = " + i*carre_cote + ", x = " + j*carre_cote );
                // On dessine ensuite des objets
                switch (map[i][j]) {    // Taille d'un carre: 50x50 px
                    case 1: g.setColor(Color.RED); // La case finale
                        break;
                    case 2:
                        //g.setColor(Color.blue); // Le diamant
                        JLabel imageDiamant = new JLabel();
                        imageDiamant.setIcon(new ImageIcon("./graph/diamant.png"));
                        imageDiamant.setBounds(j*50,i*50,50,50);
                        add(imageDiamant);
                        break;
                    case 3: g.setColor(Color.GRAY); // Le caillou
                        break;
                    case 4: g.setColor(Color.PINK); // Le personnage
                        break;
                    default:
                        break;
                }
                g.fillRect(j * carre_cote + 5, i * carre_cote + 5, 40, 40);
//                System.out.println("map: " + map[i][j] + ", Color: " + g.getColor());
                g.setColor(Color.green);    // Remettre le vert pour les cases
            }
        }

    }

}
