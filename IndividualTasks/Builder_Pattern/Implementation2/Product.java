import java.util.Date;

public class Product {
    private final int id;
    private String manufacture;
    private double weight;
    private String description;
    private Date expiryDate;

    public Product(int id, String manufacture, double weight, String description,Date expiryDate) {
        this.id = id;
        this.manufacture = manufacture;
        this.weight = weight;
        this.description = description;
        this.expiryDate = expiryDate;
    }

    //getters
    public long getId() {
        return id;
    }
    public String getManufacture() {
        return manufacture;
    }
    public double getWeight() {
        return weight;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getDescription() {
        return description;
    }

    //setters
    public void setManufacture(String manufacture){
        this.manufacture = manufacture;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "ID: "+this.id+", manufacturer: "+this.manufacture+", weight: "+this.weight+
                ", expiryDate: "+this.expiryDate+", description: "+this.description;
    }

}

class ProductBuilder {

    private final int id;
    private String manufacture;
    private Double weight;
    private String description;
    private Date expiryDate;

    public ProductBuilder(int id){
        this.id = id;
    }
    public ProductBuilder(int id, String manufacture, double weight, String description,Date expiryDate) {
        this.id = id;
        this.manufacture = manufacture;
        this.weight = weight;
        this.description = description;
        this.expiryDate = expiryDate;
    }
    public ProductBuilder setManufacture(String manufacture){
        this.manufacture = manufacture;
        return this;
    }
    public ProductBuilder setWeight(double weight){
        this.weight = weight;
        return this;
    }
    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    public ProductBuilder setExpiryDate(Date expiryDate){
        this.expiryDate = expiryDate;
        return this;
    }
    public Product build() {
        return new Product(id,manufacture,weight,description,expiryDate);
    }
}

class ProductMain {
    public static void main(String[] args) {
        Date date = new Date();
        Product product = new ProductBuilder(1).setManufacture("Cheetos").setWeight(50.00)
                .setDescription("bla bla bla bla").setExpiryDate(date).build();
        System.out.println(product);
    }

}
