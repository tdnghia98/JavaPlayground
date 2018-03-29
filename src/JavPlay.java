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
    /*private JButton avc;
    private JButton coll;
    private JButton turnr;
    private JButton turnl;
    private JButton play;
    private JLabel cons;*/

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
        panU = new PanelUser(panBtn);
        panU.setLayout(null);
        panBtn.panUser = panU;  // Assign the userPanel to the ButtonPanel
        panS = new PanelScore(p,terrain);
        panS.setLayout(null);
        panM = new PanelTerrain(terrain, p);
        panM.setLayout(null);
        panP = new PanelPlay(panBtn, p, panM, panCon, panS, panU);
        panP.setLayout(null);


        /*
        avc = new JButton("Avancer");
        coll = new JButton("Collecter");
        turnr = new JButton("TournerGauche");
        turnl = new JButton("TournerDroite");
        play = new JButton("Play");*/

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
        /*cons = new JLabel("Consigne : atteindre la case rouge et collecter tous les diamants")
        avc.setBounds(10,5,40,20);
        coll.setBounds(10,75,40,20);
        turnr.setBounds(430,5,40,20);
        turnl.setBounds(430,75,40,20);
        play.setBounds(120,5,60,40);

        panCon.add(cons);
        panP.add(play);
        panBtn.add(coll);
        panBtn.add(avc);
        panBtn.add(turnl);
        panBtn.add(turnr);*/
        panMain.add(panBtn);
        panMain.add(panCon);
        panMain.add(panU);
        panMain.add(panS);
        panMain.add(panM);
        panMain.add(panP);

        this.setContentPane(panMain);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*avc.addActionListener(this);
        coll.addActionListener(this);
        turnr.addActionListener(this);
        turnl.addActionListener(this);
        play.addActionListener(this);*/
        
    }


}
