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
