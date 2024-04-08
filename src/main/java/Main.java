import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Double> productMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");

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
            System.out.println(String.format("%s %.2f рублей", product, price));
        }

        double sum = 0;
        for (double bill : productMap.values()) {
            sum += bill;
        }
        System.out.println(String.format("Итого: %.2f рублей", sum));
        double separateBill = sum / man;
        System.out.println(String.format("Каждый человек должен заплатить: %.2f рублей", separateBill));
    }

}
class Formatter {
    static double number = 211.56;
    public static void main(String[] args) {

        double result = Math.floor(number);
        double ld1 = result % 10;
        double ld2 = result % 100;
        System.out.println(number);

        if (ld1 == 1 & ld2 != 11) {
            String rub = "рубль";
            System.out.println(rub);
        } else if (ld1 == 2 & ld2 != 12 | ld1 == 3 & ld2 != 13 | ld1 == 4 & ld2 != 14) {
            String rub = "рубля";
            System.out.println(rub);
        } else {
            String rub = "рублей";
            System.out.println(rub);
        }
    }
}



