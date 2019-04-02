import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.General.App;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
//        GroupOfProduct groupOfProduct = new GroupOfProduct("MILK","kek");
//        GroupOfProduct groupOfProduct1 = new GroupOfProduct("sweet","lol");
//        groupOfProduct.addProduct(new Product(groupOfProduct,"milk","kek","Roshen",120,150));
//        groupOfProduct.addProduct(new Product(groupOfProduct,"сметана","lol","Вася",90,120));
//        groupOfProduct1.addProduct(new Product(groupOfProduct1,"водка","vodka top","АТБ",170,100));
//        groupOfProduct1.addProduct(new Product(groupOfProduct1,"вода","opa","АТБ",560,500));
//
//        Stock.getGroups().add(groupOfProduct);
//        Stock.getGroups().add(groupOfProduct1);
        Stock.loadData();
        new App().main(null);

    }
}
