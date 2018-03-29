import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PanelTerrain extends JPanel {
    Terrain t;
    private int[][] map;
    Personnage person;
    JLabel imageCaseFinale;
    JLabel imageDiamant;
    JLabel imageCaillou;
    JLabel imageNord;
    JLabel imageEst;
    JLabel imageSud;
    JLabel imageOuest;



    public PanelTerrain(Terrain terre, Personnage p) {
        person = p;
        t = terre;
        map = terre.map;
        // Creer et ajouter tous les labels et images
        imageCaseFinale = new JLabel();
        imageDiamant = new JLabel();
        imageCaillou = new JLabel();
        imageNord = new JLabel();
        imageEst = new JLabel();
        imageSud = new JLabel();
        imageOuest = new JLabel();
        add(imageCaseFinale);
        add(imageDiamant);
        add(imageCaillou);
        add(imageNord);
        add(imageEst);
        add(imageOuest);
        setLayout(null);

    }

    public void paintComponent (Graphics g) {
        // Dessiner le plan du terrain
        int carre_cote = 50;    // La taille d'une case
        for (int i  = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                System.out.println("i = " + i + " , j = " +j);
                // On dessine d'abord toutes les cases
                Graphics2D g2 = (Graphics2D) g;
                // Dessiner la bordure
                g2.setStroke(new BasicStroke(5));
                g2.setColor(Color.black);
                g2.drawRect(j * carre_cote, i * carre_cote, carre_cote, carre_cote);
                g2.setColor(Color.green);
                g.fillRect(j * carre_cote, i * carre_cote, carre_cote, carre_cote);
//                System.out.println("Coordonne carre: y = " + i*carre_cote + ", x = " + j*carre_cote );
                // On dessine ensuite des objets
                switch (map[i][j]) {    // Taille d'un carre: 50x50 px
                    case 1:  // La case finale
                        imageCaseFinale.setIcon(new ImageIcon("./graph/Case finale.png"));
                        imageCaseFinale.setBounds(j*50,i*50,50,50);
                        break;
                    case 2:
                        //g.setColor(Color.blue); // Le diamant
                        imageDiamant.setIcon(new ImageIcon("./graph/diamant.png"));
                        imageDiamant.setBounds(j*50,i*50,50,50);
                        break;
                    case 3:  // Le caillou
                        imageCaillou.setIcon(new ImageIcon("./graph/Caillou 1.png"));
                        imageCaillou.setBounds(j*50,i*50,50,50);
                        break;
                    case 4:  // Le personnage
                        switch (person.dir) {
                            case 0: //nord
                                imageNord.setIcon(new ImageIcon("./graph/Bon homme nord.png"));
                                imageNord.setBounds(j*50,i*50,50,50);
                                break;
                            case 1: //est
                                imageEst.setIcon(new ImageIcon("./graph/Bon homme est.png"));
                                imageEst.setBounds(j*50,i*50,50,50);
                                break;
                            case 2: //sud
                                imageSud.setIcon(new ImageIcon("./graph/Bon homme sud.png"));
                                imageSud.setBounds(j*50,i*50,50,50);
                                add(imageSud);
                                break;
                            case 3: //ouest
                                imageOuest.setIcon(new ImageIcon("./graph/Bon homme ouest.png"));
                                imageOuest.setBounds(j*50,i*50,50,50);
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
