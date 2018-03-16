public class Main {

    public static void main(String[] args){
        TestURLReader();
       }

    public static void CreateVehicles(){
        Car myCar = new Car(6,4);
        Train myTrain = new Train(4);
        Bicycle myBicycle = new Bicycle(4,2);
        Boat myBoat = new Boat();

        myBoat.PrintMe();
        myCar.PrintMe();
        myTrain.PrintMe();
        myBoat.PrintMe();

        System.out.print("\nNumber of wheels on my car: " +myCar.getNumberOfWheels());
        System.out.print("\nNumber of wheels on my bicycle: " + myBicycle.getNumberOfWheels());
    }

    public static void CalculateGas(){
        GasAndMileageCalculator.AskForInput();
        GasAndMileageCalculator.PrintData();
    }

    public static void RunCalculator() {
        Calculator calculator = new Calculator();
        calculator.TakeInput();
        try {
            calculator.Calc();
        } catch (OperatorNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        calculator.PrintSum();
    }

    public static void ChangeCalculator(){
        CalculateChange.TakeInput();
        CalculateChange.Run();
    }

    public static void TestURLReader(){
        URLReader reader = new URLReader("http://www.puzzlers.org/pub/wordlists/pocket.txt");
        try{
            reader.read();
        }
        catch(Exception e){
            System.out.println("something went wrong");
        }
    }
}


