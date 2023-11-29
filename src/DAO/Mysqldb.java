/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import businesslayer.Product;
import businesslayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it world
 */
public class Mysqldb implements Dao {

    Connection c;

    public LinkedList<User> getuser() {
         LinkedList<User> A = new LinkedList<>();
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            Statement stmt = c.createStatement();
            String query = "select* from users";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Retrieve data from the result set
                User a = new User(rs.getString("username"), rs.getString("password"), rs.getString("role"));
                A.add(a);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;
    }

    @Override
    public LinkedList<Product> retrive() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
        if (c != null) {
            System.out.println("connection is successful");
        }
        Statement stmt = c.createStatement();
        String query = "select* from products";
        ResultSet rs = stmt.executeQuery(query);
        LinkedList<Product> A = new LinkedList<>();
        while (rs.next()) {
            // Retrieve data from the result set
            Product a = new Product(rs.getInt("product_id"), rs.getFloat("price"), rs.getString("product_name"), rs.getInt("quantity"), rs.getInt("category_id"));
            A.add(a);
        }
        return A;
    }

    public void insertproduct(Product a) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/harry", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String insertquery = "insert into products (category_id,product_name,price,quantity) values (?,?,?,?) ";
            PreparedStatement pstmt = null;
            pstmt = c.prepareStatement(insertquery);
            pstmt.setInt(1, a.getcategorycode());
            pstmt.setString(2, a.getname());
            pstmt.setFloat(3, a.getprice());
            pstmt.setInt(4, a.getstock());
            int r = pstmt.executeUpdate();
            if (r > 0) {
                System.out.println("operation successfull");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteproduct(Product a) {
        try {
            String deleteQuery = "DELETE FROM product WHERE product_name = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/harry", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            // Create a PreparedStatement with the DELETE query
            PreparedStatement p = null;
            p = c.prepareStatement(deleteQuery);

            // Set value for the parameter
            p.setString(1, a.getname());  // Set the value for employee_id

            // Execute the DELETE query
            int rows = p.executeUpdate();

            // Check the number of rows affected
            if (rows > 0) {
                System.out.println("Deletion successful. Rows affected: " + rows);
            } else {
                System.out.println("Deletion failed. No matching record found.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateproduct(Product a) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String updateQuery = "UPDATE employees SET name = ? WHERE id = ?";
            PreparedStatement p = null;
            // Create a PreparedStatement with the UPDATE query
            p = c.prepareStatement(updateQuery);

            // Set values for the parameters
            p.setString(1, "sohaib"); // Set the new value for employee_name
            p.setInt(2, 3);                 // Set the value for employee_id

            // Execute the UPDATE query
            int rowsAffected = p.executeUpdate();

            // Check the number of rows affected
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            }
            String deleteQuery = "DELETE FROM employees WHERE id = ?";

            // Create a PreparedStatement with the DELETE query
            p = c.prepareStatement(deleteQuery);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
