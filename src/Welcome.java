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
        choices = new JPanel();
        choices.setLayout(null);
        choices.setBounds(150, 150, 200, 200);
        JButton play = new JButton("Play");
        play.setBounds(0, 0, 100, 100);
        JButton quit = new JButton("Quit");
        quit.setBounds(0, 110, 100, 100);
        choices.add(play);
        choices.add(quit);
        // Main panel
        mainPan = new JPanel();
        mainPan.setLayout(null);
        mainPan.setBounds(0, 0, this.getWidth(), this.getHeight());
        mainPan.setBackground(Color.green);

        add(mainPan);
        mainPan.add(choices);

        setContentPane(mainPan);

        setVisible(true);

        play.addActionListener((ActionEvent e) -> {
            playground.setVisible(true);
            setVisible(false);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
