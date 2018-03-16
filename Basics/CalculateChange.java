import java.util.Scanner;
import java.lang.Math;

public class CalculateChange {

    static Scanner sc = new Scanner(System.in);
    static double price;
    static double amount;
    static double change;
    static int temp;

    public static void TakeInput(){
        System.out.print("Fyll i pris (i SEK): ");
        price = sc.nextDouble();
        System.out.print("Fyll i belopp att betala med (i SEK): ");
        amount = sc.nextDouble();
    }

    public static void Run(){
        change = amount - price;

        System.out.println("Växel:");
        if(change>=1000){
            temp = (int) change/1000;
            System.out.println(temp + " 1000-lappar");
            change = change % 1000;
        }
        if(change>=500){
            temp = (int) change/500;
            System.out.println(temp + " 500-lappar");
            change = change % 500;
        }
        if(change>=100){
            temp = (int) change/100;
            System.out.println(temp + " 100-lappar");
            change = change % 100;
        }
        if (change>=50){
            temp = (int) change/50;
            System.out.println(temp + " 50-lappar");
            change = change % 50;
        }
        if (change>=20){
            temp = (int) change/20;
            System.out.println(temp + " 20-lappar");
            change = change % 20;
        }
        if (change>=10){
            temp = (int) change/10;
            System.out.println(temp + " 10-kronor");
            change = change % 10;
        }
        if (change>=5){
            temp = (int) change/5;
            System.out.println(temp + "  5-kronor");
            change = change % 5;
        }
        if (change>=2){
            temp = (int) change/2;
            System.out.println(temp + " 2-kronor");
            change = change % 2;
        }
        if (change>=1){
            temp = (int) change/1;
            System.out.println(temp + " 1kronor");
        }
    }


}
