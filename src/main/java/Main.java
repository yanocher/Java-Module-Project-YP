import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> productMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");

        while (true) {
            int man = scanner.nextInt();
            if (man < 1) {
                System.out.println("Это некорректное значение");
                System.out.println("На скольких человек необходимо разделить счёт?");
            } else if (man == 1) {
                System.out.println("Введите значение больше 1");
                System.out.println("На скольких человек необходимо разделить счёт?");
            } else {
                System.out.println("Введите название и стоимость товара");
                break;
            }
        }

        while (true) {
            String product = scanner.next();
            double price = scanner.nextDouble();
            productMap.put(product, price);
            System.out.println("Товар успешно добавлен");
            System.out.println("Если хотите добавить ещё один товар введите 'Да', если нет, введите 'Завершить'");
            String command = scanner.next();
            if (!command.equals("Завершить")) {
                System.out.println("Введите название и стоимость товара");
            } else {
                //System.out.println(String.format("Добавленные товары:\n %s %.2f", product, price));
                System.out.println(String.format("Добавленные товары: " + productMap));
                break;
            }
        }

        /*System.out.println("Добавленные товары:");
        Iterator<String> mapIterator = productMap.keySet().iterator();
        while (mapIterator.hasNext()) {
            String products = mapIterator.next();
            System.out.println(String.format(products));
        }*/

        System.out.println("Добавленные товары:");

        Iterator<Map.Entry<String, Double>> mapiterator = productMap.entrySet().iterator();
        Map.Entry<String, Double> entry = mapiterator.next();
        String key = entry.getKey();
        double value = entry.getValue();
        System.out.println(String.format(key, value));

    }
}
