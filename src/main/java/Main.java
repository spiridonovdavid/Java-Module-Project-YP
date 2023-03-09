// dev branch for Y.Practicum
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int guestInput;

        while(true) {

            System.out.println("На скольких человек необходимо разделить счёт?");
            guestInput = scanner.nextInt();
            if(guestInput > 1) {
                System.out.println("all ok");
                break;
            }
            if (guestInput == 1 ) {
                System.out.println("Не на кого делить, вы кушали один, к сожалению придется оплатить счет именно вам :)");
            }
            if (guestInput < 1) {
                System.out.println("Некорректное значение для подсчёта");
            }

        }

        scanner.close();
    }
}
