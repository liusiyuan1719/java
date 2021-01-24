import java.sql.Date;

public class Order {
    private User user;
    private Product products[];
    private int ammount;
    private float totalPay;
    private float actualPay;
    private Date orderDate;

    public void setUser(User user) { this.user = user; }
    public void setProducts(Product[] products) { this.products = products; }
    public void setAmmount(int ammount) { this.ammount = ammount; }
    public void setTotalPay(float totalPay) { this.totalPay = totalPay; }
    public void setActualPay(float actualPay) { this.actualPay = actualPay; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public User getUser() {
        return user;
    }
    public Product[] getProducts() {
        return products;
    }
    public int getAmmount() {
        return ammount;
    }
    public float getTotalPay() {
        return totalPay;
    }
    public float getActualPay() {
        return actualPay;
    }
    public Date getOrderDate() {
        return orderDate;
    }

}
