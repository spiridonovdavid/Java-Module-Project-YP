// dev branch for Y.Practicum
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        int guestInput;
        ProductList productList = new ProductList();
        Calculator calculator = new Calculator();
        Formatter formatter = new Formatter();

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

        calculator.countPerson = guestInput;
        while(true) {
            System.out.println("Введите название товара или команду Завершить");
            productList.productName = scanner.next();

            if (productList.productName.equalsIgnoreCase("Завершить")) {
                break;
            }
            System.out.println("Введите стоимость блюда");
            while(!scanner.hasNextDouble()) {
                System.out.println("Некорректный ввод цены, повторите попытку");
                scanner.next();
            }

            productList.productPrice = scanner.nextDouble();

            while(productList.productPrice <= 0) {
                System.out.println("Некорректная цена блюда, введите корректную цену");
                while(!scanner.hasNextDouble()) {
                    System.out.println("Некорректный ввод цены, повторите попытку");
                    scanner.next();
                }
                productList.productPrice = scanner.nextDouble();
            }

            productList.totalProductList = productList.addToProductList(productList.productName, productList.productPrice);
            calculator.totalPrice = calculator.totalPrice + productList.productPrice;
            System.out.println("Товар успешно добавлен в счет");
        }

        if (calculator.totalPrice <= 0) {
            System.out.println("Вы ничего не заказывали, платить не за что");
        } else {

            System.out.println("Добавленные товары: \n" + productList.totalProductList);
            System.out.println(
                    "Каждый должен заплатить по "
                    + formatter.roundPrice(calculator.calcPricePerPerson(calculator.countPerson, calculator.totalPrice))
                    + formatter.ruble(calculator.calcPricePerPerson(calculator.countPerson, calculator.totalPrice))
            );
        }
        scanner.close();
    }
}
