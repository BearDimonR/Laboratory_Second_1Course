package BackGround;

import java.util.ArrayList;

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

        if (line.equals("[ ]*") || line.equals("")) {
            return spaceLine;
        } else {

            //якщо це число одне
            if (line.matches("[ ]*[0-9]+[.]?[0-9]*[ ]*") == true) {
                line = line.replaceAll(" ", "");
                double num = Double.valueOf(line);
                for (int i = 0; i < spaceLine.size(); i++) {
                    //if ((spaceLine.get(i).getPrice() != num && spaceLine.get(i).getQuantityInStock() != num))
                    if ((spaceLine.get(i).getPrice() != num && spaceLine.get(i).getQuantityInStock() != num)) {
                        spaceLine.remove(i);
                        i--;
                    }
                }
                return spaceLine;
            }
            //якщо це межа чисел
            else if (line.matches("[ ]*[\\d]+[.]?[\\d]*[ ]*[-][ ]*[\\d]+[.]?[\\d]*[ ]*") == true) {
                String[] array = line.split("-");
                String prFrom = array[0];
                String prTo = array[1];
                prFrom = prFrom.replaceAll(" ", "");
                prTo = prTo.replaceAll(" ", "");
                double priceFrom = Double.parseDouble(prFrom);
                double priceTo = Double.parseDouble(prTo);
                spaceLine = findFromPriceTo(priceFrom, priceTo, spaceLine);
                return spaceLine;
            }

            //else if (line.matches("[ ]*[A-Za-zА-Яа-яії]+[ ]*") == true)
            else {
                line = line.replaceAll(" ", "");
                for (int i = 0; i < spaceLine.size(); i++) {
                    String groupProduct = (String) String.valueOf(spaceLine.get(i).getGroupProducts());
                    String product = "";
                    String group = "";
                    String manufacturer = "";
                    for (int j = 0; j < line.length(); j++) {
                        if (spaceLine.get(i).getProductName().length() > line.length())
                            product += spaceLine.get(i).getProductName().charAt(j);
                        if (groupProduct.length()>line.length())
                            group += groupProduct.charAt(j);
                        if (spaceLine.get(i).getManufacturer().length() > line.length())
                            manufacturer += spaceLine.get(i).getManufacturer().charAt(j);
                    }

                    if (!(group.equals(line) ||
                            product.equals(line) ||
                            manufacturer.equals(line)
                    )) {

                        spaceLine.remove(i);
                        i--;
                    }
                }
                return spaceLine;

            }
            //коли неправильни ввід
//            else {
//                JOptionPane.showMessageDialog(null,"Your write incorrect info","Arial",JOptionPane.ERROR_MESSAGE);
//               // JOptionPane.showMessageDialog(null, "Справка","Reference",JOptionPane.QUESTION_MESSAGE);
//                return null;
//            }


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
                for (int j = 0; j < line.length(); j++) {
                    if (!(array.get(i).getName().length() < line.length())) {
                        word += array.get(i).getName().charAt(j);
                    }
                }
                if (!(word.equals(line))) {
                    array.remove(i);
                    i--;
                }
                word="";
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
                    array.remove(i);
                    i--;
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
                    array.remove(i);
                    i--;
                }
                word = "";
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
        } else if (priceTo == 0 && priceFrom == 0) {
            return array;
        } else {

            for (int i = 0; i < array.size(); i++) {
                if (!(array.get(i).getPrice() >= priceFrom && array.get(i).getPrice() <= priceTo)) {
                    array.remove(i);
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
        copyArray = findByProductName(lineProductName, copyArray);
        copyArray = findByManufacturer(lineManufacturer, copyArray);
        copyArray = findFromPriceTo(priceFrom, priceTo, copyArray);

        return copyArray;
    }

    public static ArrayList<GroupOfProduct> mainSearch2(String lineProductGroup) {
        ArrayList<GroupOfProduct> copyArray = Stock.getAllGroup();

        copyArray = findByGroup2(lineProductGroup, copyArray);

        return copyArray;
    }

    /**
     * method which used in class StatisticPAanel to sort
     *
     * @param group
     * @return
     */
    public static ArrayList<Product> searchGroup(String group) {
        ArrayList<Product> copyArray = Stock.getAllProducts();
        copyArray = findByGroup(group, copyArray);
        return copyArray;
    }

}


