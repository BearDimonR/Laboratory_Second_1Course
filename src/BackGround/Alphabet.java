package BackGround;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabet {

    public static ArrayList<Product> alphabetProduct() {
       // ArrayList<Product> products = (ArrayList<Product> )prod.clone();

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

    public static ArrayList<GroupOfProduct> alphabetOnlyGroup() {
        ArrayList<GroupOfProduct> group = Stock.getGroups();
        Collections.sort(group, new Comparator() {
            @Override
            public int compare(Object groupOne, Object groupTwo) {
                return ((GroupOfProduct) groupOne).getName().compareTo(((GroupOfProduct) groupTwo).getName());
            }
        });
        return group;
    }
    //String.valueOf(array.get(i).getGroupProducts()
    public static ArrayList<Product> alphabetGroup() {
        ArrayList<Product> group = Stock.getAllProducts();
        Collections.sort(group, new Comparator() {
            @Override
            public int compare(Object groupOne, Object groupTwo) {
                return ((Product) groupOne).getGroupProducts().getName().compareTo(((Product) groupTwo).getGroupProducts().getName());
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
    public static ArrayList<Product> alphabetPrice (){
        ArrayList<Product> price = Stock.getAllProducts();
        Collections.sort(price,new Comparator() {
            @Override
            public int compare(Object priceOne, Object priceTwo) {
                return (new Double (((Product)priceOne).getPrice()).compareTo(((Product)priceTwo).getPrice()));
            }
        });
        return price;
    }

}
