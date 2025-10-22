import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final double INTEREST_RATE = 0.03;   
        double balance;
        int year;
        int choice;

        System.out.print("Enter initial balance >> ");
        balance = input.nextDouble();

        if (balance == 1) {
            balance = 100;
        }

        balance = balance * (1 + INTEREST_RATE); // end of year 1
        balance = balance * (1 + INTEREST_RATE); // end of year 2
        year = 2;

        System.out.printf("After year %d at %.2f interest rate, balance is $%.4f%n",
                          year, INTEREST_RATE, balance);

        do {
            System.out.println("\nDo you want to see the balance at the end of another year?");
            System.out.print("Enter 1 for yes or any other number for no >> ");
            choice = input.nextInt();

            if (choice == 1) {
                year++;
                balance = balance * (1 + INTEREST_RATE);
                System.out.printf("After year %d at %.2f interest rate, balance is $%.4f%n",
                                  year, INTEREST_RATE, balance);
            }
        } while (choice == 1);

        System.out.println("---- Program complete ----");
        input.close();
    }
}
