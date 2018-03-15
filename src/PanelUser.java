import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class PanelUser extends JPanel {
    JTextArea uText;
    JScrollPane uScroll;
    ArrayList<Integer> print_com;

    public PanelUser(PanelButton butts){
        print_com = butts.commande;

    }
}
