import javax.swing.*;

public class JavPlay extends JFrame{
    private JPanel panM;    // Le terrain
    private JPanel panCon;
    private JPanel panU;
    private JPanel panBtn;
    private JPanel panS;
    private JPanel panP;
    private JPanel panMain;
    private JButton avc;
    private JButton coll;
    private JButton turnr;
    private JButton turnl;

    public JavPlay(){
        // Dessiner le plan du terrain
        super("Java Playground");
        this.setSize(800,650);
        //panel
        panMain = new JPanel();
        panMain.setLayout(null);
        panCon = new JPanel();
        panCon.setLayout(null);
        panU = new JPanel();
        panU.setLayout(null);
        panBtn = new JPanel();
        panBtn.setLayout(null);
        panS = new JPanel();
        panS.setLayout(null);
        panP = new JPanel();
        panP.setLayout(null);
        panM = new JPanel();
        panM.setLayout(null);

        //bouton
        avc = new JButton("Avancer");
        coll = new JButton("Collecter");
        turnr = new JButton("TournerGauche");
        turnl = new JButton("TournerDroite");

        //on place les objets
        panMain.setBounds(0,50,800,600);
        panCon.setBounds(10,10,480,80);
        panU.setBounds(10,210,480,380);
        panBtn.setBounds(10,100,480,100);
        panS.setBounds(490,10,);


    }


}
