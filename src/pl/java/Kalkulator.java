package pl.java;

import static java.lang.Double.NaN;
import static java.lang.Math.*;

public class Kalkulator {

    public enum operator {
        normalny, plus, minus, mnozenie, podzielic, xPotegaY
    }
    public enum operator2{
        pierwiastek, potegaXKwadrat, jedenPodzielicPrzez, log10, sinus, cosinus, tangens, procent, absolutna
    }

    private double liczba1, liczba2, wynik;

    private operator tryb = operator.normalny;


    private Double obliczOperatory() {
        if (tryb == operator.normalny){
            return liczba2;
        }
        if (tryb == operator.plus){
            if (liczba2 != 0){
                return liczba1 + liczba2;
            } else {
                return liczba1;
            }
        }
        if (tryb == operator.minus){
            System.out.println("minus test");
            return liczba1 - liczba2;
        }
        if (tryb == operator.mnozenie){
            return liczba1 * liczba2;
        }
        if (tryb == operator.podzielic){
            return liczba1 / liczba2;
        }
        if (tryb == operator.xPotegaY){
            return Math.pow(liczba1, liczba2);
        }
        throw new Error();
    }

    public Double obliczDwaArgumenty (operator nowyTryb, Double liczba){
        if (tryb == operator.normalny){
            liczba1 = liczba;
            tryb = nowyTryb;
            System.out.println(tryb);
            return NaN;
        }else {
            liczba2 = liczba;
            wynik = obliczOperatory();
            tryb = nowyTryb;
            System.out.println(tryb);
            return wynik;
        }
    }

    public Double obliczJedenArgument(operator2 nowyTryb2 ,Double liczba){
        if(nowyTryb2 == operator2.pierwiastek){
            return Math.sqrt(liczba);
        }
        if (nowyTryb2 == operator2.potegaXKwadrat){
            return Math.pow(liczba,liczba);
        }
        if (nowyTryb2 == operator2.jedenPodzielicPrzez){
            return 1 / liczba;
        }
        if (nowyTryb2 == operator2.log10){
            return log10(liczba);
        }
        if (nowyTryb2 == operator2.sinus){
            return sin(Math.toRadians(liczba));
        }
        if (nowyTryb2 == operator2.cosinus){
            return cos(Math.toRadians(liczba));
        }
        if (nowyTryb2 == operator2.tangens){
            if (liczba == 0 || liczba % 180 == 0) {
                return 0.0;
            }
            if (liczba % 90 == 0 && liczba % 180 != 0) {
                return NaN;
            }
            return Math.tan(Math.toRadians(liczba));
        }
        if (nowyTryb2 == operator2.procent){
            return liczba / 100;
        }
        if (nowyTryb2 == operator2.absolutna){
            return Math.abs(liczba);
        }

        return NaN;
    }


    public Double rownaSie(Double liczba){
        return obliczDwaArgumenty(operator.normalny, liczba);
    }
    public Double cancel(){
        liczba1 = 0.0;
        liczba2 = 0.0;
        return NaN;
    }
}
