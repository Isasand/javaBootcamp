public class Bicycle extends VehicleWithGears{
    public Bicycle(int gears, int wheels){
        numberOfGears = gears;
        numberOfWheels = wheels;
    }

    public void PrintMe() {
        System.out.print("Number of gears: " + numberOfGears + "\n");
        System.out.print("Current gear: " + currentGear + "\n" );
        System.out.print("Current velocity: " + velocity + "\n");
        System.out.print("Current weight: " + weight + "\n");
    }

}
