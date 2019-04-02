package BackGround;

import java.io.*;
import java.util.ArrayList;

public class Stock {

    private static ArrayList<GroupOfProduct> groups = new ArrayList<>();

    public static ArrayList<GroupOfProduct> getGroups() {
        return groups;
    }

    public static GroupOfProduct findGroup(String name){
        for(int i=0;i<groups.size();i++){
            if(groups.get(i).getName().equals(name)) return groups.get(i);
        }
        return null;
    }

    public static Product findProductByName(String name){
        ArrayList<Product> products = getAllProducts();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductName().equals(name)) return products.get(i);
        }
        return null;
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for(int i=0;i<groups.size();i++){
            products.addAll(groups.get(i).getProducts());
        }
        if(products.size()==0) return new ArrayList<>();
        return products;
    }

    public static void loadData() {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("dataStore\\DataStock"));
            objectInput.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveData() {

    }
    //    /**
//     * ми зводимо до маленьких літер
//     *
//     * @param groupOfProducts
//     * @param productName
//     * @param manufacturer
//     */
//    private void reduceLetters(String groupOfProducts, String productName, String manufacturer) {
//        groupOfProducts = groupOfProducts.toLowerCase();
//        productName = productName.toLowerCase();
//        manufacturer = manufacturer.toLowerCase();
//    }
//
//    private String copyWordToString(String groupOfProducts, String word, int i) {
//        for (int j = 0; j < groupOfProducts.length(); j++) {
//            if (!(products[i].getGroupProducts().length() < groupOfProducts.length()))
//                word += products[i].getGroupProducts().charAt(j);
//        }
//        return word;
//    }
//
//    /**
//     * метод який перевіряє чи у полі група товарів не пусто
//     *
//     * @param groupOfProducts
//     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не
//     *         підходить
//     */
//    private ArrayList<Product> findByGroupProducts(String groupOfProducts) {
//        if (groupOfProducts == null || groupOfProducts == "" || groupOfProducts == "[ ]*") {
//        } else {
//            String word = "";
//            for (int i = 0; i < products.length; i++) {
////				for (int j = 0; j < groupOfProducts.length(); j++) {
////					if (!(products[i].getGroupProducts().length() < groupOfProducts.length()))
////						word += products[i].getGroupProducts().charAt(j);
////				}
//                word = copyWordToString (groupOfProducts,word,i);
//                if (!(word.equals(groupOfProducts) )) {
//                    arrayList.remove(products[i]);
//                }
//                word = "";
//            }
//        }
//        return arrayList;
//    }
//    /**
//     * метод який перевіряє чи у полі назви товару товарів не пусто
//     *
//     * @param productsName
//     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не
//     *         підходить
//     */
//    private ArrayList<Product> findByProductName(String productsName) {
//        if (productsName == null || productsName == "" || productsName == "[ ]*") {
//        } else {
//            String word = "";
//            for (int i = 0; i < products.length; i++) {
//                for (int j = 0; j < productsName.length(); j++) {
//                    if (!(products[i].getProductName().length() < productsName.length()))
//                        word += products[i].getProductName().charAt(j);
//                }
//                if (!(products[i].getProductName().equals(productsName))) {
//                    arrayList.remove(products[i]);
//                }
//                word = "";
//            }
//        }
//        return arrayList;
//    }
//
//    /**
//     * метод який перевіряє чи у полі назви виробника товарів не пусто
//     *
//     * @param manufacturer
//     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не
//     *         підходить
//     */
//    private ArrayList<Product> findByManufacturer(String manufacturer) {
//        if (manufacturer == null || manufacturer == "" || manufacturer == "[ ]*") {
//        } else {
//            String word = "";
//            for (int i = 0; i < products.length; i++) {
//                for (int j = 0; j < manufacturer.length(); j++) {
//                    if (!(products[i].getManufacturer().length() < manufacturer.length()))
//                        word += products[i].getManufacturer().charAt(j);
//                }
//                if (!(products[i].getManufacturer().equals(manufacturer))) {
//                    arrayList.remove(products[i]);
//                }
//                word = "";
//            }
//        }
//        return arrayList;
//    }
//
//    private ArrayList<Product> findByPrice(double priceFrom, double priceTo) {
//        if (priceFrom == 0 && priceTo == 0) {
//
//        } else {
//            if (priceFrom > 0 && priceTo == 0) {
//                for (int i = 0; i < products.length; i++) {
//                    if (products[i].getPrice() < priceFrom) {
//                        arrayList.remove(products[i]);
//                    }
//                }
//            } else if (priceFrom == 0 && priceTo > 0) {
//                for (int i = 0; i < products.length; i++) {
//                    if (products[i].getPrice() > priceTo) {
//                        arrayList.remove(products[i]);
//                    }
//                }
//            } else if (priceFrom > 0 && priceTo > 0) {
//                for (int i = 0; i < products.length; i++) {
//                    if (products[i].getPrice() < priceFrom && products[i].getPrice() > priceTo) {
//                        arrayList.remove(products[i]);
//                    }
//                }
//            }
//
//        }
//        return arrayList;
//    }
//
//    // private void findProduct(String groupOfProducts, String productName, String
//    // manufacturer, double priceFrom, double priceTo) {
//
//    public static void main(String[] args) {
//        Stock s = new Stock();
//        s.reduceLettersInArray();
//        s.copyToArrayList(arrayList, products);
//        System.out.println(arrayList + "*************");
//        s.findByGroupProducts("молоко");
//        System.out.println(arrayList + "++++++++++++++");
//        s.findByProductName(null);
//        //System.out.println(arrayList + "--------------");
//        s.findByPrice(0, 3.8);
//        //System.out.println(arrayList + "//////////////");
//    }
//
}
