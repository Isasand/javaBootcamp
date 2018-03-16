public class Train extends Vehicle implements Printable{

    public Train(int wagons){
        numberOfWagons = wagons;
    }

    private int numberOfWagons;

    public void ConnectCarriage(){

    }

    public void PrintMe(){
        System.out.print("Number of wagons: " + numberOfWagons + "\n");
    }
}
