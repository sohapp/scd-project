/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DAO.Dao;
import DAO.Mysqldb;
import java.util.LinkedList;

/**
 *
 * @author it world
 */
public class User {

    private String password;
    private String username;
    private String role;

    public User(String a, String b, String c) {
        username = a;
        password = b;
        role = c;
    }

    public String getpassword() {
        return password;
    }

    public String getusername() {
        return username;
    }

    public String getrole() {
        return role;
    }

    public boolean validatesa(String a, String b) {
        Dao A = new Mysqldb();
        boolean flag = false;
        LinkedList<User> B = A.getuser();
        for (User x : B) {
            System.out.println(x.getusername()+x.getpassword()+x.getrole());
            System.out.println(a+b+"SalesAssistant");
            if ((x.getusername().equals(a)) && (x.getpassword().equals(b)) && ("SalesAssistant".equals(x.getrole()))) {
                
                System.out.println("i am here");
                return true;
            }
        }
        return flag;
    }
     public boolean validatemanager(String a, String b) {
        Dao A = new Mysqldb();
        boolean flag = false;
        LinkedList<User> B = A.getuser();
        for (User x : B) {
            System.out.println(x.getusername()+x.getpassword()+x.getrole());
            System.out.println(a+b+"SalesAssistant");
            if ((x.getusername().equals(a)) && (x.getpassword().equals(b)) && ("Manager".equals(x.getrole()))) {
                
                System.out.println("i am here");
                return true;
            }
        }
        return flag;
    }
}
