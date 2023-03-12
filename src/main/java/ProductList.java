public class ProductList {

    String productName;
    double productPrice;
    String totalProductList;

    String addToProductList(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        Formatter formatter = new Formatter();
        return totalProductList = totalProductList + (productName + " - " + formatter.roundPrice(productPrice) + formatter.ruble(productPrice) + "\n");

    }

}
