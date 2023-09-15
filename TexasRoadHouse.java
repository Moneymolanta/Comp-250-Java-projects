
/*
Name: Joel Mohammed-Paige
Semester/Year: Spring 2023
Desc: A program using parent-child class funtions to simulate someone visiting "Texas Roadhouse"
I Received Help From: Cal Tipson (Upper Classman Friend/Former TA)
I affirm that my work upholds the highest standards of honesty and academic integrity at 
Wittenberg and that I have neither given nor received unauthorized assistance.
*/
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class TexasRoadHouse {

    private static String descison1;
    private static Menu f; // var
    private static Menu v;
    private static Menu d;
    private static double choiceP;
    private static double dChoiceP = 0.0; // drink choice price
    private static double fChoiceP = 0.0; // food choice price
    private static double vChoiceP = 0.0; // vegan choice price
    private static double total = 0.0;

    public static ArrayList<Menu> readFile() throws Exception {
        ArrayList<Menu> list = new ArrayList<>();
        File input = new File("Menu.txt");
        Scanner reader = new Scanner(input);
        while (reader.hasNextLine()) {
            // A file line is formatted as:
            // item type, name price, and price
            String line = reader.nextLine();
            String[] token = line.split(", ");
            // token[0] is type, token[1] is name, and token [2] is price
            Menu newItem = new Menu(token[0], token[1], Double.valueOf(token[2]), token[3], Integer.parseInt(token[4]),
                    token[5]);
            list.add(newItem);
        }
        reader.close();
        return list;
    }

    public static void recipt(ArrayList<Menu> fullMenu) {
        int count = 0;
        System.out.println("Your current items are: \n");
        if (d != null) {
            fullMenu.add(d);
            System.out.println(d);
        }
        if (v != null) {
            fullMenu.add(v);
            System.out.println(v);
        }
        if (f != null) {
            fullMenu.add(f);
            System.out.println(f);
        }
        for (int i = 0; i < fullMenu.size(); i++) {
            count++;
            if (count > 33) {
                System.out.println(fullMenu.get(i) + " ");
            }
        }
    }

    public static void addItem(Scanner keyboard, ArrayList<Menu> fullMenu) {
        // print entire menu
        int count = 0;
        for (int i = 0; i < fullMenu.size(); i++) {
            count++;
            if (count < 33) {
                System.out.println(count + ": " + fullMenu.get(i) + " ");
            }
        }

        System.out.println("\nPlease choose the item you'd like to add:");

        int choice = 0;
        while (choiceP == 0.0) {
            choice = keyboard.nextInt();
            if (choice >= 1 && choice <= 33) {
                choice -= 1;
                f = fullMenu.get(choice);
                choiceP = f.getPrice();
            } else if (choice == 34) {
                System.out.println("Alrighty then!\n");
                break;
            }
            if (choiceP == 0.0) { // if the user input something that was not valid, they are promted to try again
                System.out.println("I'm sorry, what was that?");
            }
        }

    }

    public static void removeItem(Scanner keyboard, ArrayList<Menu> fullMenu) {
        Menu deleteMe = new Menu();
        // Display recipt
        int count = 0;
        for (Menu s : fullMenu) {
            count++;
            if (count > 33) {
                System.out.println(count - 33 + ": " + s.toString());
            }
        }
        int userChoice = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Please enter the you'd like to remove: ");
            userChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (userChoice < 0 || userChoice > count - 33) { // if input is out of bounds
                // wrong input
            } else {
                isValid = true;
            }
        }

        deleteMe = fullMenu.get(userChoice + 32); // offset user input by 32
        System.out.println("\nRemoving:  ");
        System.out.println(deleteMe.toString());

        fullMenu.remove(userChoice + 32);

        System.out.println("Your current items are:\n");
        recipt(fullMenu);
        total = Math.round(((fChoiceP + dChoiceP + vChoiceP + choiceP) - deleteMe.getPrice()) * 100.0) / 100.0;

        System.out.println("\nTotal: " + total);
    }

    public static void main(String[] args) {
        // Establishing all the filter variables
        int count = 0;
        Scanner keyboard = new Scanner(System.in);
        Boolean path0 = false;
        Boolean path1 = false;
        int path2 = 0;

        class sortCalories implements Comparator<Menu> {
            public int compare(Menu a, Menu b) {
                return a.getCalories() - b.getCalories();
            }
        }

        ArrayList<Menu> fullMenu = new ArrayList<>();
        try {
            fullMenu = readFile();
        } catch (Exception e) {
            System.out.println("Could not read input file. . .");
            keyboard.close();
            return; // close program - no input file available
                    // equivalently: System.exit(0);
        }

        // Promts the user to oder drink to be taken to that menu or the food menu
        while (true) { // Infinite Loop for Programs Run
            System.out.println("\nWelcome to Texas Roadhouse! May I start you off with a drink (y/n)");
            String decision0 = keyboard.next();
            if (decision0.toLowerCase().equals("yes") || decision0.toLowerCase().equals("y")) {
                System.out.println("Wonderful! What would you like?");
                path0 = true;
                break;
            } else if (decision0.toLowerCase().equals("no") || decision0.toLowerCase().equals("n")) {
                System.out.println("\nUnderstood, in that case here is our menu.\n");
                System.out.println("Are you vegan? (If so please say yes)");
                descison1 = keyboard.next();
                if (descison1.toLowerCase().equals("yes") || descison1.toLowerCase().equals("y")) {
                    path1 = true;
                }
                break;
            } else {
                System.out.println("I'm sorry, I don't think I heard you.\n");
            }
        }

        /*
         * path 0 is where user gets a drink and are shown the drink menu,
         * path 1 is for printing vegan items of the menu and then taken to
         * food items, otherwise both paths are skipped to go straight to
         * the food menu
         */

        if (path0 == true) {
            // Print Drink Menu
            for (int i = 0; i < fullMenu.size(); i++) {
                count++;
                if (fullMenu.get(i).getType().equals("Drink")) {
                    System.out.println(count + ": " + fullMenu.get(i) + " ");
                }
            }
            // Allowing the user to select an item from the menu and making sure it is
            // actully found on said menu
            while (dChoiceP == 0.0) {
                System.out.println("\nPlease enter the number you'd like to order:");
                int dChoice = keyboard.nextInt();
                if (dChoice >= 1 && dChoice <= 16) {
                    dChoice -= 1;
                    d = fullMenu.get(dChoice);
                    dChoiceP = d.getPrice();
                }
                if (dChoiceP == 0.0) { // if the user input something that was not valid, they are promted to try again
                    System.out.println("I'm sorry, what was that?");
                }
            }
            if (d.getAlcohol().equals("alcoholic")) {
                System.out.println("Oh wow.. It's 10am but ok I guess..");
            } else {
                // Once the loop is finished, the user is taken to the order a food item
                System.out.println("\nGreat! I'll have those right out for you, in the meantime here is our menu:\n");
            }

            // Another filter to only show objects with the subclass "vegan", then print it
            System.out.println("Are you vegan? (If so please say yes)");
            String descison1 = keyboard.next();
            if (descison1.toLowerCase().equals("yes") || descison1.toLowerCase().equals("y")) {
                path1 = true;
            } else {
                System.out.println("Alrighty then!\n");
            }
        }
        if (path1 == true) {
            count = 0;
            for (int i = 0; i < fullMenu.size(); i++) {
                count++;
                if (fullMenu.get(i).getDiet().equals("Vegan") && fullMenu.get(i).getType().equals("Food")) {
                    System.out.println((count - 26) + ": " + fullMenu.get(i) + " ");
                }
            }
            System.out.println("3: Nothing");
            while (vChoiceP == 0.0) {
                System.out.println("\nPlease enter the number you'd like to order:");
                int vChoice = keyboard.nextInt();
                if (vChoice >= 1 && vChoice <= 2) {
                    vChoice += 25; // adding 25 otherwise the user input (dchoice) would fall into a different
                                   // section
                    v = fullMenu.get(vChoice);
                    vChoiceP = v.getPrice();
                } else if (vChoice == 3) {
                    System.out.println("Alrighty then!\n");
                    break;
                }
                if (vChoiceP == 0.0) { // if the user input something that was not valid, they are promted to try
                                       // again
                    System.out.println("I'm sorry, what was that?");
                }
            }
        }

        // Print unsorted Food Menu
        count = 0;
        for (int i = 0; i < fullMenu.size(); i++) {
            count++;
            if (fullMenu.get(i).getType().equals("Food") && !fullMenu.get(i).getDiet().equals("Vegan")) {
                System.out.println((count - 16) + ": " + fullMenu.get(i) + " ");
            }
        }
        System.out.println("18: Nothing");
        // The following asks if the user would want the menu sorted by calories and
        // print it, but ignored otherwise
        System.out.println("\nWould you like to sort by calories?");
        String yesSort = keyboard.next();
        if (yesSort.toLowerCase().equals("yes") || yesSort.toLowerCase().equals("y")) {
            Collections.sort(fullMenu, new sortCalories());
            System.out.println("\nSorted by Calories:");
            count = 0;
            for (int i = 0; i < fullMenu.size(); i++) {
                // count for the sorted items
                if (fullMenu.get(i).getType().equals("Food") && !fullMenu.get(i).getDiet().equals("Vegan")) {
                    System.out.println((count - 16) + ": " + fullMenu.get(i) + " ");
                }
            }
            while (fChoiceP == 0.0) {
                System.out.println("\nPlease enter the number you'd like to order:");
                int fChoice = keyboard.nextInt();
                if (fChoice >= 3 && fChoice <= 19) {
                    fChoice += 15; // adding 15 otherwise the user input (fchoice) would fall into a different
                                   // section
                    f = fullMenu.get(fChoice);
                    fChoiceP = f.getPrice();
                } else if (fChoice == 18) {
                    System.out.println("Alrighty then!\n");
                    break;
                }
                if (fChoiceP == 0.0) { // if the user input something that was not valid, they are promted to try again
                    System.out.println("I'm sorry, what was that?");
                }
            }
        }
        // this will determine whether the user input is valid
        while (fChoiceP == 0.0) {
            System.out.println("\nPlease enter the number you'd like to order:");
            int fChoice = keyboard.nextInt();
            if (fChoice >= 1 && fChoice <= 17) {
                fChoice += 15; // adding 15 otherwise the user input (fchoice) would fall into a different
                               // section
                f = fullMenu.get(fChoice);
                fChoiceP = f.getPrice();
            } else if (fChoice == 18) {
                System.out.println("Alrighty then!\n");
                break;
            }
            if (fChoiceP == 0.0) { // if the user input something that was not valid, they are promted to try again
                System.out.println("I'm sorry, what was that?");
            }
        }
        total = Math.round((fChoiceP + dChoiceP + vChoiceP + choiceP) * 100.0) / 100.0;
        System.out.println("\nYour current items are:\n");
        recipt(fullMenu);
        System.out.println("Total: " + total);

        while (true) {
            System.out.println("\nWould you like to add or remove anything? (y/n)");
            String edit = keyboard.next();

            if (edit.equals("y")) {
                System.out.println("\n1: add \n2: remove");
                path2 = keyboard.nextInt();
            } else {
                System.out.println("Understood, I hope you enjoy your meal and have a wonderful day!"); // exit program
                break;
            }
            total = Math.round((fChoiceP + dChoiceP + vChoiceP + choiceP) * 100.0) / 100.0;
            System.out.println("\nYour current items are:");

            // Handle user input
            // user cannont add or remove more than 1 item properly, and I was unable to fix
            // it
            if (path2 == 1) {
                addItem(keyboard, fullMenu);
                total = Math.round((fChoiceP + dChoiceP + vChoiceP + choiceP) * 100.0) / 100.0;
                recipt(fullMenu);
                System.out.println("Total: " + total + "\n\nAnything else? (y/n)");
                String path3 = keyboard.next();
                path2 = 0;
                if (path3.toLowerCase().equals("n")) {
                    System.out.println("\nUnderstood, I hope you enjoy your meal and have a wonderful day!");
                    break;
                }
            } else if (path2 == 2) {
                removeItem(keyboard, fullMenu);
                path2 = 0;
            } else {
                System.out.println("What?");
            }
        }
        keyboard.close();
    }
}