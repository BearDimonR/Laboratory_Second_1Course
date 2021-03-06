package BackGround;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupOfProduct implements Serializable {

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

    public void addProduct(Product product){
        product.getGroupProducts().removeProduct(product);
        product.setGroupProducts(this);
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
        product.setGroupProducts(null);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     *
     * @return group price of products
     */
    public double getGroupPrice() {
        double res = 0;
        for(int i=0;i<products.size();i++){
            res += products.get(i).getPrice()*products.get(i).getQuantityInStock();
        }
        return res;
    }

    /**
     *
     * @return group amount of products
     */
    public int getGroupAmount(){
        int res = 0;
        for(int i=0;i<products.size();i++){
            res += products.get(i).getQuantityInStock();
        }
        return res;
    }
}