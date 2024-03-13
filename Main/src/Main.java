import java.time.*;
import java.util.Scanner;


public class Main {
    public static boolean isUnder10(int age) {
        return age < 10;
    }

    public static boolean isUnder18(int age) {
        return age < 18;
    }

    public static boolean isFromWarsaw(String city) {
        return city.equals("Warsaw");
    }

    public static boolean isThursday() {
        return LocalDate.now().getDayOfWeek().name().equals("THURSDAY");
    }

    public static int checkDiscount(int age, String city) {
        int discount = 0;
        if (isThursday() || isUnder10(age)) {
            return 100;
        }
        if (isUnder18(age)) {
            discount += 50;
        }
        if (isFromWarsaw(city)) {
            discount += 10;
        }
        return discount;
    }

    public static double checkPrice(int discount) {
        return 40 - (40 * discount * 0.01);
    }

    public static String toString(LocalDate date, String city, int age, String dayOfTheWeek, double price, int discount) {
        return date + ": " + city + ", " + age + " years old, " + dayOfTheWeek + " Ticket price: " + price +
                " PLN " + "Discount: " + discount + "%";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give age: ");
        int age = sc.nextInt();

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Give city: ");
        String city = sc2.nextLine();

        System.out.println("Checking current date...");
        LocalDate date = LocalDate.now();
        String dayOfTheWeek = date.getDayOfWeek().name();

        int discount = checkDiscount(age, city);
        double price = checkPrice(discount);

        System.out.println(toString(date, city, age, dayOfTheWeek, price, discount));
    }
}