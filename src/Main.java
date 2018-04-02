import javax.swing.*;
public class Main {


    public static void main(String[] args) throws InterruptedException {
        int[][] m = {{4, 0, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0}, {2, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};

        int[][] m2 = {{4, 0, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0}, {2, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 3, 0}, {2, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[][] m3 = {{4, 0, 0, 0, 0, 0}, {3, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0}, {0, 3, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0}, {0, 0, 0, 3, 0, 0}, {0, 0, 0, 0, 3, 2}, {0, 0, 0, 0, 0, 3}, {0, 2, 0, 0, 0, 1}};

        Level lvl1 = new Level(m, 1, 1);
        Level lvl2 = new Level(m2, 2, 2);
        Level lvl3 = new Level(m3, 3, 6);
        Terrain terrain1 = new Terrain(lvl1);
        Personnage p1 = new Personnage(terrain1);
        JavPlay playWindow = new JavPlay(terrain1, p1);

        Terrain terrain2 = new Terrain(lvl2);
        Personnage p2 = new Personnage(terrain2);
        JavPlay playWindow2 = new JavPlay(terrain2, p2);
        playWindow2.setVisible(false);

        Terrain terrain3 = new Terrain(lvl3);
        Personnage p3 = new Personnage(terrain3);
        JavPlay playWindow3 = new JavPlay(terrain3, p3);
        playWindow3.setVisible(false);


        while (p1.end == false) {
            Thread.sleep(10);   // On ne sait pas pourquoi si on ne met rien ca ne change pas au niveau suivant
        }

        playWindow.setVisible(false);
        playWindow2.setVisible(true);
        while (p2.end == false) {
            Thread.sleep(10);
        }
        playWindow2.setVisible(false);
        playWindow3.setVisible(true);

        while (p3.end == false) {
            Thread.sleep(10);
        }

        System.exit(0);


    }
}
