import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public int divisor;
    public int dividend;
    public int remainder;
    public int result;


    public void obtainNumbers(){
        boolean input1, input2;
        input1 = true; input2 = true;

        while(input1){
            System.out.print("Enter Divisor: ");
            divisor = exceptionCatch(divisor);
            input1 = false;
        }
        while(input2){
            System.out.print("Enter Dividend: ");
            dividend = exceptionCatch(dividend);

                while (dividend == 0){
                    System.out.print("You can't divide by 0! try again! ");
                    dividend = exceptionCatch(dividend);
            }
            input2 = false;
        }
    }

    private void calculator(int a, int b){
        result = 0;

        while(a >= b){
            a -= b;
            result++;
        }
        remainder = a;
    }

    public int exceptionCatch(int num){
        boolean run = true;
        Scanner scan = new Scanner(System.in);

        while(run) {
            try {
                num = scan.nextInt();
                run = false;
            } catch (InputMismatchException ex) {
                System.out.println("Integer expected. Try again...");
                scan.nextLine();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        boolean running = true;
        boolean input;
        int program = 0;

        Main obj = new Main();

        while(running){
            input = true;
            obj.obtainNumbers();
            obj.calculator(obj.divisor, obj.dividend);

            System.out.println(obj.divisor + " / " + obj.dividend + " = " + obj.result + " Remainder: " + obj.remainder);

            while(input){
                System.out.println("Continue? (1) (0)");
                program = obj.exceptionCatch(program);
                while(program > 1 || program < 0){
                    System.out.print("Selection out of range! Try again... ");
                    program = obj.exceptionCatch(program);
                }
                input = false;
            }

            if(program == 0){
                running = false;
            }
        }

    }
}