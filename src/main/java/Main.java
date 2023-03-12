// dev branch for Y.Practicum
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        int guestInput;
        ProductList ProductList = new ProductList();
        Calculator Calculator = new Calculator();
        Formatter Formatter = new Formatter();

        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счёт?");

        while(true) {
            if(!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод количества человек, повторите попытку");
                scanner.next();
            } else {
                guestInput = scanner.nextInt();
                if(guestInput > 1) {
                    break;
                }
                System.out.println("Некорректное значение для подсчёта");
            }
        }
        System.out.println("Счет необходимо разделить на " + guestInput + " человек.");

        Calculator.countPerson = guestInput;
        while(true) {
            System.out.println("Введите название товара или команду Завершить");
            ProductList.productName = scanner.next();

            if (ProductList.productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость блюда");
            while(!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод цены, повторите попытку");
                scanner.next();
            }

            ProductList.productPrice = scanner.nextDouble();

            while(ProductList.productPrice <= 0) {
                System.out.println("Некорректная цена блюда, введите корректную цену");
                while(!scanner.hasNextDouble()) {
                    System.out.println("Некорректный ввод цены, повторите попытку");
                    scanner.next();
                }
                ProductList.productPrice = scanner.nextDouble();
            }

            ProductList.totalProductList = ProductList.addToProductList(ProductList.productName, ProductList.productPrice);
            Calculator.totalPrice = Calculator.totalPrice + ProductList.productPrice;
            System.out.println("Товар успешно добавлен в счет");
        }

        if (Calculator.totalPrice <= 0) {
            System.out.println("Вы ничего не заказывали, платить не за что");
        } else {

            System.out.println("Добавленные товары: \n" + ProductList.totalProductList);
            System.out.println(
                    "Каждый должен заплатить по "
                    + Formatter.roundPrice(Calculator.calcPricePerPerson(Calculator.countPerson, Calculator.totalPrice))
                    + Formatter.ruble(Calculator.calcPricePerPerson(Calculator.countPerson, Calculator.totalPrice))
            );
        }
        scanner.close();
    }
}
