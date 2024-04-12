import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> productMap = new HashMap<>();
    static double resultPrice;
    static double resultSum;
    static double resultBill;

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");

        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Это не число");
                System.out.println("Введите число");
                scanner.nextLine();
            } else {
                break;
            }
        }

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
            resultPrice = price;
            System.out.println(String.format("%s %.2f %s ", product, resultPrice, Formatter()));
        }

        for (double bill : productMap.values()) {
            resultPrice += bill;
            resultSum = resultPrice;
            System.out.println(String.format("Итого: %.2f %s ", resultPrice, Formatter()));

            resultBill = resultSum / man;
            System.out.println(String.format("Каждый человек должен заплатить: %.2f %s ", resultBill, Formatter()));
            break;
        }
    }

    public static String Formatter() {

        double number = 0;
        if (number == resultPrice || number == resultSum || number == resultBill) {
            number = resultPrice;
        } else if (number == resultSum) {
            number = resultSum;
        } else {
            number = resultBill;
        }

        double result = Math.floor(number);
        double ln1 = result % 10;
        double ln2 = result % 100;
        String currency;

        if (ln1 == 1 && ln2 != 11) {
            currency = "рубль";
        } else if (ln1 == 2 && ln2 != 12 || ln1 == 3 && ln2 != 13 || ln1 == 4 && ln2 != 14) {
            currency = "рубля";
        } else {
            currency = "рублей";
        }
        return currency;
    }
}