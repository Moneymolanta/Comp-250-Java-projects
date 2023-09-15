
/*
Name: Joel Mohammed-Paige
Semester/Year: Spring 23/2023
Desc:
I Received Help From:
I affirm that my work upholds the highest standards of honesty and academic
integrity at
Wittenberg and that I have neither given nor received unauthorized
assistance.
*/
public class Menu {

    protected String type;
    protected String name;
    protected Double price;
    protected String diet;
    protected int calories;
    protected String alcohol;

    Menu() {
        this.type = " ";
        this.name = " ";
        this.price = 0.00;
        this.diet = " ";
        this.calories = 0;
        this.alcohol = " ";
    }

    Menu(String type, String name, double price, String diet, int calories, String alcohol) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.diet = diet;
        this.calories = calories;
        this.alcohol = alcohol;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getDiet() {
        return this.diet;
    }

    public int getCalories() {
        return this.calories;
    }

    public String getAlcohol() {
        return this.alcohol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String toString() {
        return this.name + " is $" + this.price + " and " + this.calories + " calories.";
    }

}

// Ok so here's how this is going to happen, the user will be able
// to add food to their recipt the same way students are added to the example
// program