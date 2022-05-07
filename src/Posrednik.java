public class Posrednik {

    Data data;
    int [][] profit;

    public Posrednik(Data dane) {
        this.data = dane;
    }
    public Posrednik() {}

    public void showProfits(){
        System.out.println();

        System.out.println(" ZYSK POSREDNIKA ");

        System.out.print("\t");
        for(int i = 0; i< data.getNumberOfRecipients(); i++) System.out.print("O"+(i+1)+ "\t"); //tworzenie tabeli wsadzic do funkcji

        for(int i = 0; i< data.getNumberOfSuppliers(); i++){
            System.out.println();
            System.out.print("D"+ (i+1)+"\t");
            for (int j = 0; j< data.getNumberOfRecipients(); j++){
                System.out.print(profit[i][j]+ "\t");
            }
        }
    }

    public void calculateProfits(){
        profit = new int[data.getNumberOfSuppliers()][data.getNumberOfRecipients()];

        System.out.println();
        for(int i = 0; i< data.getNumberOfSuppliers(); i++){

            for (int j = 0; j< data.getNumberOfRecipients(); j++){
                profit[i][j]= data.getSellingPrice()[j]- data.getBuyingCost()[i]- data.getShippingCost()[i][j];
            }
        }
        showProfits();
    }

    public boolean calculateBilans(){

        int sumaPopyt=0;
        int sumaPodaz=0;

        for(int i = 0; i< data.getDemand().length; i++)sumaPopyt+= data.getDemand()[i];
        for(int i = 0; i< data.getSupply().length; i++)sumaPodaz+= data.getSupply()[i];

        if (sumaPopyt==sumaPodaz) {
            System.out.println("Bilans zachowany");
            return true;
        }
        else{
            System.out.println("\n\nBrak bilansu, dodajemy fikcyjnych bohaterow: D"+(data.getNumberOfSuppliers()+1)+", O"+(data.getNumberOfRecipients()+1));
            return false;
        }
    }

    public void fictionalHeroes(){

            int nowaIloscDostawcow= data.getNumberOfSuppliers()+1;
            int nowaIloscOdbiorcow= data.getNumberOfRecipients()+1;

            int [][] nowyZysk = new int[nowaIloscDostawcow][nowaIloscOdbiorcow]; //tworzymy większą tablice

            for(int i=0; i<nowaIloscDostawcow;i++){
                for (int j=0; j<nowaIloscOdbiorcow;j++){

                    if(j> data.getNumberOfRecipients()-1||i> data.getNumberOfSuppliers()-1)nowyZysk[i][j]=0; //uzupelniamy zyski przy fikcyjnych bohaterach zerami
                    else {
                        nowyZysk[i][j]= profit[i][j];
                    }
                }
            }
            this.profit = nowyZysk;
            this.data.setNumberOfSuppliers(nowaIloscDostawcow);
            this.data.setNumberOfRecipients(nowaIloscOdbiorcow);

            showProfits();
    }
}
