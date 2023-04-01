package Burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        //check how access to the attributes of class Item despite  they are private base is attribute of class Item
        //check Item does not have getters
        System.out.println(drink.name);
        side = new Item("Fries", "side", 2.50);
        this.conversionRate = conversionRate;
    }

    public double getTotal() {
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total due ", getTotal());
    }

    public void addToppings(String... selectToppings){
        burger.addToppings(selectToppings);
    }

    private class Item {
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            //check how access to the attributes of class Meal despite  they are private base is attribute of class Meal
            //check Meal does not have getters but you access to attribute base
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s %15s $%.2f".formatted(name, type, getPrice(price, conversionRate)); //check how call method static getPrice with out the name of clas like Item.getPrice
        }

        //since JDK 16 nos nio la posibilidad de tener miembros staticos dentro de clases anidadas
        public static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item {

        private enum Extra {AVOCADO, CHEESE, BACON, KETCHUP, MAYO, MUSTARD, PICKLES;
            //you can add methods in enum
            private double getPrice(){
                return switch (this){
                    case AVOCADO -> 1.0;
                    case BACON,CHEESE -> 1.5;
                    default -> 0;
                };
            }
        }

        ;

        public Burger(String name) {
            super(name, "Burger", 5.0);
        }

        private List<Item> toppings = new ArrayList<>();


        public double getPrice() {
        //    return super.price; //this is only correct because class Item is nested by class Meal. Si Item no estuviera dentro de Meal marcaria error.
            double total=super.price;
            for(Item topping:toppings){
                total+=topping.price;
            }
            return total;
        }
        private void addToppings(String... selectedToppings){
            for(String selectedTopping: selectedToppings){
                try {
                    Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
                    toppings.add(new Item(topping.name(), "topping", topping.getPrice()));
                }catch (IllegalArgumentException ie){
                    System.out.println("No topping found "+selectedTopping);
                }
            }
        }
        @Override
        public String toString(){
            StringBuilder itemized =new StringBuilder(super.toString());
            for (Item topping :toppings){
                itemized.append("\n");
                itemized.append(topping);
            }
            return itemized.toString();
        }
    }
}
