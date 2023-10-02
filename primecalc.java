import java.util.Scanner;

public class primecalc {
    public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
        int t = 0;
        System.out.print("Enter the number of primes you would like: ");
        int anyNumber = keyboard.nextInt();

        // implement a for loop from starting 2 to anyNumber
        for (int i = 2; i <= anyNumber; i++) {
            if (anyNumber % i == 0) { // replace 2 with the for loop integer variable
                t = t + 1;
            }
        }
        if (t > 1) {
            System.out.println(anyNumber + " is not prime");
        } else {
            System.out.println(anyNumber + " is a prime");
        }

        keyboard.close();
    }
}
