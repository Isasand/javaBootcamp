import java.util.Scanner;

public class GasAndMileageCalculator {


    static double mileage = 0;
    static double mileage_YearAgo = 0;
    static double usedGas = 0 ;
    static double gasPerMile = 0;

    public static void AskForInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current mileage:");

        mileage = TestDoubleInput(mileage, sc);
        System.out.println("Mileage a year ago:");
        mileage_YearAgo = TestDoubleInput(mileage_YearAgo, sc);
        System.out.println("Amount of gas used last year: ");
        usedGas = TestDoubleInput(usedGas, sc);

        gasPerMile = CalcUsedGas(mileage, mileage_YearAgo, usedGas);

    }

    public static void PrintData(){
        System.out.println("Mileage: " + mileage);
        System.out.println("Amount of used gas last year: " + usedGas);
        System.out.println("Used gas per mile: " + gasPerMile);
    }

    static public double TestDoubleInput(double arg, Scanner sc) {
        boolean success = false;

        while (!success) {
            try {
                arg = sc.nextDouble();
                return arg;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong type, try again: ");
                success = false;
            }
        }
        return arg;
    }

    static public double CalcUsedGas(double mileage, double mileage_YearAgo, double usedGas){
        double usedMileage = mileage - mileage_YearAgo;
        return usedMileage/usedGas;
    }
}
