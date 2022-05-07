public class Main {
    public static void main(String[] args){

        Dane dane = new Dane();
        dane.ustawDane();
        dane.wyswietlDane();

        Posrednik rozwiazanie = new Posrednik(dane);
        rozwiazanie.obliczZysk();

        if(rozwiazanie.bilans()==false) rozwiazanie.fikcyjniBohaterowie(); //jesli nie ma bilansu dodajemy fikcyjnych bohaterów



    }





}
