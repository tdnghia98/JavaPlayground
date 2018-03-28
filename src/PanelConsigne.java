import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelConsigne extends JPanel{
    JTextArea consigne;
    JScrollPane con_s;
    Personnage p;

    public PanelConsigne(Personnage person) {
        p = person;
        consigne = new JTextArea("But : collecter tous les diaments et atteindre la case rouge\nDirection: " + p.getDir());
        con_s = new JScrollPane(consigne);
        con_s.setBounds(10,10,300,70);
        add(con_s);
    }

    public void paintComponent(Graphics g) {
        consigne.setText("But : collecter tous les diaments et atteindre la case rouge\nDirection: " + p.getDir());
    }
}
