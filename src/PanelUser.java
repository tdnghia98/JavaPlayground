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


    public PanelUser(PanelButton butts){
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

        if (p.getDir() == nord) { // boussole nord
            imageBNORD.setIcon(new ImageIcon("./graph/BOUSSOLENORD.png"));
            imageBNORD.setBounds();
        } else if (p.getDir() == sud) { // boussole sud
            imageBSUD.setIcon(new ImageIcon("./graph/BOUSSOLESUD.png"));
            imageBSUD.setBounds();
        } else if (p.getDir() == est) { // boussole est
            imageBEST.setIcon(new ImageIcon("./graph/BOUSSOLEEST.png"));
            imageBEST.setBounds();
        } else if (p.getDir() == ouest) { // boussole ouest
            imageBOUEST.setIcon(new ImageIcon("./graph/BOUSSOLEOUEST.png"));
            imageBOUEST.setBounds();
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
