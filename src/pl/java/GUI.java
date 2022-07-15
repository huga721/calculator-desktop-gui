package pl.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kalkulator wzorowany na projekcie, sworzony dla nauki
 *
 */

public class GUI implements ActionListener {

    private final JFrame ramka;     // deklaruje JFrame o nazwie ramka

    private final JPanel panel;     // deklaruje JPanel o nazwie panel - główny container
    private final JPanel panelDot1; // deklaruje JPanel o nazwie panelDot1

    private final JPanel panelDot2; // deklaruje JPanel o nazwie panelDot2
    private final JPanel panelDot3; // deklaruje JPanel o nazwie panelDot3
    private final JPanel panelDot4; // deklaruje JPanel o nazwie panelDot4
    private final JPanel panelDot5; // deklaruje JPanel o nazwie panelDot5
    private final JPanel panelDot6; // deklaruje JPanel o nazwie panelDot6
    private final JPanel panelDot7; // deklaruje JPanel o nazwie panelDot7
    private final JPanel panelDot8; // deklaruje JPanel o nazwie panelDot8

    private final String[] wartosciGuzikow = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private final JButton guz[], guzPlus, guzMinus, guzMnozyc, guzDzielic, guzRowna, guzCancel, guzPotegaKwadrat,
            guzPierwiastek, guzJedenDzielicPrzez, guzCos, guzSin, guzTan, guzLog, guzXPotegaY, guzProcent, guzAbs,
            guzBinary;

    private final JTextArea tekst;
    private final Font font;
    private final Font fontTekst;

    Kalkulator kalk = new Kalkulator();

