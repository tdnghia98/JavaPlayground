import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JavPlay extends JFrame {
    Terrain terrain;
    Personnage p;
    private PanelTerrain panM;    // Le panel terrain
    private PanelConsigne panCon;
    private PanelUser panU;
    private PanelButton panBtn;
    private PanelScore panS;
    private PanelPlay panP;
    private JPanel panMain;


    public JavPlay(Terrain t, Personnage person){
        // Dessiner le plan du terrain
        super("Java Playground");
        p = person;
        terrain = t;
        this.setSize(800,650);
        setLayout(null);
        //panel
        panMain = new JPanel();
        panMain.setLayout(null);
        panCon = new PanelConsigne(p);
        panCon.setLayout(null);
        panBtn = new PanelButton();
        panBtn.setLayout(null);
        panU = new PanelUser(panBtn, p);
        panU.setLayout(null);
        panBtn.panUser = panU;  // Assign the userPanel to the ButtonPanel
        panS = new PanelScore(p,terrain);
        panS.setLayout(null);
        panM = new PanelTerrain(terrain, p);
        panM.setLayout(null);
        panP = new PanelPlay(panBtn, p, panM, panCon, panS, panU);
        panP.setLayout(null);


        //on place les objets
        panMain.setBounds(0,50,800,600);
        // Panel Consigne
        panCon.setBounds(10,10,480,80);
        // Panel Bouton
        panBtn.setBounds(10, 100, 420, 100);
        // Panel User
        panU.setBackground(Color.CYAN);
        panU.setBounds(10, 210, 420, 380);
        // Panel Score
        panS.setBounds(490,10,300,50);
        // Panel Terrain - Map
        panM.setBounds(490,65,300,450);
        // Panel Play - Bouton Play
        panP.setBounds(490,540,300,50);
        panBtn.setBackground(Color.CYAN);

        panS.setBackground(Color.green);
        panP.setBackground(Color.DARK_GRAY);
        panU.repaint();

        panMain.add(panBtn);
        panMain.add(panCon);
        panMain.add(panU);
        panMain.add(panS);
        panMain.add(panM);
        panMain.add(panP);

        this.setContentPane(panMain);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
