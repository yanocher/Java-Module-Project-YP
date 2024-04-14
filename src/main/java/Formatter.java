public class Formatter {
    public static String formatCurrency() {
        //импортируем число, сумму и чек каждого товара
        double number = 0;
        if (number == Main.resultPrice || number == Main.resultSum || number == Main.resultBill) {
            number = Main.resultPrice;
        } else if (number == Main.resultSum) {
            number = Main.resultSum;
        } else {
            number = Main.resultBill;
        }
        //округляем вниз до цеолого числа
        double result = Math.floor(number);
        double ln1 = result % 10;
        double ln2 = result % 100;
        String currency;
        //отдаем значения "рубля" своим адресатам
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
