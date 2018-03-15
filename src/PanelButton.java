import javax.swing.*;
import java.util.ArrayList;

public class PanelButton extends JFrame{
    private JButton avc;
    private JButton coll;
    private JButton turnr;
    private JButton turnl;
    private JButton delete;
    private ArrayList<Integer> commande;

    public PanelButton(){
        commande = new ArrayList<Integer>();
        avc = new JButton("Avancer"); //1
        coll = new JButton("Collecter"); //2
        turnr = new JButton("TournerGauche"); //3
        turnl = new JButton("TournerDroite"); //4
        delete = new JButton("Back"); //5
        avc.setBounds(10,5,40,20);
        coll.setBounds(10,75,40,20);
        turnr.setBounds(430,5,40,20);
        turnl.setBounds(430,75,40,20);
        delete.setBounds(60,40,40,20);
        this.add(avc);
        this.add(coll);
        this.add(turnr);
        this.add(turnl);
        this.add(delete);

        avc.addActionListener(e -> commande.add(1));
        coll.addActionListener(e -> commande.add(2));
        turnr.addActionListener(e -> commande.add(3));
        turnl.addActionListener(e -> commande.add(4));
        delete.addActionListener(e -> commande.add(5));

    }
}
