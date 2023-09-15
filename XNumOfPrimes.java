import java.util.Scanner;

public class XNumOfPrimes {
    public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
        int anyNumber = 1;
        int r = 0;
        System.out.print("Enter the number of primes you would like calculated: ");
        int n = keyboard.nextInt();

        while (r < n) {

            // implement a for loop from starting 2 to anyNumber
            anyNumber = anyNumber + 1;
            for (int i = 2; i <= anyNumber; i++) {
                if (anyNumber == i) {
                    // anyNymber is tested and is Prime
                    System.out.print(anyNumber + " ");
                    r = r + 1;
                } else if (anyNumber == 2) {
                    // 2 is prime
                    System.out.print(anyNumber + " ");
                    r = r + 1;
                } else if (anyNumber % i == 0) {
                    // anyNumber was tested and NOT prime so loop ended
                    break;
                }
            }
        }
        keyboard.close();
    }
}
