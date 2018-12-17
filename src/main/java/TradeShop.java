import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradeShop {
    private List<Fruit> fruits = new ArrayList<>();
    private final long DURATION_OF_DAY = 86400000; //24 * 60 * 60 * 1000 milli seconds;

    public void addFruitsToDatabase(Fruit fruit) {
        fruits.add(fruit);
    }

    public void showDatabase() {
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

    public void addFruits(List<Fruit> fruits, String pathToJsonFile) throws JsonProcessingException {
        this.fruits.addAll(fruits);
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(fruits);

        try {
            PrintWriter fileWriter = new PrintWriter(pathToJsonFile);
            fileWriter.write(content);
            fileWriter.close();
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String pathToJsonFile) throws JsonProcessingException {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(fruits);

        try {
            PrintWriter fileWriter = new PrintWriter(pathToJsonFile);
            fileWriter.write(content);
            fileWriter.close();
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Fruit> fruits;
        this.fruits.clear();

        try {
            String forDeserialize = readString(pathToJsonFile);
            StringReader reader = new StringReader(forDeserialize);
            fruits = mapper.readValue(reader, new TypeReference<ArrayList<Fruit>>() {
            });
            this.fruits.addAll(fruits);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> spoiledFruits = new ArrayList<Fruit>();
        for (int i = 0; i < fruits.size(); i++) {
            Date dateOfDelivery = fruits.get(i).getDateOfDelivery();
            int expirationDate = fruits.get(i).getExpirationDate();
            if ((int) ((date.getTime() - dateOfDelivery.getTime()) / DURATION_OF_DAY) >= expirationDate) {
                spoiledFruits.add(fruits.get(i));
            }
        }

        return spoiledFruits;
    }

    List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> availableFruits = new ArrayList<Fruit>();
        for (int i = 0; i < fruits.size(); i++) {
            Date dateOfDelivery = fruits.get(i).getDateOfDelivery();
            int expirationDate = fruits.get(i).getExpirationDate();
            if ((int) ((date.getTime() - dateOfDelivery.getTime()) / DURATION_OF_DAY) < expirationDate) {
                availableFruits.add(fruits.get(i));
            }
        }

        return availableFruits;
    }

    List<Fruit> getSpoiledFruits(Date date, TypeOfFruit type) {
        List<Fruit> spoiledFruits = getSpoiledFruits(date);
        for (int i = spoiledFruits.size() - 1; i >= 0; i--) {
            if (!spoiledFruits.get(i).getType().equals(type)) {
                spoiledFruits.remove(i);
            }
        }

        return spoiledFruits;
    }

    List<Fruit> getAvailableFruits(Date date, TypeOfFruit type) {
        List<Fruit> availableFruits = getAvailableFruits(date);
        for (int i = availableFruits.size() - 1; i >= 0; i--) {
            if (!availableFruits.get(i).getType().equals(type)) {
                availableFruits.remove(i);
            }
        }

        return availableFruits;
    }

    List<Fruit> getAddedFruits(Date date) {
        List<Fruit> addedFruits = new ArrayList<Fruit>();
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getDateOfDelivery().getTime() == date.getTime()) {
                addedFruits.add(fruits.get(i));
            }
        }

        return addedFruits;

    }

    List<Fruit> getAddedFruits(Date date, TypeOfFruit type) {
        List<Fruit> addedFruits = getAddedFruits(date);
        for (int i = addedFruits.size() - 1; i >= 0; i--) {
            if (!addedFruits.get(i).getType().equals(type)) {
                addedFruits.remove(addedFruits.get(i));
            }
        }

        return addedFruits;
    }

    private String readString(String pathToJsonFile) {
        String dataFromJsonFile = "";
        Path path = Paths.get(pathToJsonFile);
        try {
            List<String> strings = Files.readAllLines(path);
            for (String string:strings) {
                dataFromJsonFile += string;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataFromJsonFile;
    }

    @Override
    public String toString() {
        return "TradeShop{" +
                "fruits=" + fruits +
                '}';
    }
}
