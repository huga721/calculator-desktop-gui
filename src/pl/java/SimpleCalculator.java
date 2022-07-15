package pl.java;

public class SimpleCalculator {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().ustawGui();
            }
        });
    }
}
