import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelUser extends JPanel {
    JTextArea uText;
    JScrollPane uScroll;
    LinkedList<Integer> commandes;
    String commandesAffiche;
    Personnage person;
    JLabel imageBNord;
    JLabel imageBEst;
    JLabel imageBSud;
    JLabel imageBOuest;

    public PanelUser(PanelButton butts, Personnage p) {

        person = p;
        commandes = butts.commande;
        uText = new JTextArea();
        uScroll = new JScrollPane(uText);
        uScroll.setBounds(5,5,200,300);
        add(uScroll);


        imageBNord = new JLabel();
        imageBEst = new JLabel();
        imageBSud = new JLabel();
        imageBOuest = new JLabel();
        add(imageBNord);
        add(imageBEst);
        add(imageBSud);
        add(imageBOuest);
        setLayout(null);

        switch (person.dir) {
            case 0: //nord
                imageBNord.setIcon(new ImageIcon("./graph/BOUSSOLENORD.png"));
                imageBNord.setBounds(150, 150, 150, 150);
                break;
            case 1: //est
                imageBEst.setIcon(new ImageIcon("./graph/BOUSSOLEEST.png"));
                imageBEst.setBounds(150, 150, 150, 150);
                break;
            case 2: //sud
                imageBSud.setIcon(new ImageIcon("./graph/BOUSSOLESUD.png"));
                imageBSud.setBounds(150, 150, 150, 150);
                break;
            case 3: //ouest
                imageBOuest.setIcon(new ImageIcon("./graph/BOUSSOLEOUEST.png"));
                imageBOuest.setBounds(150, 150, 150, 150);
                break;

            default:
                break;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        uText.setText("");
        commandesAffiche = "";
        for (int i : commandes) {
            switch (i) {
                case 1: commandesAffiche += "avance();\n";
                    break;
                case 2: commandesAffiche += "collecter();\n";
                    break;
                case 3: commandesAffiche += "tournerGauche();\n";
                    break;
                case 4: commandesAffiche += "tournerDroite();\n";
                    break;
                default: break;
            }
        }
        uText.setText(commandesAffiche);
    }
}
