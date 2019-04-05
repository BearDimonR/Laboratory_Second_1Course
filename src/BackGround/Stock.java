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

    public static ArrayList<GroupOfProduct> getAllGroup(){
        ArrayList<GroupOfProduct> group = new ArrayList<>();
        group.addAll(groups);
        if(group.size()==0)return new ArrayList<>();
        return group;
    }

    public static void loadData() {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("dataStore\\DataStock"));
            ArrayList<GroupOfProduct> arrayList = new ArrayList<>();
            arrayList = (ArrayList<GroupOfProduct>) objectInput.readObject();
            groups = arrayList;
            objectInput.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveData() {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("dataStore\\DataStock"));
            objectOutput.writeObject(groups);
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getAllPrice(){
        double res = 0;
        for(int i=0;i<groups.size();i++){
            res += groups.get(i).getGroupPrice();
        }
        return res;
    }
}
