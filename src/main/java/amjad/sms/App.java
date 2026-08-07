package amjad.sms;

import amjad.sms.DatabaseInitializer;

public class App {
    public static void main(String[] args) {
        DatabaseInitializer.initialize();

        View view = new View();
        view.start();
    }
}
