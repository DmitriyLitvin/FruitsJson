import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TradeShop tradeShop = new TradeShop();
        List<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit(TypeOfFruit.APPLE, 10, new Date(118, 4, 6), 10.23));
        fruits.add(new Fruit(TypeOfFruit.BANANA, 100, new Date(117, 11, 3), 23.12));
        fruits.add(new Fruit(TypeOfFruit.KIWI, 20, new Date(118, 10, 6), 100.01));
        fruits.add(new Fruit(TypeOfFruit.RASPBERRY, 50, new Date(107, 3, 6), 43.25));

        try {
            tradeShop.addFruits(fruits, "src/main/java/fruits.json");
            tradeShop.save("src/main/java/fruitsFromDatabase.json");
            tradeShop.load("src/main/java/fruitsFromDatabase.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        tradeShop.showDatabase();

        fruits = new ArrayList<Fruit>();
        fruits.add(new Fruit(TypeOfFruit.APPLE, 10, new Date(115, 12, 6), 4.23));
        fruits.add(new Fruit(TypeOfFruit.KIWI, 30, new Date(118, 10, 6), 144.50));
        fruits.add(new Fruit(TypeOfFruit.LEMON, 30, new Date(118, 10, 6), 144.50));

        try {
            tradeShop.addFruits(fruits, "src/main/java/fruits.json");
            tradeShop.save("src/main/java/fruitsFromDatabase.json");
            tradeShop.load("src/main/java/fruitsFromDatabase.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("\n");
        tradeShop.showDatabase();

        System.out.println("\n");
        System.out.println(tradeShop.getSpoiledFruits(new Date(115, 6, 6)));

        System.out.println("\n");
        System.out.println(tradeShop.getAvailableFruits(new Date(118, 10, 6)));

        System.out.println("\n");
        System.out.println(tradeShop.getSpoiledFruits(new Date(118, 10, 6), TypeOfFruit.LEMON));

        System.out.println("\n");
        tradeShop.showDatabase();

        System.out.println("\n");
        System.out.println(tradeShop.getAvailableFruits(new Date(118, 10, 6), TypeOfFruit.LEMON));

        System.out.println("\n");
        System.out.println(tradeShop.getAddedFruits(new Date(97, 6, 6)));

        System.out.println("\n");
        System.out.println(tradeShop.getAddedFruits(new Date(97, 6, 6), TypeOfFruit.BANANA));

        fruits = new ArrayList<Fruit>();

        fruits.add(new Fruit(TypeOfFruit.RASPBERRY, 10, new Date(97, 6, 6), 10.23));

        try {
            tradeShop.addFruits(fruits, "src/main/java/fruits.json");
            tradeShop.save("src/main/java/fruitsFromDatabase.json");
            tradeShop.load("src/main/java/fruitsFromDatabase.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        tradeShop.showDatabase();
    }
}
