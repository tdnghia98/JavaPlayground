import javax.swing.*;
import java.util.ArrayList;

public class PanelConsigne extends JPanel{
    JTextArea consigne;
    JScrollPane con_s;

    public PanelConsigne() {

        consigne = new JTextArea("But : collecter tous les diaments et atteindre la case rouge");
        con_s = new JScrollPane(consigne);
        con_s.setBounds(10,10,300,70);

        add(con_s);
    }
}
