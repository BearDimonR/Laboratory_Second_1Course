package BackGround;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabet {

    public static ArrayList<Product> alphabetProduct() {
        //повернути всі обєкти з групи родуктів
        //застосувати колекцію
        //має щось повертати
        ArrayList<Product> products = Stock.getAllProducts();
        Collections.sort(products, new Comparator() {
            @Override
            public int compare(Object productOne, Object productSecond) {
                return ((Product) productOne).getProductName()
                        .compareTo(((Product) productSecond).getProductName());
            }


        });
        return products;
    }

    public static ArrayList<GroupOfProduct> alphabetGroup() {
        ArrayList<GroupOfProduct> group = Stock.getAllGroup();
        Collections.sort(group, new Comparator() {
            @Override
            public int compare(Object groupOne, Object groupTwo) {
                return ((GroupOfProduct) groupOne).getName().compareTo(((GroupOfProduct) groupTwo).getName());
            }
        });
        return group;
    }

    public static ArrayList<Product> alphabetManufacturer (){
        ArrayList<Product> manufacturer = Stock.getAllProducts();
        Collections.sort(manufacturer,new Comparator() {
            @Override
            public int compare(Object manufacturerOne, Object manufacturerTwo) {
                return ((Product) manufacturerOne).getManufacturer().compareTo(((Product) manufacturerTwo).getManufacturer());
            }
        });
        return manufacturer;
    }

}
