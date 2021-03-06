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

    int last_old_num;

    public PanelButton(){

        commande = new LinkedList<Integer>();
        avc = new JButton("avance()"); //1
        coll = new JButton("collecter()"); //2
        turnr = new JButton("tournerDroite()"); //4
        turnl = new JButton("tournerGauche()"); //3
        delete = new JButton("back"); //5
        avc.setBounds(10, 5, 100, 20);
        coll.setBounds(10, 75, 100, 20);
        turnr.setBounds(130, 5, 130, 20);
        turnl.setBounds(130, 75, 130, 20);
        delete.setBounds(60, 40, 100, 20);
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

            commande.add(4);


            panUser.PositiveRotation();
            panUser.chooseCompass(panUser.sens);
            panUser.repaint();
        });
        turnl.addActionListener(e -> {

            commande.add(3);


            panUser.NegativeRotation();
            panUser.chooseCompass(panUser.sens);

            panUser.repaint();
        });
        delete.addActionListener(e -> {
            if (commande.size() > 0) {

                if (commande.peekLast() != null) {
                    last_old_num = commande.peekLast();
                    if (last_old_num == 3) {
                        panUser.PositiveRotation();
                        panUser.chooseCompass(panUser.sens);
                    }
                    if (last_old_num == 4) {
                        panUser.NegativeRotation();
                        panUser.chooseCompass(panUser.sens);
                    }
                } else {
                    panUser.sens = 2;
                    panUser.chooseCompass(panUser.sens);
                }
                commande.remove(commande.size() - 1);


                panUser.repaint();
            }
        });

    }

}
