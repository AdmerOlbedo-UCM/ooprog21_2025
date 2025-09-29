import java.util.Scanner;

public class DebugFour1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int radius;

        System.out.print("Enter a radius for a circle >> ");
        radius = input.nextInt();

        // directly create DebugCircle with radius
        DebugCircle c = new DebugCircle(radius);

        System.out.println("The radius is " + c.getRad());
        System.out.println("The diameter is " + c.getDiam());
        System.out.println("The area is " + c.getArea());
    }
}

// DebugCircle class inside the same file
class DebugCircle {
    private double radius;

    // constructor
    public DebugCircle(double r) {
        radius = r;
    }

    public double getRad() {
        return radius;
    }

    public double getDiam() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
