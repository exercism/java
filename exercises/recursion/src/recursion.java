import java.util.Scanner;

public class recursion
{
    public static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("This is a basic program to demonstrate recursion");
        System.out.print("Please enter a number and an exponent (i.e. 5 2 => 5^2): ");
        int num = scnr.nextInt();
        int exponent = scnr.nextInt();
        System.out.println("\n" + num + " to the power of " + exponent + " = " + pow(num, exponent));
    }

    public static int pow(int num, int exponent)
    {
        if (exponent == 0)
            return 1;
        
        else if (exponent == 1)
            return num;
        
        else return num * pow(num, exponent - 1);
    }
}