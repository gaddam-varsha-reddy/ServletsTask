package com.wavemaker.manager.implementations;
import com.wavemaker.manager.UserManager;
import com.wavemaker.model.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class InMemoryStorageUserManager implements UserManager {
    private List<User> list = new ArrayList<>();
    @Override
    public void addUser(User user) {
        list.add(user);
        System.out.println(user.getName()+" is added to list");
    }
    @Override
    public List<User> listUsers() {
        return list;
    }

    @Override
    public void deleteUser(String Name) {
        Iterator userListIterator = list.iterator();
        boolean flag=true;
        while (userListIterator.hasNext()) {
            User user = (User) userListIterator.next();
            if (user.getName().equals(Name)){
                userListIterator.remove();
                System.out.println(user.getName()+" is removed from list");
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println(Name+"is not in list");
        }
    }

    @Override
    public ArrayList<User> searchUsers(String Name) {
        boolean flag=true;
        ArrayList<User> watchlist =new ArrayList<>();
        for (User listItem : list) {
            if (listItem.getName().equals(Name)) {
                System.out.println(listItem.getName()+" is found in list");
                watchlist.add(listItem);
                flag=false;
            }
        }
        if(flag){
            System.out.println(Name + " is not in list");
        }
        return watchlist;
    }
    @Override
    public void updateUser(User user){
        boolean flag=true;
        for (User listItem : list) {
            if (listItem.getId()==(user.getId())) {
                listItem.setName(user.getName());
                listItem.setGender(user.getGender());
                listItem.setDob(user.getDob());
                System.out.println(user.getName() + " is updated in list");
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println(user.getId() +" is not found in list");
        }

    }
}
