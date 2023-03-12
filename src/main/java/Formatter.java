public class Formatter {
    double totalPrice;

    public String ruble(double totalPrice) {
        this.totalPrice = totalPrice;
        if ((int)this.totalPrice == 1) {
            return " рубль";
        }
        if ((int)this.totalPrice >= 2 && (int)this.totalPrice <= 4) {
            return " рубля";
        }
        return " рублей";
    }

    String roundPrice(double productPrice) {
        return String.format("%.2f", productPrice);
    }


}
