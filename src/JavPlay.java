import javax.swing.*;
import java.awt.event.ActionListener;

public class JavPlay extends JFrame {
    private PanelTerrain panM;    // Le terrain
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

    public JavPlay(int [][] M){
        // Dessiner le plan du terrain
        super("Java Playground");
        this.setSize(800,650);
        //panel
        panMain = new JPanel();
        panMain.setLayout(null);
        panCon = new PanelConsigne();
        panCon.setLayout(null);
        panU = new PanelUser();
        panU.setLayout(null);
        panBtn = new PanelButton();
        panBtn.setLayout(null);
        panS = new PanelScore();
        panS.setLayout(null);
        panP = new PanelPlay();
        panP.setLayout(null);
        panM = new PanelTerrain(M);
        panM.setLayout(null);

        /*
        avc = new JButton("Avancer");
        coll = new JButton("Collecter");
        turnr = new JButton("TournerGauche");
        turnl = new JButton("TournerDroite");
        play = new JButton("Play");*/

        //on place les objets
        panMain.setBounds(0,50,800,600);
        panCon.setBounds(10,10,480,80);
        panU.setBounds(10,210,480,380);
        panBtn.setBounds(10,100,480,100);
        panS.setBounds(490,10,300,50);
        panM.setBounds(490,65,300,450);
        panP.setBounds(490,540,300,50);
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
        /*avc.addActionListener(this);
        coll.addActionListener(this);
        turnr.addActionListener(this);
        turnl.addActionListener(this);
        play.addActionListener(this);*/
        
    }


}
