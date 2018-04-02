public class Level {
    int[][] map;
    // nb de items
    int diamond;
    int caillou;

    public Level(int[][] m, int nbDia, int nbCai) {
        // Recopier le plan du terrain
        map = new int[m.length][m[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = m[i][j];
            }
        }
        diamond = nbDia;
        caillou = nbCai;
    }
}