    public GUI() {
        ramka = new JFrame("Kalkulator Hubert");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelDot1 = new JPanel(new FlowLayout());   // tworzę instancje
        panelDot2 = new JPanel(new FlowLayout());   // tworzę instancje
        panelDot3 = new JPanel(new FlowLayout());   // tworzę instancję
        panelDot4 = new JPanel(new FlowLayout());   // tworzę instancję
        panelDot5 = new JPanel(new FlowLayout());   // tworzę instancję
        panelDot6 = new JPanel(new FlowLayout());
        panelDot7 = new JPanel(new FlowLayout());
        panelDot8 = new JPanel(new FlowLayout());

        font = new Font("Arial", Font.PLAIN, 18);
        fontTekst = new Font("Arial", Font.PLAIN, 24);

        tekst = new JTextArea(1,20);

        guz = new JButton[10];
        for (int i=0; i<10; i++){
            guz[i] = new JButton(String.valueOf(i));
        }
        guzPlus = new JButton("+");
        guzMinus = new JButton("-");
        guzMnozyc = new JButton("*");
        guzDzielic = new JButton("/");
        guzRowna = new JButton("=");
        guzCancel = new JButton("C");
        guzPotegaKwadrat = new JButton("X*X");
        guzPierwiastek = new JButton("Sqrt");
        guzAbs = new JButton("abs(x)");
        guzBinary = new JButton("Bin");
        guzCos = new JButton("Cos");
        guzSin = new JButton("Sin");
        guzTan  = new JButton("Tan");
        guzLog = new JButton("log10(x)");
        guzProcent = new JButton("x%");
        guzXPotegaY = new JButton("x^y");
        guzJedenDzielicPrzez = new JButton("1/x");

    }
    public void ustawGui(){
        ramka.setSize(450,450);
        ramka.setLocationRelativeTo(null);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setResizable(false);

        tekst.setFont(fontTekst);
        tekst.setEditable(false);

        for (int i = 0; i < 10; i++){
            guz[i].setFont(font);
        }

        guzPlus.setFont(font);
        guzMinus.setFont(font);
        guzMnozyc.setFont(font);
        guzDzielic.setFont(font);
        guzRowna.setFont(font);
        guzCancel.setFont(font);
        guzPotegaKwadrat.setFont(font);
        guzJedenDzielicPrzez.setFont(font);
        guzAbs.setFont(font);
        guzPierwiastek.setFont(font);
        guzSin.setFont(font);
        guzCos.setFont(font);
        guzTan.setFont(font);
        guzXPotegaY.setFont(font);
        guzLog.setFont(font);
        guzProcent.setFont(font);
        guzBinary.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panelDot1.add(tekst);
        panel.add(panelDot1);

        panelDot2.add(guz[1]);
        panelDot2.add(guz[2]);
        panelDot2.add(guz[3]);
        panelDot2.add(Box.createHorizontalStrut(15));
        panelDot2.add(guzPlus);
        panelDot2.add(guzMinus);
        panel.add(panelDot2);

        panelDot3.add(guz[4]);
        panelDot3.add(guz[5]);
        panelDot3.add(guz[6]);
        panelDot3.add(Box.createHorizontalStrut(15));
        panelDot3.add(guzMnozyc);
        panelDot3.add(guzDzielic);
        panel.add(panelDot3);

        panelDot4.add(guz[7]);
        panelDot4.add(guz[8]);
        panelDot4.add(guz[9]);
        panelDot4.add(Box.createHorizontalStrut(15));
        panelDot4.add(guzRowna);
        panelDot4.add(guzCancel);
        panel.add(panelDot4);

        panelDot5.add(Box.createHorizontalStrut(92));
        panelDot5.add(guz[0]);
        panelDot5.add(Box.createHorizontalStrut(210));
        panel.add(panelDot5);

        panelDot6.add(guzPotegaKwadrat);
        panelDot6.add(guzPierwiastek);
        panelDot6.add(guzJedenDzielicPrzez);
        panelDot6.add(guzLog);
        panel.add(panelDot6);

        panelDot7.add(guzSin);
        panelDot7.add(guzCos);
        panelDot7.add(guzTan);
        panel.add(panelDot7);

        panelDot8.add(guzProcent);
        panelDot8.add(guzAbs);
        panelDot8.add(guzXPotegaY);
        panelDot8.add(guzBinary);
        panel.add(panelDot8);

        for(int i = 0; i < 10; i++){
            guz[i].addActionListener(this);
        }
        guzPlus.addActionListener(this);
        guzMinus.addActionListener(this);
        guzMnozyc.addActionListener(this);
        guzDzielic.addActionListener(this);
        guzRowna.addActionListener(this);
        guzCancel.addActionListener(this);
        guzPotegaKwadrat.addActionListener(this);
        guzJedenDzielicPrzez.addActionListener(this);
        guzAbs.addActionListener(this);
        guzPierwiastek.addActionListener(this);
        guzSin.addActionListener(this);
        guzCos.addActionListener(this);
        guzTan.addActionListener(this);
        guzXPotegaY.addActionListener(this);
        guzLog.addActionListener(this);
        guzProcent.addActionListener(this);
        guzBinary.addActionListener(this);

        ramka.add(panel);
        ramka.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // liczby
        for (int i = 0; i < 10; i++){
            if (e.getSource() == guz[i]){
                tekst.replaceSelection(wartosciGuzikow[i]);
                return;
            }
        }

        // dwu argumentowe działania
        if (e.getSource() == guzPlus) {
            sprawdzCzyJestesLiczba(kalk.obliczDwaArgumenty(Kalkulator.operator.plus, odczytajTekstZPola()));
        }
        if (e.getSource() == guzMinus){
            sprawdzCzyJestesLiczba(kalk.obliczDwaArgumenty(Kalkulator.operator.minus, odczytajTekstZPola()));
        }
        if (e.getSource() == guzMnozyc){
            sprawdzCzyJestesLiczba(kalk.obliczDwaArgumenty(Kalkulator.operator.mnozenie, odczytajTekstZPola()));
        }
        if (e.getSource() == guzDzielic){
            sprawdzCzyJestesLiczba(kalk.obliczDwaArgumenty(Kalkulator.operator.podzielic, odczytajTekstZPola()));
        }
        if (e.getSource() == guzXPotegaY){
            sprawdzCzyJestesLiczba(kalk.obliczDwaArgumenty(Kalkulator.operator.xPotegaY, odczytajTekstZPola()));
        }

        //jedno argumentowe działania
        if (e.getSource() == guzPierwiastek){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.pierwiastek, odczytajTekstZPola()));
        }
        if (e.getSource() == guzPotegaKwadrat){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.potegaXKwadrat, odczytajTekstZPola()));
        }
        if (e.getSource() == guzJedenDzielicPrzez){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.jedenPodzielicPrzez, odczytajTekstZPola()));
        }
        if (e.getSource() == guzLog){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.log10, odczytajTekstZPola()));
        }
        if (e.getSource() == guzSin){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.sinus, odczytajTekstZPola()));
        }
        if (e.getSource() == guzTan){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.tangens, odczytajTekstZPola()));
        }
        if (e.getSource() == guzProcent){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.procent, odczytajTekstZPola()));
        }
        if (e.getSource() == guzAbs){
            sprawdzCzyJestesLiczba(kalk.obliczJedenArgument(Kalkulator.operator2.absolutna, odczytajTekstZPola()));
        }

        // guzik do sumy, anulowania i zamiany na liczbę binarną
        if (e.getSource() == guzBinary){
            zamienNaBinarna();
        }
        if (e.getSource() == guzCancel){
            sprawdzCzyJestesLiczba(kalk.cancel());
        }
        if (e.getSource() == guzRowna) {
            sprawdzCzyJestesLiczba(kalk.rownaSie(odczytajTekstZPola()));
        }
        tekst.selectAll();
    }

    public void zamienNaBinarna(){
        tekst.setText("" + Long.toBinaryString(Long.parseLong(tekst.getText())));
    }

    public void sprawdzCzyJestesLiczba (final Double num){
        if (Double.isNaN(num)){
                tekst.setText("");
        }else {
            tekst.setText(Double.toString(num));
        }
    }

    /*
    metoda odczyta tekst z pola i zapisze go jako Double, przechowujac tą wartość w metodzie, jako typ danych
    tekst(String) = liczba(Double)
     */
    public Double odczytajTekstZPola(){
        double liczba;  // tworze zmienna Double liczba
        String string;  // tworze zmienna String string
        string = tekst.getText();   // w zmiennej przechowuje to co jest w polu tekstowym
        liczba = Double.parseDouble(string); // do zmiennej Double liczba nadaje to co jest w polu tekstowym jako Double
        return liczba;
    }
}
