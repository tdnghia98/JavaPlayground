import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelPlay extends JFrame implements ActionListener {
    private JButton play;

    public PanelPlay(){

        play = new JButton("Play");
        this.add(play);
        play.addActionListener(e -> "Exécuter les méthodes");


    }


}
