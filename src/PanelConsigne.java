import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelConsigne extends JPanel{
    JTextArea consigne;
    JScrollPane con_s;
    Personnage p;

    public PanelConsigne(Personnage person) {
        p = person;
        consigne = new JTextArea("But : collecter tous les diamants et atteindre la case rouge\nDirection: " + p.getDir());
        con_s = new JScrollPane(consigne);
        con_s.setBounds(10, 10, 450, 70);
        add(con_s);
    }

    public void paintComponent(Graphics g) {
        consigne.setText("But : collecter tous les diamants et atteindre la case rouge" + "\nProgramme les mouvements de ton personnage pour finir le jeu avec les boutons ci-dessous.\n Attention : Tu dois programmer tous tes mouvements à l'avance ! Sinon il faudra recommencer...\n\n" + "Avancer te permet d'avancer d'une case\n" + "back te permet d'effacer ta commande précédente\n" + "Les boutons tourner permettent de pivoter ton personnage\n" + "Collecter te permet de ramaser un diamant sur la case de ton personnage." + "\n\nDirection du personnage: " + p.getDir());
    }
}
