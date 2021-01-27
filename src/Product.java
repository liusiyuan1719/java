public class Product {
    private String id;
    private String productname;
    private Float price;
    private String desc   ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setPrice(Float price) { this.price = price; }

    public Float getPrice() { return price; }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
