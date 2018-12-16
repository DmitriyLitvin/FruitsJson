import java.time.LocalDate;
import java.util.Date;

public class Fruit {
    private TypeOfFruit type;
    private int expirationDate;
    private Date dateOfDelivery;
    private double price;

    public Fruit () {

    }

    public Fruit(TypeOfFruit type, int expirationDate, Date dateOfDelivery, double price) {
        this.type = type;
        this.expirationDate = expirationDate;
        this.dateOfDelivery = dateOfDelivery;
        this.price = price;
    }

    public void setType(TypeOfFruit type) {
        this.type = type;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeOfFruit getType() {
        return type;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "type=" + type +
                ", expirationDate=" + expirationDate +
                ", dateOfDelivery=" + dateOfDelivery +
                ", price=" + price +
                '}';
    }
}
