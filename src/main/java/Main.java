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

        //проверяем на число
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Это не число");
                System.out.println("Введите число");
                scanner.nextLine();
            } else {
                break;
            }
        }

        //проверяем число чтобы не <= 1
        int man;
        while (true) {
            man = scanner.nextInt();
            scanner.nextLine();

            if (man < 1) {
                System.out.println("Это некорректное значение");
                System.out.println("На скольких человек необходимо разделить счёт?");
            } else if (man == 1) {
                System.out.println("Введите значение больше 1");
                System.out.println("На скольких человек необходимо разделить счёт?");
            } else {
                System.out.println("Введите название товара:");
                break;
            }
        }

        //проверяем на число и что число > 0
        Chekker.checkNamber();

        //спрашиваем добавление товара, завершаем или проверяем на число и что число > 0
        while (true) {
            System.out.println("Товар успешно добавлен");
            System.out.println("Если хотите добавить ещё один товар введите 'Да', если нет, введите 'Завершить':");
            String command = scanner.nextLine();

            if (!command.equalsIgnoreCase("Завершить")) {
                System.out.println("Введите название товара:");
                Chekker.checkNamber();
            } else {
                System.out.println("Добавленные товары:");
                break;
            }
        }

        //выводим добавленные товары
        for (Map.Entry<String, Double> entry : productMap.entrySet()) {
            String product = entry.getKey();
            double price = entry.getValue();
            resultPrice = price;
            System.out.println(String.format("%s %.2f %s ", product, resultPrice, Formatter.formatCurrency()));
        }

        //выводим сумму добавленных товаров
        for (double bill : productMap.values()) {
            resultPrice += bill;
            resultSum = resultPrice;
            System.out.println(String.format("Итого: %.2f %s ", resultPrice, Formatter.formatCurrency()));
            //выводим сумму каждого чека добавленных товаров
            resultBill = resultSum / man;
            System.out.println(String.format("Каждый человек должен заплатить: %.2f %s ", resultBill, Formatter.formatCurrency()));
            break;
        }
    }
}