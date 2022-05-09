public class Main {
    public static void main(String[] args){

        Data dane = new Data();
        dane.ustawDane();
        dane.wyswietlDane();

        Posrednik rozwiazanie = new Posrednik(dane);
        rozwiazanie.calculateProfits();

        if(rozwiazanie.calculateBilans()==false) rozwiazanie.fictionalHeroes(); //jesli nie ma bilansu dodajemy fikcyjnych bohaterów
        rozwiazanie.findMaxProfit();

        System.out.println("koniec");

    }





}
