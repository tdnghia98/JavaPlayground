import javax.swing.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] m = {
                {4, 0, 0, 0, 0, 0},
                {2, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};

        int[][] m2 = {
                {4, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0},
                {2, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0},
                {2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        int[][] m3 = {
                {4, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 0, 0},
                {2, 0, 0, 0, 0, 0},
                {0, 3, 0, 0, 0, 0},
                {0, 0, 3, 0, 0, 0},
                {0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 3, 2},
                {0, 0, 0, 0, 0, 3},
                {0, 2, 0, 0, 0, 1}};

        Level lvl1 = new Level(m, 1, 1);
        Level lvl2 = new Level(m2, 2, 2);
        Level lvl3 = new Level(m3, 3, 6);
        Terrain terrain = new Terrain(lvl1);
        Personnage p = new Personnage(terrain);
        JavPlay playWindow = new JavPlay(terrain, p);
        Welcome w = new Welcome(playWindow);
        p.playWindow = playWindow;
        p.welcome = w;

        Level[] lvlArray = {lvl1,lvl2,lvl3};
        int lvlNo = 0; // Numero du niveau
        while (true) {
            Thread.sleep(10);

            if (p.end) {
                lvlNo++;
                if (lvlNo == lvlArray.length) {
                    JOptionPane.showMessageDialog(null,"Congratulation, you have completed all levels" +
                                    "\nThe progam is quitting...",
                            "Winner!",JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                } else {
                terrain = new Terrain(lvlArray[lvlNo]);
                p = new Personnage(terrain);
                playWindow.dispose();
                playWindow = new JavPlay(terrain, p);
                playWindow.setVisible(true);
                }
            }
        }

    }
}
