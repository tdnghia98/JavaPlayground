import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelButton extends JPanel{
    private JButton avc;
    private JButton coll;
    private JButton turnr;
    private JButton turnl;
    private JButton delete;
    public LinkedList<Integer> commande;
    PanelUser panUser;

    public PanelButton(){
        commande = new LinkedList<Integer>();
        avc = new JButton("Avancer"); //1
        coll = new JButton("Collecter"); //2
        turnr = new JButton("TurnR"); //3
        turnl = new JButton("TurnL"); //4
        delete = new JButton("Back"); //5
        avc.setBounds(10, 5, 60, 20);
        coll.setBounds(10, 75, 60, 20);
        turnr.setBounds(130, 5, 60, 20);
        turnl.setBounds(130, 75, 60, 20);
        delete.setBounds(60, 40, 60, 20);
        this.add(avc);
        this.add(coll);
        this.add(turnr);
        this.add(turnl);
        this.add(delete);

        avc.addActionListener(e -> {
            commande.add(1);
            panUser.repaint();
        });
        coll.addActionListener(e -> {
            commande.add(2);
            panUser.repaint();
        });
        turnr.addActionListener(e -> {
            commande.add(3);
            panUser.repaint();
        });
        turnl.addActionListener(e -> {
            commande.add(4);
            panUser.repaint();
        });
        delete.addActionListener(e -> {
            if (commande.size() > 0) {
                commande.remove(commande.size() - 1);
                panUser.repaint();
            }
        });
    }

}
