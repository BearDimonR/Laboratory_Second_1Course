package BackGround;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stock {

    private static ArrayList<GroupOfProduct> groups = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static User loginUser;


    public static ArrayList<GroupOfProduct> getGroups() {
        return groups;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * find group by name
     * @param name to find
     * @return result of searching
     */
    public static GroupOfProduct findGroup(String name){
        for(int i=0;i<groups.size();i++){
            if(groups.get(i).getName().equals(name)) return groups.get(i);
        }
        return null;
    }
    /**
     * find product by name
     * @param name to find
     * @return result of searching
     */
    public static Product findProductByName(String name){
        ArrayList<Product> products = getAllProducts();
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductName().equals(name)) return products.get(i);
        }
        return null;
    }
    /**
     * find user by name
     * @param name to find
     * @return result of searching
     */
    public static User findUserByName(String name){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getName().equals(name)) return users.get(i);
        }
        return null;
    }

    /**
     *
     * @return all products
     */
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for(int i=0;i<groups.size();i++){
            products.addAll(groups.get(i).getProducts());
        }
        if(products.size()==0) return new ArrayList<>();
        return products;
    }

    /**
     *
     * @return all groups
     */
    public static ArrayList<GroupOfProduct> getAllGroup(){
        ArrayList<GroupOfProduct> group = new ArrayList<>();
        group.addAll(groups);
        if(group.size()==0)return new ArrayList<>();
        return group;
    }

    /**
     *
     * @return allPrice of products in stock
     */
    public static double getAllPrice(){
        double res = 0;
        for(int i=0;i<groups.size();i++){
            res += groups.get(i).getGroupPrice();
        }
        return res;
    }

    /**
     *
     * @return all amount of products in stock
     */
    public static int getAllAmount(){
        int res = 0;
        for(int i=0;i<groups.size();i++){
            res += groups.get(i).getGroupAmount();
        }
        return res;
    }

    /**
     * load groups from file
     */
    public static void loadData() {
        groups = (ArrayList<GroupOfProduct>) load("dataStore\\DataStock");
    }
    /**
     * load users from file
     */
    public static void loadUsers(){
        users = (ArrayList<User>) load("dataStore\\UserStock");
    }

    /**
     * loading method
     * @param name file name
     * @return loaded object
     */
    public static ArrayList load(String name){
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(new File(name)));
            ArrayList arrayList;
            arrayList = (ArrayList<Object>) objectInput.readObject();
            objectInput.close();
            return arrayList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * save groups
     */
    public static void saveData() {
       save(groups,"dataStore\\DataStock");
    }
    /**
     * save users
     */
    public static void saveUsers() {
        save(users,"dataStore\\UserStock");
        saveNamePasswords();
    }

    /**
     * save names+passwords
     */
    private static void saveNamePasswords() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dataStore\\Info"));
            for(int i=0;i<users.size();i++){
                bufferedWriter.write(users.get(i).toString());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * saving method
     * @param arrayList of objects to save
     * @param name file name
     */
    public static void save(ArrayList arrayList,String name) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(name));
            objectOutput.writeObject(arrayList);
            objectOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * add new users from file
     */
    public static void addUsers() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dataStore\\Info"));
            String term = bufferedReader.readLine();
            checkUser(term);
            while (true) {
                if(term == null) break;
                if(!term.equals(""))
                    checkUser(term);
                term = bufferedReader.readLine();
            }
            saveUsers();
            bufferedReader.close();
        } catch (IOException e) {
            throw new UnknownError("Users in file are not correct!!!! Must be: [name password type]");
        }
    }

    /**
     * check name of users
     * @param str name
     */
    private static void checkUser(String str) {
            String[] words = str.split("[ ]");
            if(words.length!=3) throw new UnknownError("Users in file are not correct!!!! Must be: [name password type]");
            Matcher matcher = Pattern.compile("[A-Za-zА-ЯЇЄІїєіа-я_0-9]{3,20}").matcher(words[0]);
            if(!matcher.matches()) throw new UnknownError("Users in file are not correct!!!! Must be: [name password type]");
            if(Stock.findUserByName(words[0]) == null) {
                User user = new User(words[0], words[1], words[2]);
                users.add(user);
            }
    }
    public static User getLoginUser() {
        return loginUser;
    }

    public static void setLoginUser(User loginUser) {
        Stock.loginUser = loginUser;
    }
}
