import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static void main(String[] args) {
        // Input amount
        double payment = 12324.134;

        // Create Locale objects for US, India, China, and France
        Locale usLocale = new Locale("en", "US");
        Locale indiaLocale = new Locale("en", "IN");
        Locale chinaLocale = new Locale("zh", "CN");
        Locale franceLocale = new Locale("fr", "FR");

        // Get currency formatters for each locale
        NumberFormat usFormatter = NumberFormat.getCurrencyInstance(usLocale);
        NumberFormat indiaFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chinaFormatter = NumberFormat.getCurrencyInstance(chinaLocale);
        NumberFormat franceFormatter = NumberFormat.getCurrencyInstance(franceLocale);

        // Format the payment amount for each locale
        String us = usFormatter.format(payment);
        String india = indiaFormatter.format(payment);
        String china = chinaFormatter.format(payment);
        String france = franceFormatter.format(payment);

        // Print the formatted currency values
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
