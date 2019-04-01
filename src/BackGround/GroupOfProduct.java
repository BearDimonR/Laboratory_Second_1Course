package BackGround;

import java.util.ArrayList;

public class GroupOfProduct {

    private ArrayList<Product> products = new ArrayList<>();

    private String name;                //ім’я групи товарів (продовольчі не продовольчі)
    private String description;         //опис

    public GroupOfProduct(String name, String description){
        this.name = name;
        this.description = description;
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}x` `
