/*
Name:
Semester/Year:
Desc:
I Received Help From:
I affirm that my work upholds the highest standards of honesty and academic integrity at 
Wittenberg and that I have neither given nor received unauthorized assistance.
*/

import java.util.Scanner;

public class PrimeNumsToY {
    public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
        int t = 0;
        int anyNumber = 1;
        int r = 2;
        System.out.print("What is the limit of Prime numbers?: "); // Prompt user to
        int n = keyboard.nextInt();

        // The numbers from 1 to N
        while (r <= n) {
            t = 1;
            anyNumber = anyNumber + 1;

            // for loop to count up numbers and determine if they are prime
            for (int i = 2; i <= anyNumber / 2; i++) {
                if (anyNumber % i == 0) {
                    t = 0;
                    break;
                }
            }

            // If t is 1, then prime
            if (t == 1) {
                System.out.print(anyNumber + " ");
            }
            r = r + 1;
        }
        keyboard.close();
    }
}