package amjad.sms;

public class App {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.SEVERE);

        View view = new View();
        view.start();
    }
}
