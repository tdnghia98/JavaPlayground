public class Main {
    public static void main(String[] args) {
        Terrain terrain = new Terrain(1);
        Personnage p = new Personnage(terrain);
        JavPlay playWindow = new JavPlay(terrain,p);




    }
}
