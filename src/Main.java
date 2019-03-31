import BackGround.GroupOfProduct;
import BackGround.Stock;
import GUI.General.App;

public class Main {
    public static void main(String[] args){
        GroupOfProduct groupOfProduct = new GroupOfProduct("MILK","kek");
        GroupOfProduct groupOfProduct1 = new GroupOfProduct("sweet","lol");
        Stock.getGroups().add(groupOfProduct);
        Stock.getGroups().add(groupOfProduct1);
        new App().main(null);

    }
}
