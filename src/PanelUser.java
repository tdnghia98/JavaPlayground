import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelUser extends JPanel {
    JTextArea uText;
    JScrollPane uScroll;
    LinkedList<Integer> commandes;
    String commandesAffiche;
    Personnage person;
    JLabel imageBNord;
    JLabel imageBEst;
    JLabel imageBSud;
    JLabel imageBOuest;
    private int sens;
    PanelButton PB;


    public PanelUser(PanelButton butts, Personnage p) {

        sens = 2;
        person = p;
        commandes = butts.commande;
        uText = new JTextArea();
        uScroll = new JScrollPane(uText);
        uScroll.setBounds(5,5,200,300);
        add(uScroll);
        PB = butts;


        imageBNord = new JLabel();
        imageBEst = new JLabel();
        imageBSud = new JLabel();
        imageBOuest = new JLabel();
        imageBNord.setIcon(new ImageIcon("./graph/BOUSSOLENORD.png"));
        imageBEst.setIcon(new ImageIcon("./graph/BOUSSOLEEST.png"));
        imageBSud.setIcon(new ImageIcon("./graph/BOUSSOLESUD.png"));
        imageBOuest.setIcon(new ImageIcon("./graph/BOUSSOLEOUEST.png"));
        imageBSud.setBounds(250, 50, 150, 150);
        add(imageBSud);
        setLayout(null);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*remove(imageBNord);
        remove(imageBEst);
        remove(imageBOuest);
        remove(imageBSud);*/
        uText.setText("");
        commandesAffiche = "";

        for (int i : commandes) {
            switch (i) {
                case 1: commandesAffiche += "avance();\n";
                    break;
                case 2: commandesAffiche += "collecter();\n";
                    break;
                case 3: commandesAffiche += "tournerGauche();\n";
                    /*sens--;
                    if (sens ==-1){
                        sens =3;
                    }
                    System.out.println("boussole : "+sens);*/

                    /*switch (sens){
                        case 0 : //nord
                            imageBNord.setBounds(250, 50, 150, 150);
                            add(imageBNord);
                            break;
                        case 1: //est
                            imageBEst.setBounds(250, 50, 150, 150);
                            add(imageBEst);
                            break;
                        case 2: //sud
                            imageBSud.setBounds(250, 50, 150, 150);
                            add(imageBSud);
                            break;
                        case 3://ouest
                            imageBOuest.setBounds(250, 50, 150, 150);
                            add(imageBOuest);*/

                    break;
                case 4: commandesAffiche += "tournerDroite();\n";
                    break;
                default: break;
            }
        }
        uText.setText(commandesAffiche);

        //la boussole
        if (commandes.peekLast() == null && PB.old_size == PB.new_size) {
            imageBSud.setBounds(250, 50, 150, 150);
            add(imageBSud);
            remove(imageBEst);
            remove(imageBNord);
            remove(imageBOuest);
        }
        if (commandes.peekLast() != null) {
            //System.out.println(commandes.peekLast());
            if (commandes.peekLast() == 3 && PB.new_size > PB.old_size) {
                sens--;
                if (sens == -1) {
                    sens = 3;
                }


            }
            if (commandes.peekLast() == 4 && PB.new_size > PB.old_size) {
                sens++;
                if (sens == 4) {
                    sens = 0;
                }
            }
            //si on delete
            if (commandes.peekLast() == 3 && PB.new_size < PB.old_size) {
                sens++;
                if (sens == 4) {
                    sens = 0;
                }
            }
            if (commandes.peekLast() == 4 && PB.new_size < PB.old_size) {
                sens--;
                if (sens == -1) {
                    sens = 3;
                }
            }

            switch (sens) {
                case 0: //nord
                    imageBNord.setBounds(250, 50, 150, 150);
                    add(imageBNord);
                    remove(imageBSud);
                    remove(imageBEst);
                    remove(imageBOuest);
                    break;
                case 1: //est
                    imageBEst.setBounds(250, 50, 150, 150);
                    add(imageBEst);
                    remove(imageBSud);
                    remove(imageBNord);
                    remove(imageBOuest);
                    break;
                case 2: //sud
                    imageBSud.setBounds(250, 50, 150, 150);
                    add(imageBSud);
                    remove(imageBEst);
                    remove(imageBNord);
                    remove(imageBOuest);
                    break;
                case 3://ouest
                    imageBOuest.setBounds(250, 50, 150, 150);
                    add(imageBOuest);
                    remove(imageBSud);
                    remove(imageBNord);
                    remove(imageBEst);
                    break;
            }
        }


        System.out.println("\noldsize :" + PB.old_size);
        System.out.println("new size " + PB.new_size);
        System.out.println("direction du personnage " + person.getDir());
    }
}
