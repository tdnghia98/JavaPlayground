import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPlay extends JPanel {
    private JButton play;
    ArrayList<Integer> commandes;
    Personnage person;
    PanelTerrain terrePan;

    public PanelPlay(PanelButton butts, Personnage p, PanelTerrain panTerre){
        person = p;
        terrePan = panTerre;
        // Recevoir le tableau de commande
        commandes = butts.commande;

        // Creer le bouton "Play"
        play = new JButton("Play");
        play.setBounds(120,5,60,40);
        this.add(play);
        play.addActionListener((ActionEvent e) -> {
            System.out.println("Executing!");
            for (int i : commandes) {
                switch (i) {
                    case 1: p.avance();
                    case 2: p.avanceAndCollect();
                    case 3: p.gauche();
                    case 4: p.droite();
                }
                terrePan.repaint();
            }
        });

    }


}
