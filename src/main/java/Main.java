import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> productMap = new HashMap<>();
    public double sum;

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");

        Main format = new Main();
        String rub = format.Formatter();

        int man;
        while (true) {
            man = scanner.nextInt();
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
            if (!command.equalsIgnoreCase("Завершить")) {
                System.out.println("Введите название и стоимость товара");
            } else {
                System.out.println("Добавленные товары:");
                break;
            }
        }

        for (Map.Entry<String, Double> entry : productMap.entrySet()) {
            String product = entry.getKey();
            double price = entry.getValue();
            System.out.println(String.format("%s %.2f %s ", product, price, rub));
        }

        double sum = 0;
        for (double bill : productMap.values()) {
            sum += bill;
        }

        System.out.println(String.format("Итого: %.2f %s ", sum, rub));
        double separateBill = sum / man;
        System.out.println(String.format("Каждый человек должен заплатить: %.2f %s ", separateBill, rub));
    }

    public String Formatter() {

        double number = sum;
        double result = Math.floor(number);
        double ln1 = result % 10;
        double ln2 = result % 100;
        String currency;

        if (ln1 == 1 & ln2 != 11) {
            currency = "рубль";
        } else if (ln1 == 2 & ln2 != 12 | ln1 == 3 & ln2 != 13 | ln1 == 4 & ln2 != 14) {
            currency = "рубля";
        } else {
            currency = "рублей";
        }
        return currency;
    }
}