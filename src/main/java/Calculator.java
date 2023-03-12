public class Calculator {
    int countPerson;
    double totalPrice;
    double personPrice;


    double calcPricePerPerson(int countPerson, double totalPrice) {
        this.totalPrice = totalPrice;
        this.countPerson = countPerson;
        return personPrice = this.totalPrice / this.countPerson;
    }
}
