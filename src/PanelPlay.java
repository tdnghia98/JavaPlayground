import javax.swing.*;
import java.awt.event.ActionListener;

public class PanelPlay extends JFrame implements ActionListener {
    private JButton play;

    public PanelPlay(){

        play = new JButton("Play");
        play.setBounds(120,5,60,40);
        this.add(play);
        play.addActionListener(e -> System.out.println("Exécuter les méthodes"));


    }


}
