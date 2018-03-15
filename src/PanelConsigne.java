import javax.swing.*;
import java.util.ArrayList;

public class PanelConsigne extends JPanel{
    JTextArea consigne;
    JScrollPane con_s;

    public PanelConsigne() {

        consigne = new JTextArea("But : collecter tous les diaments et atteindre la case rouge." +
                "\n Clique sur les boutons pour donner des instructions à ton personnage." +
                "\n Ces instructions s'affichent en-dessous."+
                "\n Clique sur le bouton play pour exécuter les instructrions.");
        con_s = new JScrollPane(consigne);

    }
}
