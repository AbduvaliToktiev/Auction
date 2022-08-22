import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connect connect = new Connect();
        Product product = new Product();
        connect.connection();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("Вывести список всех товаров");
            System.out.println("Вывести список товаров находящихся на складе");
            System.out.println("Вывести список товаров находящихся на аукционе");
            System.out.println("Вывести список проданных товаров");
            System.out.println("Выход из программы");
            String choice = sc.nextLine();
            switch (choice) {
                case "Вывести список всех товаров":
                    // Метод для ввывода всех товаров
                    List<Product> products = connect.productList();
                    for (Product p : products) {
                        System.out.println(p);
                        System.out.println("----------");
                    }
                    break;
                case "Вывести список товаров находящихся на складе":
                    // Метод для ввывода товаров находящихся на складе

                case "Вывести список товаров находящихся на аукционе":
                    // Метод для ввывода товаров находящихся на аукционе

                case "Вывести список проданных товаров":
                    // Метод для ввывода проданных товаров

                case "Выход из программы":
                    System.exit(0);
                    break;
                default:
                    System.out.println("-------------------------------------------------------------");
                    System.err.println("Ошибка. Введите название из меню!!!");
            }
        }
    }
}
