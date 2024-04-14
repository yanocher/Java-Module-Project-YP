public class Chekker {
    public static void checkNamber() {
        //проверяем на число и что число > 0
        while (true) {
            String product = Main.scanner.nextLine();
            System.out.println("Введите стоимость товара:");

            if (Main.scanner.hasNextDouble()) {
                double price = Main.scanner.nextDouble();
                if (price > 0) {
                    Main.productMap.put(product, price);
                    Main.scanner.nextLine();
                    break;
                }
            } else {
                System.out.println("Это не число");
            }
        }
    }
}
