package com.wavemaker.controller;
import com.wavemaker.constants.PersistentType;
import com.wavemaker.manager.UserManager;
import com.wavemaker.manager.implementations.InMemoryStorageUserManager;
import com.wavemaker.manager.implementations.JdbcUserManager;
public class UserManagerFactory {
 public UserManager chooseMethod (PersistentType.MemoryType memoryType){
     UserManager userManager = null;
     switch(memoryType){
         case JDBC:
             userManager = new JdbcUserManager();
             break;
         case InMemory:
             userManager =new InMemoryStorageUserManager();
             break;
         default:
             break;
     }
     return userManager;
 }
}
