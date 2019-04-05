import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import BackGround.User;
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
//        Stock.saveData();
//        Stock.getUsers().add(new User("Vasia","petro228","admin"));
//        Stock.saveUsers();


       Stock.loadData();
       Stock.loadUsers();
       Stock.addUsers();
       Stock.saveUsers();
       new App().main(null);

    }
}
