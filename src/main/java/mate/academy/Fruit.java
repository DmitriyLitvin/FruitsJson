package mate.academy;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Fruit {
    private TypeOfFruit type;
    private int expirationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfDelivery;
    private double price;

    private Fruit () {

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
        return "mate.academy.Fruit{" +
                "type=" + type +
                ", expirationDate=" + expirationDate +
                ", dateOfDelivery=" + dateOfDelivery +
                ", price=" + price +
                '}';
    }
}
