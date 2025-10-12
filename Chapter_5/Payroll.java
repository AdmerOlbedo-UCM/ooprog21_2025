import java.util.Scanner;

public class Payroll {

    // Inner class for Employee (inside the same file)
    static class Employee {
        private int employeeNumber;
        private double payRate;
        private static final int MAX_EMPLOYEE_NUMBER = 9999;
        private static final double MAX_RATE = 60.00;
        private static final double OVERTIME_MULTIPLIER = 1.5;

        public Employee(int employeeNumber, double payRate) {
            if (employeeNumber > MAX_EMPLOYEE_NUMBER)
                employeeNumber = MAX_EMPLOYEE_NUMBER;
            if (payRate > MAX_RATE)
                payRate = MAX_RATE;

            this.employeeNumber = employeeNumber;
            this.payRate = payRate;
        }

        public double getRegularPay(double hoursWorked) {
            if (hoursWorked > 40)
                return 40 * payRate;
            else
                return hoursWorked * payRate;
        }

        public double getOvertimePay(double hoursWorked) {
            if (hoursWorked > 40)
                return (hoursWorked - 40) * payRate * OVERTIME_MULTIPLIER;
            else
                return 0.0;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many hours did you work this week? ");
        double hoursWorked = input.nextDouble();

        System.out.print("What is your regular pay rate? ");
        double payRate = input.nextDouble();

        // Create Employee object
        Employee emp = new Employee(1001, payRate);

        double regularPay = emp.getRegularPay(hoursWorked);
        double overtimePay = emp.getOvertimePay(hoursWorked);

        System.out.println("Regular pay is " + regularPay);
        System.out.println("Overtime pay is " + overtimePay);

        input.close();
    }
}
