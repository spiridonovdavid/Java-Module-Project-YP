public class Formatter {
    double totalPrice;
    int preLastDigit;
    public String ruble(double totalPrice) {
        this.totalPrice = (int)totalPrice;
        this.preLastDigit = (int)this.totalPrice % 10;

        if((this.totalPrice % 100 >= 11) && (this.totalPrice % 100 <= 14)) {
            return " рублей";
        } else {
            switch ((int)this.totalPrice % 10) {
                case 1:
                    return " рубль";
                case 2:
                case 3:
                case 4:
                    return " рубля";
                default:
                    return " рублей";
            }
        }


    }

    String roundPrice(double productPrice) {
        return String.format("%.2f", productPrice);
    }


}
