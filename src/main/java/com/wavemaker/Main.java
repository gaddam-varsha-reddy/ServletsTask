package com.wavemaker;
import com.wavemaker.manager.implementations.InMemoryStorageUserManager;
import com.wavemaker.manager.implementations.JdbcUserManager;
import com.wavemaker.model.User;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Choose User Manager Implementation");
        System.out.println("1.Using In Memory Storage User Manager");
        System.out.println("2.Using Jdbc User Manager");
        int choice=sc.nextInt();
        while(choice!=1 && choice!=2){
                System.out.println("Invalid number entered");
                choice=sc.nextInt();
        }
        System.out.println("1-Adding Users");
        System.out.println("2-Deleting Users");
        System.out.println("3.Search User");
        System.out.println("4.Display All Users");
        System.out.println("5.Update User");
        System.out.println("6.Exit");
        System.out.println("Enter your choice");
        n=sc.nextInt();
        if(choice==1){
            InMemoryStorageUserManager userManager =new InMemoryStorageUserManager();
            while(n!=6) {
                switch (n) {
                    case 1:
                        System.out.println("Enter user id: ");
                        int id=sc.nextInt();
                        System.out.println("Enter user name: ");
                        String name = sc.next();
                        System.out.println("Enter user gender:");
                        String gender=sc.next();
                        System.out.println("Enter user dob: ");
                        String dob=sc.next();
                        userManager.addUser(new User(id,name,gender,dob));
                        System.out.println("Enter your choice");
                        n=sc.nextInt();
                        break;
                    case 2:
                        System.out.println("Enter user name which you want to remove");
                        String username=sc.next();
                        userManager.deleteUser(username);
                        System.out.println("Enter your choice");
                        n=sc.nextInt();
                        break;
                    case 3:
                        System.out.println("Enter user name whom you want to search");
                        List<User> userList=userManager.searchUsers(sc.next());
                        for(User listItem:userList){
                            System.out.println("UserId:" +listItem.getId()+"\tUserName:" +listItem.getName()+"\tGender:" +listItem.getGender()+ "\tDOB:"+ listItem.getDob());
                        }
                        System.out.println("Enter your choice");
                        n=sc.nextInt();
                        break;
                    case 4:
                        userList=userManager.listUsers();
                        for(User listItem:userList){
                            System.out.println("UserId:" +listItem.getId()+"\tUserName:" +listItem.getName()+"\tGender:" +listItem.getGender()+ "\tDOB:"+ listItem.getDob());
                        }
                        System.out.println("Enter your choice");
                        n=sc.nextInt();
                        break;
                    case 5:
                        System.out.println("Enter user Id whom you want to update");
                        id=sc.nextInt();
                        System.out.println("Enter updated user name");
                        name=sc.next();
                        System.out.println("Enter updated user gender");
                        gender=sc.next();
                        System.out.println("Enter updated user dob");
                        dob= sc.next();
                        userManager.updateUser(new User(id,name,gender,dob));
                        System.out.println("Enter your choice");
                        n=sc.nextInt();
                        break;

                    case 6:
                        System.out.println("Exited");
                        break;
                    default:
                        System.out.println("Enter valid choice");
                        break;
                }
            }
        }
        else{
            JdbcUserManager jdbcUserManager=new JdbcUserManager();
            while (n != 6) {
                switch (n) {
                    case 1:
                        System.out.print("Enter User ID:");
                        int id= sc.nextInt();
                        System.out.print("Enter User Name:");
                        String name= sc.next();
                        System.out.print("Enter User DOB:");
                        String dob= sc.next();
                        System.out.print("Enter User Gender:");
                        String gender=sc.next();
                        jdbcUserManager.addUser(new User(id,name,gender,dob));
                        System.out.print("Enter Your Choice:");
                        n = sc.nextInt();
                        break;
                    case 2:
                        System.out.println("Enter user Name whose record you want to delete: ");
                        name=sc.next();
                        jdbcUserManager.deleteUser(name);
                        System.out.print("Enter Your Choice:");
                        n = sc.nextInt();
                        break;
                    case 3:
                        System.out.println("Enter user name whom you want to search");
                        String username=sc.next();
                        List<User> matchUserList=jdbcUserManager.searchUsers(username);
                        for(User matchedUser: matchUserList){
                            System.out.println("ID: "+matchedUser.getId()+"\tName: "+matchedUser.getName()+"\tGender: "+matchedUser.getGender()+"\tDOB: "+matchedUser.getDob());
                        }
                        System.out.print("Enter Your Choice:");
                        n = sc.nextInt();
                        break;
                    case 4:
                        List<User> usersList=jdbcUserManager.listUsers();
                        for(User users:usersList){
                            System.out.println("UserID: "+users.getId()+"\tUserName: "+users.getName()+"\tUserGender: "+users.getGender() +"\tUserDob: "+users.getDob());
                        }
                        System.out.print("Enter Your Choice:");
                        n = sc.nextInt();
                        break;
                    case 5:
                        System.out.println("Enter user Id whose details you want to update:");
                        id=sc.nextInt();
                        System.out.println("Enter updated user name:");
                        name= sc.next();
                        System.out.println("Enter updated gender:");
                        gender=sc.next();
                        System.out.println("Enter updated dob");
                        dob=sc.next();
                        jdbcUserManager.updateUser(new User(id,name,gender,dob));
                        System.out.print("Enter Your Choice:");
                        n = sc.nextInt();
                        break;
                    case 6:
                        System.out.println("Exited");
                        break;

                    default:
                        System.out.println("Enter valid choice");
                        n = sc.nextInt();
                        break;
                }
            }
        }
    }
}
