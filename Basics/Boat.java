public class Boat extends Vehicle implements Printable{

    public Boat(){};

    private float deadWeight;

    public void Turn(){

    }
    public void PrintMe() {
        System.out.print("Current deadweight: "+ deadWeight+ "\n");
        System.out.print("Current velocity: " + velocity+ "\n");
        System.out.print("Current weight:" + weight+ "\n");
    }
}
