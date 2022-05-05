import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Posrednik {

    Dane dane;
    int [][] zysk;

    public Posrednik(Dane dane) {
        this.dane = dane;
    }
    public Posrednik() {
    }

    public void obliczZysk(){
        zysk = new int[dane.getIloscDostawcow()][dane.getIloscOdbiorcow()];

        System.out.println();
        for(int i=0; i<dane.getIloscDostawcow();i++){

            for (int j=0; j<dane.getIloscOdbiorcow();j++){
                zysk[i][j]=dane.getCenaSprzedazy()[j]-dane.getKosztZakupu()[i]-dane.getKosztTransportu()[i][j];
            }
        }
        System.out.println();

        System.out.println(" ZYSK POSREDNIKA ");

        System.out.print("\t");
        for(int i=0; i<dane.getIloscOdbiorcow(); i++) System.out.print("O"+(i+1)+ "\t"); //tworzenie tabeli wsadzic do funkcji

        for(int i=0; i<dane.getIloscDostawcow();i++){
            System.out.println();
            System.out.print("D"+ (i+1)+"\t");
            for (int j=0; j<dane.getIloscOdbiorcow();j++){
                System.out.print(zysk[i][j]+ "\t");
            }

        }
    }

    public boolean bilans(){

        int sumaPopyt=0;
        int sumaPodaz=0;

        for(int i=0;i<dane.getPopyt().length;i++)sumaPopyt+=dane.getPopyt()[i];
        for(int i=0;i<dane.getPodaz().length;i++)sumaPodaz+=dane.getPodaz()[i];

        if (sumaPopyt==sumaPodaz) {

            return true;
        }
        else{
            return false;
        }
    }

    public void fikcyjniBohaterowie(){

        if(bilans()==false){
            int nowaIloscDostawcow=dane.getIloscDostawcow()+1;
            int nowaIloscOdbiorcow=dane.getIloscOdbiorcow()+1;

            int [][] nowyZysk = new int[nowaIloscDostawcow][nowaIloscOdbiorcow]; //tworzymy większą tablice

            for(int i=0; i<nowaIloscDostawcow;i++){
                for (int j=0; j<nowaIloscOdbiorcow;j++){

                    if(j>dane.getIloscOdbiorcow()-1||i>dane.getIloscDostawcow()-1)nowyZysk[i][j]=0; //uzupelniamy zyski przy fikcyjnych bohaterach zerami
                    else {
                        nowyZysk[i][j]=zysk[i][j];
                    }

                }
            }

            System.out.println("\n");

            for(int i=0; i<nowaIloscDostawcow;i++){
                for (int j=0; j<nowaIloscOdbiorcow;j++){

                    System.out.print(nowyZysk[i][j]+ " ");

                }
                System.out.println();
            }


        }
    }
}
