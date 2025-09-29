
import java.util.Scanner;

public class DebugFour2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String color;
        String point;

        System.out.print("Enter a color ink for the pen >> ");
        color = input.nextLine();
        System.out.print("Enter a point size - fine, medium, or thick >> ");
        point = input.nextLine();

                DebugPen pen1 = new DebugPen();

                DebugPen pen2 = new DebugPen(color, point);

        System.out.println("\nDefault value pen:");
        display(pen1);

        System.out.println("\nUser value pen:");
        display(pen2);
    }

    public static void display(DebugPen p) {
        System.out.println(" The pen has ink color " + p.getColor());
        System.out.println(" and a " + p.getPoint() + " point.");
    }
}

class DebugPen {
    private String color;
    private String point;

    
    public DebugPen() {
        color = "black";     
        point = "medium";       }

        public DebugPen(String color, String point) {
        this.color = color;
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public String getPoint() {
        return point;
    }
}
