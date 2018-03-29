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
                    case 1:  // La case finale
                        JLabel imageCaseFinale = new JLabel();
                        imageCaseFinale.setIcon(new ImageIcon("./graph/Case finale.png"));
                        imageCaseFinale.setBounds(j*50,i*50,50,50);
                        add(imageCaseFinale);
                        break;
                    case 2:
                        //g.setColor(Color.blue); // Le diamant
                        JLabel imageDiamant = new JLabel();
                        imageDiamant.setIcon(new ImageIcon("./graph/diamant.png"));
                        imageDiamant.setBounds(j*50,i*50,50,50);
                        add(imageDiamant);
                        break;
                    case 3:  // Le caillou
                        JLabel imageCaillou = new JLabel();
                        imageCaillou.setIcon(new ImageIcon("./graph/Caillou 1.png"));
                        imageCaillou.setBounds(j*50,i*50,50,50);
                        add(imageCaillou);
                        break;
                    case 4:  // Le personnage
                        switch (person.dir) {
                            case 0: //nord
                                JLabel imageNord = new JLabel();
                                imageNord.setIcon(new ImageIcon("./graph/Bon homme nord.png"));
                                imageNord.setBounds(j*50,i*50,50,50);
                                add(imageNord);
                                break;
                            case 1: //est
                                JLabel imageEst = new JLabel();
                                imageEst.setIcon(new ImageIcon("./graph/Bon homme est.png"));
                                imageEst.setBounds(j*50,i*50,50,50);
                                add(imageEst);
                                break;
                            case 2: //sud
                                JLabel imageSud = new JLabel();
                                imageSud.setIcon(new ImageIcon("./graph/Bon homme sud.png"));
                                imageSud.setBounds(j*50,i*50,50,50);
                                add(imageSud);
                                break;
                            case 3: //ouest
                                JLabel imageOuest = new JLabel();
                                imageOuest.setIcon(new ImageIcon("./graph/Bon homme ouest.png"));
                                imageOuest.setBounds(j*50,i*50,50,50);
                                add(imageOuest);
                                break;

                        }
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
