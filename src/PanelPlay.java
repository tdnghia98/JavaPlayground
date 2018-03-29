import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelPlay extends JPanel {
    private JButton play;
    LinkedList<Integer> commandes;
    Personnage person;
    PanelUser panUser;
    PanelTerrain terrePan;
    PanelConsigne consigne;
    PanelScore panScore;
    JButton reset;

    public PanelPlay(PanelButton butts, Personnage p, PanelTerrain panTerre, PanelConsigne cons, PanelScore ps, PanelUser pu) {
        panScore = ps;
        panUser = pu;
        consigne = cons;
        person = p;
        terrePan = panTerre;
        // Recevoir le tableau de commande
        commandes = butts.commande;
        // Creer le bouton "Play"
        play = new JButton("Play");
        play.setBounds(10, 5, 60, 40);
        reset = new JButton("Reset");
        reset.setBounds(220, 5, 60, 40);
        this.add(play);
        add(reset);
        play.addActionListener((ActionEvent e) -> {
            System.out.println("Executing!");
            for (int i : commandes) {
                switch (i) {
                    case 1: p.avance();
                        break;
                    case 2:
                        p.collect();
                        break;
                    case 3: p.gauche();
                        break;
                    case 4: p.droite();
                        break;
                    default: break;
                }
                terrePan.repaint();
                consigne.repaint();
                panScore.repaint();
            }
        });
        reset.addActionListener((ActionEvent e) -> {
            System.out.println("Resetting!");
            // Reset
            p.reset();
            // Effacer les commandes
            butts.commande.clear();
            // Repaint les elements
            consigne.repaint();
            panUser.repaint();
            terrePan.repaint();
            consigne.repaint();
            panScore.repaint();
        });
    }


}
