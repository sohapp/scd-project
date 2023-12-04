/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import businesslayer.Category;
import businesslayer.Inventory;
import businesslayer.Product;
import businesslayer.User;
import businesslayer.dailyreport;
import businesslayer.monthlyreport;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author it world
 */
public interface Dao {
    public LinkedList<Product> retrive() throws ClassNotFoundException, SQLException;
    public void insertproduct(Product a);
     public void insertProduct1(Product a);
    //public void deleteproduct(Product a);
    //public void updateproduct(Product a);
    public void updateproductquantity(int primarykey,int q);
    public void deleteproduct(int primarykey);
    public void updateproductname(int primarykey,String m);
    public void updateproductprice(int primarykey,Float m);
    public LinkedList<User>  getuser();
    //public LinkedList<Category> getcategory();
    public LinkedList<Inventory> retriveinventory() throws ClassNotFoundException, SQLException;
    public LinkedList<monthlyreport> fetchmonth();
    public LinkedList<dailyreport> fetchdaily();
    public void insertreportintodb(Float amount);
    public LinkedList<Category> getCategory();
     public void intocategory(String name) throws ClassNotFoundException, SQLException;
}
