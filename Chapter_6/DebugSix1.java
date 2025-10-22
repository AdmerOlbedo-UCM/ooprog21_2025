import java.util.Scanner;

public class DebugSix1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int days;
        double money = 0.01;
        System.out.print("Enter number of days >> ");
        days = keyboard.nextInt();
        
        // Double the money for each day after the first
        for (int i = 1; i < days; i++)
        {
            money = 2 * money;
        }
        
        // Print the total after the specified number of days
        System.out.println("After " + days + " days you have " + money);
    }
}
