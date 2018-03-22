import javax.swing.*;

public class PanelScore extends JPanel{
    JLabel scoreLab;
    int score;
    int sMax;
    Personnage p;
    Terrain t;


    public PanelScore (Personnage pers, Terrain terre) {
        p = pers;
        t = terre;
        score = p.score;
        sMax = terre.scoreMax;
        scoreLab = new JLabel(score + "/" + sMax);  // Initialize the score
        scoreLab.setBounds(20,5,30,40);
        add(scoreLab);
    }
}
