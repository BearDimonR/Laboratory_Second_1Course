package BackGround;

import java.util.ArrayList;

public class Stock {
    private static Product[] products;
    private static ArrayList<Product> arrayList = new ArrayList<Product>(1);

    /**
     * метод звичйних масивів у якому ми змінюємо всі великі літери на маленькі
     *
     * @return
     */
    private Product[] reduceLettersInArray() {
        products = new Product[10];
        // тестер
        products[0] = new Product("моЛОчка", "молоко", "торчин", 2.3);
        products[1] = new Product("Молочка", "сир", "торчин", 2.3);
        products[2] = new Product("Молочка", "творог", "торчин", 4.4);
        products[3] = new Product("мЯсо", "курятина", "київ", 2.6);
        products[4] = new Product("мясо", "свинина", "київ", 2.7);
        products[5] = new Product("мясо", "телятина", "київ", 2.1);
        products[6] = new Product("фрукти", "ЯБЛУКО", "полтава", 4.2);
        products[7] = new Product("фрукти", "апельсин", "полтава", 2.4);
        products[8] = new Product("фрукти", "тиква", "полтава", 1.3);
        products[9] = new Product("молочка", "ананас", "ПОЛТАВА", 3.8);

        for (int i = 0; i < products.length; i++) {
            Product temp = new Product(products[i].getGroupProducts().toLowerCase(),
                    products[i].getProductName().toLowerCase(),
                    products[i].getManufacturer().toLowerCase(),
                    products[i].getPrice());

            products[i] = temp;
        }
        return products;
    }

    /**
     * @param arrayList
     * @param products
     * @return
     */
    private ArrayList copyToArrayList(ArrayList<Product> arrayList, Product[] products) {

        for (int i = 0; i < products.length; i++) {
            arrayList.add(products[i]);
        }
        return arrayList;
    }

    /**
     * ми зводимо до маленьких літер
     *
     * @param groupOfProducts
     * @param productName
     * @param manufacturer
     */
    private void reduceLetters(String groupOfProducts, String productName, String manufacturer) {
        groupOfProducts = groupOfProducts.toLowerCase();
        productName = productName.toLowerCase();
        manufacturer = manufacturer.toLowerCase();
    }

    /**
     * метод який перевіряє чи у полі група товарів не пусто
     *
     * @param groupOfProducts
     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не підходить
     */
    private ArrayList<Product> findByGroupProducts(String groupOfProducts) {
        if (groupOfProducts == null || groupOfProducts == "" || groupOfProducts == "[ ]*") {
        } else {
            for (int i = 0; i < products.length; i++) {
                if (!(products[i].getGroupProducts().equals(groupOfProducts))) {
                    arrayList.remove(products[i]);
                }
            }
        }
        return arrayList;
    }

    /**
     * метод який перевіряє чи у полі назви товару товарів не пусто
     *
     * @param productsName
     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не підходить
     */
    private ArrayList<Product> findByProductName(String productsName) {
        if (productsName == null || productsName == "" || productsName == "[ ]*") {
        } else {
//            for(Product tovar : products){
//                if(  ! (tovar.getProductName().equals(products))   ){
//                    arrayList.remove(tovar);
//                }
//            }
            for (int i = 0; i < products.length; i++) {
                if (!(products[i].getProductName().equals(productsName))) {
                    arrayList.remove(products[i]);
                }
            }
        }
        return arrayList;
    }

    /**
     * метод який перевіряє чи у полі назви виробника товарів не пусто
     *
     * @param manufacturer
     * @return якщо пусто то залишає arreyList цілим інакше видаляє те що не підходить
     */
    private ArrayList<Product> findByManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer == "" || manufacturer == "[ ]*") {
        } else {
            for (int i = 0; i < products.length; i++) {
                if (!(products[i].getManufacturer().equals(manufacturer))) {
                    arrayList.remove(products[i]);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<Product> findByPrice(double priceFrom, double priceTo) {
        if (priceFrom == 0 && priceTo == 0) {

        } else {
            if (priceFrom > 0 && priceTo == 0) {
                for (int i = 0; i < products.length; i++) {
                    if(products[i].getPrice()<priceFrom){
                        arrayList.remove(products[i]);
                    }
                }
            } else if (priceFrom == 0 && priceTo > 0) {
                for (int i = 0; i < products.length; i++) {
                    if(products[i].getPrice()>priceTo){
                        arrayList.remove(products[i]);
                    }
                }
            } else if (priceFrom > 0 && priceTo > 0) {
                for (int i = 0; i < products.length; i++) {
                    if(products[i].getPrice()<priceFrom&&products[i].getPrice()>priceTo){
                        arrayList.remove(products[i]);
                    }
                }
            }

        }
        return arrayList;
    }


    // private  void findProduct(String groupOfProducts, String productName, String manufacturer, double priceFrom, double priceTo) {

    public static void main(String[] args) {
        Stock s = new Stock();
        s.reduceLettersInArray();
        s.copyToArrayList(arrayList, products);
        System.out.println(arrayList + "*************");
        s.findByGroupProducts("молочка");
        System.out.println(arrayList + "++++++++++++++");
        s.findByProductName(null);
        System.out.println(arrayList + "--------------");
        s.findByPrice(0,3.8);
        System.out.println(arrayList + "//////////////");
    }

}
