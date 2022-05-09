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

    public void findMaxProfit(){
        int max =0;
        int imax=0;
        int jmax=0;
        for(int i=0; i< data.getNumberOfSuppliers();i++){
            for (int j=0; j<data.getNumberOfRecipients();j++){
                if(profit[i][j]>max){
                    max = profit[i][j];
                    imax=i;
                    jmax=j;
                    }
                }
            }
        System.out.println(" imax = "+ imax + " jmax=" + jmax );


        boolean t = true;
        boolean t2 = true;



        do{
            System.out.println("Hejka :) ");
            t=false;
            for(int i=0; i<data.getNumberOfRecipients()-1; i++){
                if ( data.getDemand()[i]!=0) t=true;
            }
            t2=false;
            for(int i=0; i<data.getNumberOfSuppliers()-1; i++){
                if ( data.getSupply()[i]!=0) t2=true;
            }

            if( data.getDemand()[jmax]<=data.getSupply()[imax]){
                profit[imax][jmax] = data.getDemand()[jmax];

                int newSupply = data.getSupply()[imax]-data.getDemand()[jmax]; //nowa podaz
                data.setDemandIndex(jmax, 0); //popyt sie zeruje
                data.setSupplyIndex(imax,newSupply );

            }
        } while (t&&t2);



        showProfits();

        System.out.println(" popyt: ");
        for( int i =0; i< data.getNumberOfRecipients(); i++){
            System.out.println( data.getDemand()[i]+ " ");
        }
        System.out.println(" podaz: ");
        for( int i =0; i< data.getNumberOfSuppliers(); i++){
            System.out.println( data.getSupply()[i]+ " ");
        }


        }


    }

