import java.util.Scanner;
import java.lang.Math;

/**
 * calcArea, used to find area of a Sphere
 * 
 */
public class AreaOfASphere {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter the Radius: ");
    // user promted to enter "radius"
    int radius = 0;
    radius = keyboard.nextInt();

    double area = 4 * Math.PI * Math.pow(radius, 2);

    System.out.printf("Area = %.2f", area);

    keyboard.close();
  }
}
