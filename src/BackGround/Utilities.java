package BackGround;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {

    // private static ArrayList<GroupOfProduct> group = new ArrayList<>();
    private static ArrayList<Product> product = new ArrayList<>();


//    public static GroupOfProduct findGroup(String name) {
//        for (int i = 0; i < group.size(); i++) {
//            if (group.get(i).getName().equals(name)) return group.get(i);
//        }
//        return null;
//    }

    public static ArrayList Search(String line) {
        ArrayList<Product> spaceLine = Stock.getAllProducts();
        ArrayList<Product> array= new ArrayList<>();
        if ( line.equals("[ ]*")) {
            System.out.println("incorrect ");

            return spaceLine;
        } else {
            System.out.println("line = '" + line + "'");

            //if (line.equals("[ ]*[0-9]+[.]?[0-9]*[ ]*")) {
            if (line.matches("[ ]*[0-9]+[.]?[0-9]*[ ]*") == true) {
                System.out.println("number");
                line = line.replaceAll(" ", "");
                double num = Double.valueOf(line);
                for (int i = 0; i < product.size(); i++) {
                    if ((product.get(i).getPrice() == num || product.get(i).getQuantityInStock() == num))
                        array.add(product.get(i));

                }
            }
            //else if (line.equals("[ ]*[A-Za-z]+[ ]*")) {
            else if (line.matches("[ ]*[A-Za-zА-Яа-я]+[ ]*") == true) {
                System.out.println("word");
                line = line.replaceAll(" ", "");
                for (int i = 0; i < product.size(); i++) {
                    String group = (String) String.valueOf(product.get(i).getGroupProducts());
                    if (    group.equals(line) ||
                            product.get(i).getProductName().equals(line) ||
                            product.get(i).getManufacturer().equals(line)
                    )
                        array.add(product.get(i));
                }

            }
            System.out.println("dontWork");
            return array;
        }
    }

    /*
    тут має буде висуватися
     */
    public static ArrayList<Product> findByGroup(String line, ArrayList<Product> array) {
        if (line == null || line.matches("[ ]*") == true) {
            return array;
        } else {
            line = line.replaceAll(" ", "");
            String word = "";
            for (int i = 0; i < array.size(); i++) {
            //    String s = String.valueOf(array.get(i).getGroupProducts());
                if (!(String.valueOf(array.get(i).getGroupProducts()).equals(line))) {
                //if (!(array.get(i).getGroupProducts().equals(line))) {//????????????????????????????ВАЖЛИВО
                    System.out.println("удалило групу-" + array.get(i).getGroupProducts());
                    array.remove(i);
                    i--;
                }
            }

            return array;
        }

    }

    public static ArrayList<GroupOfProduct> findByGroup2(String line, ArrayList<GroupOfProduct> array) {
        if (line == null || line.matches("[ ]*") == true) {
            return array;
        } else {
            line = line.replaceAll(" ", "");
            String word = "";
            for (int i = 0; i < array.size(); i++) {
                for(int j = 0 ; j < line.length();j++){
                    if(!(array.get(i).getName().length()<line.length())){
                        word += array.get(i).getName().charAt(j);
                    }
                }
                if (!(word.equals(line))) {
                    System.out.println("удалило групу " + array.get(i));
                    array.remove(i);
                    i--;
                }
            }

            return array;
        }

    }

    public static ArrayList<Product> findByProductName(String line, ArrayList<Product> array) {
        if (line == null || line.matches("[ ]*") == true) {
            return array;
        } else {
            //створили пусте слово
            String word = "";
            //проходимо по всьому ерейлісту
            for (int i = 0; i < array.size(); i++) {
                //проходимо по

                for (int j = 0; j < line.length(); j++) {
                    if (!(array.get(i).getProductName().length() < line.length())) {
                        word += array.get(i).getProductName().charAt(j);
                    }
                }
              //  if (!(array.get(i).getProductName().equals(line))) {
                if (!(word.equals(line))) {
                    System.out.println("удалило продукт" + array.get(i)+"   i="+i + "   array.size() = arr"+array.size()) ;
                    array.remove(i);
                    i--;
                    System.out.println("word ='" + word+"'");
                }
                word = "";
            }
            return array;
        }
    }

    public static ArrayList<Product> findByManufacturer(String line, ArrayList<Product> array) {
        if (line == null || line.matches("[ ]*") == true) {
            return array;
        } else {
            String word = "";
            for (int i = 0; i < array.size(); i++) {

                for (int j = 0; j < line.length(); j++) {
                    if (!(array.get(i).getManufacturer().length() < line.length())) {
                        word += array.get(i).getManufacturer().charAt(j);
                    }
                }

                if (!(word.equals(line))) {
               // if (word.equals(line)) {
                    System.out.println("word ='" + word+"'");
                    System.out.println("удалило виробника");
                    System.out.println(array.get(i));
                    array.remove(i);
                    i--;
                }
                word="";
            }
            return array;
        }
    }

//    public static ArrayList<Product> findByPrice(double price, ArrayList<Product> array) {
//        if (price == 0.0 || price < 0) {
//            return null;
//        } else {
//            for (int i = 0; i < array.size(); i++) {
//                if (!(array.get(i).getPrice() == price)) {
//                    array.remove(i);
//
//                }
//            }
//            return array;
//        }
//
//    }

    public static ArrayList<Product> findFromPriceTo(double priceFrom, double priceTo, ArrayList<Product> array) {
        if (priceFrom > priceTo || priceFrom < 0 || priceTo < 0) {
            return null;
        } else if (priceFrom > 0 && priceTo == 0) {
            for (int i = 0; i < array.size(); i++) {
                if (!(array.get(i).getPrice() >= priceFrom)) {
                    array.remove(i);
                    i--;
                }
            }
            return array;
        } else if (priceTo > 0 && priceFrom == 0) {
            for (int i = 0; i < array.size(); i++) {
                if (!(array.get(i).getPrice() <= priceTo)) {
                    array.remove(i);
                    i--;
                }
            }
            return array;
        }
        else if (priceTo==0&&priceFrom==0){
            return array;
        } else{

                for (int i = 0; i < array.size(); i++) {
                    if (!(array.get(i).getPrice() >= priceFrom && array.get(i).getPrice() <= priceTo)) {
                        array.remove(i);
                        System.out.println("удалило ціну");
                        i--;/////т тут чи требазавжди справно напевно тесту мало
                    }
                }

            return array;
        }

    }


//    public static ArrayList<Product> findByQuantities(Double quantities, ArrayList<Product> array) {
//        if (quantities == null || quantities == 0) {
//            return null;
//        } else {
//            for (int i = 0; i < array.size(); i++) {
//                if ((array.get(i).getQuantityInStock() != quantities)) {
//                    array.remove(i);
//                }
//            }
//            return array;
//        }
//    }


    public static ArrayList<Product> mainSearch(String lineProductGroup, String lineProductName, String lineManufacturer, double priceFrom, double priceTo) {
        ArrayList<Product> copyArray = Stock.getAllProducts();
         copyArray = findByGroup(lineProductGroup, copyArray);
        System.out.println("сорт за групами" + copyArray);
        copyArray = findByProductName(lineProductName, copyArray);
        System.out.println("сорт за продуктами" + copyArray);
        copyArray = findByManufacturer(lineManufacturer, copyArray);
        System.out.println("сорт за виробниками" + copyArray);
        copyArray = findFromPriceTo(priceFrom, priceTo, copyArray);
        System.out.println("сорт за ціною" + copyArray);

        return copyArray;
    }
    public static ArrayList<GroupOfProduct> mainSearch2(String lineProductGroup) {
        ArrayList<GroupOfProduct> copyArray = Stock.getAllGroup();

        System.out.println("сорт за групами та лише групами" + copyArray);
        copyArray = findByGroup2(lineProductGroup, copyArray);

        return copyArray;
    }

    /**
     * method which used in class StatisticPAanel to sort
     * @param group
     * @return
     */
    public static ArrayList<Product> searchGroup(String group){
        ArrayList<Product> copyArray = Stock.getAllProducts();
        copyArray = findByGroup(group,copyArray);
        return copyArray;
    }


}


