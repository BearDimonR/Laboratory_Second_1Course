import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.General.App;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        GroupOfProduct groupOfProduct = new GroupOfProduct("MILK","kek");
        GroupOfProduct groupOfProduct1 = new GroupOfProduct("sweet","lol");
        groupOfProduct.addProduct(new Product(groupOfProduct,"milk","kek","Roshen",100,150));
        groupOfProduct.addProduct(new Product(groupOfProduct,"сметана","lol","Вася",20,120));
        groupOfProduct1.addProduct(new Product(groupOfProduct1,"водка","vodka top","АТБ",70,100));
        groupOfProduct1.addProduct(new Product(groupOfProduct1,"вода","opa","АТБ",200,500));

        Stock.getGroups().add(groupOfProduct);
        Stock.getGroups().add(groupOfProduct1);
        new App().main(null);

    }
}
