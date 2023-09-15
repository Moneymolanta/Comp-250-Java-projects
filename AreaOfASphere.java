package HW;
/*
Name:
Semester/Year:
Desc:
I Received Help From: 
I affirm that my work upholds the highest standards of honesty and academic integrity at 
Wittenberg and that I have neither given nor received unauthorized assistance.
*/

import java.util.Scanner;
import java.lang.Math;

/**
 * calcArea, used to find area of a Sphere
 * 
 * 
 * pre-conditions: before run, numericrersentation needs to br passed thtough/
 * 
 * post-confitions: After run, the called method returns double represrntaypn of
 * area calulated nu p
 * 
 * @param r: r is a representsipn raidus
 * @return:
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