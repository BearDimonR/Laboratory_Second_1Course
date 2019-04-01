import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.General.App;

public class Main {
    public static void main(String[] args){
        GroupOfProduct groupOfProduct = new GroupOfProduct("MILK","kek");
        GroupOfProduct groupOfProduct1 = new GroupOfProduct("sweet","lol");
        groupOfProduct.addProduct(new Product(groupOfProduct,"milk","Roshen",100));
        groupOfProduct.addProduct(new Product(groupOfProduct,"сметана","Вася",120));
        groupOfProduct1.addProduct(new Product(groupOfProduct1,"водка","АТБ",50));
        groupOfProduct1.addProduct(new Product(groupOfProduct1,"вода","АТБ",200));

        Stock.getGroups().add(groupOfProduct);
        Stock.getGroups().add(groupOfProduct1);
        new App().main(null);

    }
}
