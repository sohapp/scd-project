/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import businesslayer.Product;
import businesslayer.User;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author it world
 */
public interface Dao {
    public LinkedList<Product> retrive() throws ClassNotFoundException, SQLException;
    public void insertproduct(Product a);
    public void deleteproduct(Product a);
    public void updateproduct(Product a);
    public LinkedList<User>  getuser();
}
