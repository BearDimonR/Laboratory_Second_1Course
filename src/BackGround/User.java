package BackGround;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String password;
    private String type;
    private String image;
    private ArrayList<Boolean> access = new ArrayList<>();
    private boolean blocked;
    private boolean admin;

    public User(String name, String password, String type){
        this.name = name;
        this.password = password;
        this.type = type;
        this.blocked = false;
        admin = false;
        checkAccess();
    }

    private void checkAccess() {
        if(type.equals("admin")){
            admin = true;
            for(int i=0;i<5;i++) {
                access.add(Boolean.TRUE);
            }
        } else {
            type = "user";
            access.add(Boolean.FALSE);
            access.add(Boolean.FALSE);
            access.add(Boolean.FALSE);
            access.add(Boolean.TRUE);
            access.add(Boolean.TRUE);
        }
    }

    public boolean getAccess(int number) {
        return access.get(number-1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Boolean> getAccess() {
        return access;
    }

    public void setAccess(ArrayList<Boolean> access) {
        this.access = access;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
        if(admin) type = "admin";
        else type = "user";
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name+" "+password+" "+type+"\r\n";
    }
}
