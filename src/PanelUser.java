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

    public void paint(Graphics g) {
        commandesAffiche = "";
        for (int i : commandes) {
            switch (i) {
                case 1: commandesAffiche += "avance();\n";
                case 2: commandesAffiche += "collecter();\n";
                case 3: commandesAffiche += "tournerGauche();\n";
                case 4: commandesAffiche += "tournerDroite();\n";
            }
        }
        uText.setText(commandesAffiche);
    }
}
