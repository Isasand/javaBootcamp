public abstract class VehicleWithGears extends Vehicle  implements Printable, WheeledVehicle{

    public VehicleWithGears(){};

    public VehicleWithGears(int gears, int wheels){
        gears = numberOfGears;
        wheels = numberOfWheels;
    }

    protected int numberOfGears;
    protected int currentGear;
    protected int numberOfWheels;

    public void Gear(){

    }

    public int getNumberOfWheels(){
        return numberOfWheels;
    }
}
