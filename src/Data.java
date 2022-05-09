import java.util.Scanner;

public class Data {
    private int numberOfRecipients; //ilosc odbiorców
    private int numberOfSuppliers; //ilosc dostawców

    private int [][] shippingCost; //koszt transportu

    private int [] sellingPrice; //odbiorcom
    private int [] buyingCost; //u dostawcow

    private int [] demand; //popyt
    private int [] supply; //podaż



    public void Data() {
    }

    public int[] getDemand() {
        return demand;
    }

    public int[] getSupply() {
        return supply;
    }

    public int getNumberOfRecipients() {
        return numberOfRecipients;
    }

    public int getNumberOfSuppliers() {
        return numberOfSuppliers;
    }

    public int[][] getShippingCost() {
        return shippingCost;
    }

    public int[] getSellingPrice() {
        return sellingPrice;
    }

    public int[] getBuyingCost() {
        return buyingCost;
    }

    public void setNumberOfRecipients(int numberOfRecipients) {
        this.numberOfRecipients = numberOfRecipients;
    }

    public void setNumberOfSuppliers(int numberOfSuppliers) {
        this.numberOfSuppliers = numberOfSuppliers;
    }

    public void setKosztTransportu(int[][] shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setSellingPrice(int[] sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setBuyingCost(int[] buyingCost) {
        this.buyingCost = buyingCost;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }
    public void setDemandIndex(int index, int demand) {
        this.demand[index]=demand;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }
    public void setSupplyIndex(int index, int supply) {
        this.supply[index]= supply;
    }

    public void ustawDane(){
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Wprowadz liczbe obiorcow: ");
        numberOfRecipients = scanner.nextInt();
        System.out.println(" Wprowadz liczbe dostawcow... ");
        numberOfSuppliers = scanner.nextInt();

        System.out.println(" Wprowadz ceny sprzedazy: ");
        sellingPrice = new int[numberOfRecipients];
        for(int i = 0; i< sellingPrice.length; i++) sellingPrice[i]=scanner.nextInt();

        System.out.println(" Wprowadz koszty zakupu... ");
        buyingCost = new int[numberOfSuppliers];
        for(int i = 0; i< buyingCost.length; i++) buyingCost[i]=scanner.nextInt();

        shippingCost =new int[numberOfSuppliers][numberOfRecipients]; //tabela z kosztami transportu
        System.out.println(" Wprowadz koszty transportu... ");
        for (int i = 0; i< numberOfSuppliers; i++){
            for (int j = 0; j< numberOfRecipients; j++){
                shippingCost[i][j]=scanner.nextInt();
            }
        }
        System.out.println(" Wprowadz popyt... ");
        demand = new int[numberOfRecipients];
        for(int i = 0; i< demand.length; i++) demand[i]=scanner.nextInt();

        System.out.println(" Wprowadz podaz... ");
        supply = new int[numberOfSuppliers];
        for(int i = 0; i< supply.length; i++) supply[i]=scanner.nextInt();
    }
    public void wyswietlDane(){
        System.out.println(" ilosc odbiorców: "+ numberOfRecipients);
        System.out.println(" ilosc dostawcow: "+ numberOfSuppliers);

        System.out.print(" ceny sprzedazy: ");
        for(int i = 0; i< numberOfRecipients; i++) System.out.print(sellingPrice[i]+ " ");

        System.out.print(" koszty zakupow: ");
        for(int i = 0; i< numberOfSuppliers; i++) System.out.print(buyingCost[i]+ " ");
        System.out.println();

        System.out.print(" demand: ");
        for(int i = 0; i< demand.length; i++) System.out.print(demand[i]+ " ");

        System.out.print(" supply: ");
        for(int i = 0; i< supply.length; i++) System.out.print(supply[i]+ " ");

        System.out.println(" \nJEDNOSTKOWE KOSZTY TRANSPORTU");

        System.out.print("\t");
        for(int i = 0; i< numberOfRecipients; i++) System.out.print("O"+(i+1)+ "\t");

        for(int i = 0; i< numberOfSuppliers; i++){
            System.out.println();
            System.out.print("D"+ (i+1)+"\t");
            for(int j = 0; j< numberOfRecipients; j++){
                System.out.print(shippingCost[i][j]+"\t");
            }
        }




    }
}
