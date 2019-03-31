package BackGround;

public class Product {

    private GroupOfProduct groupGoods;      //товар групи
    private String name;            //імя товару
    private String description;     //опис товару
    private String manufacturer;           //виробник
    private int quantityInStock;    //кількість на складі
    private double price;           // ціна за одиницю товару

    public Product(GroupOfProduct groupGoods, String name, String manufacturer, double price){
        this.groupGoods = groupGoods;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    Product(GroupOfProduct groupGoods, String name, String description, String manufacturer, int quantityInStock, double price){
        this.groupGoods = groupGoods;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }


    public GroupOfProduct getGroupProducts() {
        return groupGoods;
    }

    public void setGroupProducts(GroupOfProduct groupGoods) {
        this.groupGoods = groupGoods;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String maker) {
        this.manufacturer = maker;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString (){
        return "Група " +groupGoods.getName()+ "	Товар "+name+"	Виробник "+manufacturer+"	Ціна " +price + "\n" ;
    }
}

