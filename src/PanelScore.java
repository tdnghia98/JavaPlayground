import javax.swing.*;
import java.awt.*;

public class PanelScore extends JPanel{
    JLabel scoreLab;
    int sMax;
    Personnage p;
    Terrain t;
    JLabel diamant;


    public PanelScore (Personnage pers, Terrain terre) {
        p = pers;
        t = terre;
        sMax = terre.scoreMax;
        scoreLab = new JLabel(p.score + "/" + sMax);  // Initialize the score
        scoreLab.setBounds(20,5,30,40);
        add(scoreLab);
        diamant = new JLabel();
        diamant.setIcon(new ImageIcon("./graph/mini-diamant.png"));
        diamant.setBounds(40, 5, 30, 40);
        add(diamant);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        scoreLab.setText(p.score + "/" + sMax);
    }
}
