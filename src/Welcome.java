import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {
    JPanel mainPan;
    JPanel choices; // Panel des choix
    JPanel title;   // Panel du logo du jeu
    JavPlay playground;

    public Welcome(JavPlay playground) {
        this.playground = playground;
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        // Panel des choix
        Font police = new Font ("Arial", Font.BOLD, 30);
        choices = new JPanel();
        choices.setLayout(null);
        choices.setBounds(150, 150, 200, 200);
        JButton play = new JButton("Play");
        play.setBounds(0, 0, 200, 100);
        play.setFont(police);
        play.setBackground(Color.yellow);
        JButton quit = new JButton("Quit");
        quit.setBounds(0, 100, 200, 100);
        quit.setFont(police);
        quit.setBackground(Color.yellow);
        choices.add(play);
        choices.add(quit);
        // Main panel
        mainPan = new JPanel();
        mainPan.setLayout(null);
        mainPan.setBounds(0, 0, this.getWidth(), this.getHeight());
        mainPan.setBackground(Color.cyan);
        JLabel bienvenue = new JLabel ("Bienvenue à Java Playground");
        bienvenue.setBounds (30,50,500,50);
        bienvenue.setFont(police);
        mainPan.add(bienvenue);
        JLabel authors = new JLabel("BOSSARD Camille, DINH Mai Van, TRAN Duy Nghia, UNG Louis");
        authors.setBounds(130,370,500,50);
        mainPan.add(authors);
        JLabel authors2 = new JLabel("Groupe 97 ASINSA 2");
        authors2.setBounds(340,390,200,50);
        mainPan.add(authors2);
        add(mainPan);
        mainPan.add(choices);

        setContentPane(mainPan);

        setVisible(true);

        play.addActionListener((ActionEvent e) -> {
            playground.setVisible(true);
            setVisible(false);
        });

        quit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
