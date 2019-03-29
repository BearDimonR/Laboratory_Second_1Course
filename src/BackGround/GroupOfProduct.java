package BackGround;
public class GroupOfProduct {

    Product[] goods = new Product[0];

    private String stock;               //склад
    private String name;                //ім’я групи товарів (продовольчі не продовольчі)
    private String description;         //опис

    GroupOfProduct(String stock, String name, String description){
        this.stock = stock;
        this.name = name;
        this.description = description;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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
}
