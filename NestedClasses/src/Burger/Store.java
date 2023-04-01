package Burger;

public class Store {
    public static void main(String[] args) {
        Meal meal =new Meal();
        meal.addToppings("Ketchup","Mayo","Bacon","Aguacate");
        System.out.println(meal);

        Meal usMeal=new Meal(18.03);
        System.out.println(usMeal);

    }
}
