import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelPlay extends JPanel implements ActionListener {
    private JButton play;
    LinkedList<Integer> commandes;
    Personnage person;
    PanelButton panBut;
    PanelUser panUser;
    PanelTerrain terrePan;
    PanelConsigne consigne;
    PanelScore panScore;
    JButton reset;
    Timer timer;
    int nb;

    public PanelPlay(PanelButton butts, Personnage p, PanelTerrain panTerre, PanelConsigne cons, PanelScore ps, PanelUser pu) {
        panScore = ps;
        panUser = pu;
        consigne = cons;
        person = p;
        terrePan = panTerre;
        panBut = butts;
        timer = new Timer(500, this);
        // Recevoir le tableau de commande
        commandes = panBut.commande;
        // Creer le bouton "Play"
        play = new JButton("Play");
        play.setBounds(10, 5, 100, 40);
        reset = new JButton("Reset");
        reset.setBounds(180, 5, 100, 40);
        this.add(play);
        add(reset);
        play.addActionListener((ActionEvent e) -> {
            play.setVisible(false);
            System.out.println("Executing!");
            nb = 0;
            timer.start();

        });
        reset.addActionListener((ActionEvent e) -> {
            reset();
        });

    }

    public void reset() {
        System.out.println("Resetting!");
        play.setVisible(true);
        // Reset player
        person.reset();
        // Effacer les commandes
        panBut.commande.clear();
        // Reset la boussole
        panUser.chooseCompass(person.t.dirD);
        // Repaint les elements
        consigne.repaint();
        panUser.repaint();
        terrePan.repaint();
        consigne.repaint();
        panScore.repaint();
    }

    public void step_display(){

    switch (commandes.get(nb)){
            case 1: person.avance();
                break;
            case 2:
                person.collect();
                break;
            case 3: person.gauche();
                break;
            case 4: person.droite();
                break;
            default: break;
        }
        terrePan.repaint();
        consigne.repaint();
        panScore.repaint();
    }

    //pour le timer uniquement
    public void actionPerformed(ActionEvent e) {
        if (nb>commandes.size()-1 && commandes!=null) {
            System.out.println("should stop");
            timer.stop();
        }

        if (nb <= commandes.size()-1 && commandes != null) {
            System.out.println("commande nb : "+nb);
            System.out.println("repainting");
            step_display();
            System.out.println("finished repainting");
            nb++;

        }

    }


}
