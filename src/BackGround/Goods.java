package BackGround;

public class Goods {

    private String groupGoods;      //товар групи
    private String name;            //імя товару
    private String description;     //опис товару
    private String maker;           //виробник
    private int quantityInStock;    //кількість на складі
    private double price;           // ціна за одиницю товару

    Goods(String groupGoods, String name, String description, String maker, int quantityInStock, double price){
        this.groupGoods = groupGoods;
        this.name = name;
        this.description = description;
        this.maker = maker;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }
    Goods(String name, String description, String maker, int quantityInStock, double price){
        this.name = name;
        this.description = description;
        this.maker = maker;
        this.quantityInStock = quantityInStock;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }
    Goods(String name, String maker, double price){
        this.name = name;
        this.maker = maker;
        this.price = price;
    }
    Goods(String name){
        this.name = name;
    }


    public String getGroupGoods() {
        return groupGoods;
    }

    public void setGroupGoods(String groupGoods) {
        this.groupGoods = groupGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
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
}

