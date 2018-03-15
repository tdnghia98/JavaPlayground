import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPlay extends JPanel {
    private JButton play;
    ArrayList<Integer> commandes;

    public PanelPlay(PanelButton butts){
        // Recevoir le tableau de commande
        commandes = butts.commande;
        // Creer le bouton "Play"
        play = new JButton("Play");
        play.setBounds(120,5,60,40);
        this.add(play);
        play.addActionListener(e -> System.out.println("Exécuter les méthodes"));


    }


}
