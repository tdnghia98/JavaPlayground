import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PanelTerrain extends JPanel {
    Terrain t;
    private int[][] map;
    int[][] map_mod;
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
        map_mod = p.map_mod;
        // Creer et ajouter tous les labels et images
        imageCaseFinale = new JLabel();
        imageDiamant = new JLabel();
        imageCaillou = new JLabel();
        imageNord = new JLabel();
        imageEst = new JLabel();
        imageSud = new JLabel();
        imageOuest = new JLabel();

        imageCaseFinale.setIcon(new ImageIcon("./graph/Case finale.png"));
        imageDiamant.setIcon(new ImageIcon("./graph/diamant.png"));
        imageCaillou.setIcon(new ImageIcon("./graph/Caillou 1.png"));
        imageNord.setIcon(new ImageIcon("./graph/Bon homme nord.png"));
        imageEst.setIcon(new ImageIcon("./graph/Bon homme est.png"));
        imageSud.setIcon(new ImageIcon("./graph/Bon homme sud.png"));
        imageOuest.setIcon(new ImageIcon("./graph/Bon homme ouest.png"));
        setLayout(null);

    }

    public void paintComponent (Graphics g) {
        remove(imageCaseFinale);
        remove(imageDiamant);


        remove(imageEst);
        remove(imageOuest);
        remove(imageNord);
        remove(imageSud);
        // Dessiner le plan du terrain
        int carre_cote = 50;    // La taille d'une case
        int[][] map_temp = new int[map.length][map[0].length];
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
                if (map[i][j] == 4 && map_mod[i][j] == 0) {
                    map_temp = map;
                    //System.out.println("Drawing with map");
                } else {
                    map_temp = map_mod;
                    //System.out.println("Drawing with map_mod");
                }
                switch (map_temp[i][j]) {    // Taille d'un carre: 50x50 px
                    case 1:  // La case finale
                        imageCaseFinale.setBounds(j * 50, i * 50, 50, 50);
                        add(imageCaseFinale);
                        break;
                    case 2:
                        //g.setColor(Color.blue); // Le diamant
                        imageDiamant.setBounds(j * 50, i * 50, 50, 50);
                        add(imageDiamant);
                        break;
                    case 3:  // Le caillou
                        imageCaillou.setBounds(j * 50, i * 50, 50, 50);
                        add(imageCaillou);
                        break;
                    case 4:  // Le personnage
                        switch (person.dir) {
                            case 0: //nord
                                imageNord.setBounds(j * 50, i * 50, 50, 50);
                                add(imageNord);
                                break;
                            case 1: //est
                                imageEst.setBounds(j * 50, i * 50, 50, 50);
                                add(imageEst);
                                break;
                            case 2: //sud
                                imageSud.setBounds(j * 50, i * 50, 50, 50);
                                add(imageSud);
                                break;
                            case 3: //ouest
                                imageOuest.setBounds(j * 50, i * 50, 50, 50);
                                add(imageOuest);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }


//                System.out.println("map: " + map[i][j] + ", Color: " + g.getColor());
                g.setColor(Color.green);    // Remettre le vert pour les cases
            }
        }

    }

}
