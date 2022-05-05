import java.util.Scanner;

public class Dane {
    private int iloscOdbiorcow;
    private int iloscDostawcow;

    private int [][] kosztTransportu;

    private int []cenaSprzedazy; //odbiorcom
    private int []kosztZakupu; //u dostawcow

    private int []popyt;
    private int []podaz;



    public void Dane() {
    }

    public int[] getPopyt() {
        return popyt;
    }

    public int[] getPodaz() {
        return podaz;
    }

    public int getIloscOdbiorcow() {
        return iloscOdbiorcow;
    }

    public int getIloscDostawcow() {
        return iloscDostawcow;
    }

    public int[][] getKosztTransportu() {
        return kosztTransportu;
    }

    public int[] getCenaSprzedazy() {
        return cenaSprzedazy;
    }

    public int[] getKosztZakupu() {
        return kosztZakupu;
    }

    public void setIloscOdbiorcow(int iloscOdbiorcow) {
        this.iloscOdbiorcow = iloscOdbiorcow;
    }

    public void setIloscDostawcow(int iloscDostawcow) {
        this.iloscDostawcow = iloscDostawcow;
    }

    public void setKosztTransportu(int[][] kosztTransportu) {
        this.kosztTransportu = kosztTransportu;
    }

    public void setCenaSprzedazy(int[] cenaSprzedazy) {
        this.cenaSprzedazy = cenaSprzedazy;
    }

    public void setKosztZakupu(int[] kosztZakupu) {
        this.kosztZakupu = kosztZakupu;
    }

    public void setPopyt(int[] popyt) {
        this.popyt = popyt;
    }

    public void setPodaz(int[] podaz) {
        this.podaz = podaz;
    }

    public void ustawDane(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Wprowadz liczbe obiorcow: ");
        iloscOdbiorcow = scanner.nextInt();
        System.out.println(" Wprowadz liczbe dostawcow... ");
        iloscDostawcow= scanner.nextInt();

        System.out.println(" Wprowadz ceny sprzedazy: ");
        cenaSprzedazy = new int[iloscOdbiorcow];
        for(int i=0; i< cenaSprzedazy.length; i++)cenaSprzedazy[i]=scanner.nextInt();

        System.out.println(" Wprowadz koszty zakupu... ");
        kosztZakupu = new int[iloscDostawcow];
        for(int i=0; i< kosztZakupu.length; i++)kosztZakupu[i]=scanner.nextInt();

        kosztTransportu =new int[iloscDostawcow][iloscOdbiorcow]; //tabela z kosztami transportu
        System.out.println(" Wprowadz koszty transportu... ");
        for (int i =0 ; i<iloscDostawcow; i++){
            for (int j=0; j<iloscOdbiorcow;j++){
                kosztTransportu[i][j]=scanner.nextInt();
            }
        }
        System.out.println(" Wprowadz popyt... ");
        popyt = new int[iloscOdbiorcow];
        for(int i=0; i< popyt.length; i++)popyt[i]=scanner.nextInt();

        System.out.println(" Wprowadz podaz... ");
        podaz = new int[iloscDostawcow];
        for(int i=0; i< podaz.length; i++)podaz[i]=scanner.nextInt();
    }
    public void wyswietlDane(){
        System.out.println(" ilosc odbiorców: "+ iloscOdbiorcow);
        System.out.println(" ilosc dostawcow: "+ iloscDostawcow);

        System.out.print(" ceny sprzedazy: ");
        for(int i=0; i<iloscOdbiorcow; i++) System.out.print(cenaSprzedazy[i]+ " ");

        System.out.print(" koszty zakupow: ");
        for(int i=0; i<iloscDostawcow; i++) System.out.print(kosztZakupu[i]+ " ");
        System.out.println();

        System.out.print(" popyt: ");
        for(int i=0; i<popyt.length; i++) System.out.print(popyt[i]+ " ");

        System.out.print(" podaz: ");
        for(int i=0; i<podaz.length; i++) System.out.print(podaz[i]+ " ");

        System.out.println(" JEDNOSTKOWE KOSZTY TRANSPORTU");

        System.out.print("\t");
        for(int i=0; i<iloscOdbiorcow; i++) System.out.print("O"+(i+1)+ "\t");

        for(int i=0; i<iloscDostawcow; i++){
            System.out.println();
            System.out.print("D"+ (i+1)+"\t");
            for(int j=0; j<iloscOdbiorcow;j++){
                System.out.print(kosztTransportu[i][j]+"\t");
            }
        }




    }
}
