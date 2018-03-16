import java.util.Scanner;

public class Calculator {

    Scanner sc = new Scanner(System.in);
    int a, b;
    char argOp;
    float sum;

    public Calculator(){
        System.out.println("Calculator created!");
        System.out.println("*********************");
    }

    public void TakeInput(){
        System.out.println("Valid operators are '+, -, *, /'");
        System.out.println("Input an expression as 'a ? b':");
        String input = sc.nextLine();
        String[] args;
        args = input.split("\\s+");
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[2]);
        argOp = args[1].charAt(0);
    }

    public void Calc() throws OperatorNotSupportedException{
        switch(argOp){

            case '*':
                sum = a*b;
                break;

            case '-':
                sum = a-b;
                break;

            case'+':
                sum = a+b;
                break;

            case'/':
                sum = a/b;
                break;

            default:
                throw new OperatorNotSupportedException("Operator not supported");
        }
    }

    public void PrintSum(){
        System.out.println("Sum:" + sum);
    }
}
