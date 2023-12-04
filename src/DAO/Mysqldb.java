/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import businesslayer.Category;
import businesslayer.Inventory;
import businesslayer.Product;
import businesslayer.User;
import businesslayer.dailyreport;
import businesslayer.monthlyreport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it world
 */
public class Mysqldb implements Dao {

    Connection c;
       public LinkedList<monthlyreport> fetchmonth(){
          LinkedList<monthlyreport> A = new LinkedList<>();
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            Statement stmt = c.createStatement();
            String query = "select* from monthlyreportsnew";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Retrieve data from the result set
              monthlyreport a=new monthlyreport(rs.getInt("month_number"),rs.getInt("year"),rs.getFloat("amountSold"));
              A.add(a);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;
        
    }
    public LinkedList<dailyreport> fetchdaily(){
          LinkedList<dailyreport> A = new LinkedList<>();
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            Statement stmt = c.createStatement();
            String query = "select* from dailyreports";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Retrieve data from the result set
              dailyreport a=new dailyreport(rs.getInt("day_number"),rs.getInt("month_number"),rs.getInt("year"),rs.getFloat("amountSold"));
              A.add(a);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;
        
    }

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
    public LinkedList<Category> getCategory() {
         LinkedList<Category> A = new LinkedList<>();
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            Statement stmt = c.createStatement();
            String query = "select* from categories";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
               int i= rs.getInt("category_id");
               String k= rs.getString("category_name");
               Category a=new Category(i,k);
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
    public LinkedList<Inventory> retriveinventory() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
        if (c != null) {
            System.out.println("connection is successful");
        }
        Statement stmt = c.createStatement();
        String query = "select* from inventory";
        ResultSet rs = stmt.executeQuery(query);
        LinkedList<Inventory> A = new LinkedList<>();
        while (rs.next()) {
            // Retrieve data from the result set
            Inventory a = new Inventory(rs.getInt("product_id"),rs.getInt("stock_quantity"),rs.getInt("low_stock_alert"),rs.getString("expiration_date"));
            A.add(a);
        }
        return A;
    }
    public void intocategory(String name) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String insertquery = "insert into categories (category_name) values (?) ";
            PreparedStatement pstmt = null;
            pstmt = c.prepareStatement(insertquery);
            pstmt.setString(1, name);
            int r = pstmt.executeUpdate();
            if (r > 0) {
                System.out.println("operation successfull");
            }
    }
    public void insertproduct(Product a) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
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
            String insertquery1 = "insert into inventory  (product_id,stock_quantity,low_stock_alert,expiration_date) values (?,?,?,?) ";
            PreparedStatement pstmt1 = null;
            pstmt1 = c.prepareStatement(insertquery1);
            pstmt1.setInt(1, a.getcode());
            pstmt1.setInt(2, a.getstock());
            pstmt1.setInt(3, 10);
            pstmt1.setString(4,"2024-10-10");
            int r1 = pstmt1.executeUpdate();
            if (r1 > 0) {
                System.out.println("operation successfull");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void insertProduct1(Product a) {
    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123")) {
            if (connection != null) {
                System.out.println("Connection is successful");

                // Insert into 'products' table
                String insertQuery = "INSERT INTO products (category_id, product_name, price, quantity) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                    pstmt.setInt(1, a.getcategorycode());
                    pstmt.setString(2, a.getname());
                    pstmt.setFloat(3, a.getprice());
                    pstmt.setInt(4, a.getstock());

                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Operation successful for products table");

                        // Retrieve the last inserted 'product_id'
                        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                int lastInsertedProductId = generatedKeys.getInt(1);

                                // Insert into 'inventory' table
                                String insertQuery1 = "INSERT INTO inventory (product_id, stock_quantity, low_stock_alert, expiration_date) VALUES (?, ?, ?, ?)";
                                try (PreparedStatement pstmt1 = connection.prepareStatement(insertQuery1)) {
                                    pstmt1.setInt(1, lastInsertedProductId);
                                    pstmt1.setInt(2, a.getstock());
                                    pstmt1.setInt(3, 10);
                                    pstmt1.setString(4, "2024-10-10");

                                    int rowsAffected1 = pstmt1.executeUpdate();
                                    if (rowsAffected1 > 0) {
                                        System.out.println("Operation successful for inventory table");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    } catch (ClassNotFoundException | SQLException ex) {
        ex.printStackTrace();
    }
}

     public void insertreportintodb(Float amount) {
        try {
            System.out.println("amount izz"+amount);
            Class.forName("com.mysql.cj.jdbc.Driver");
            LocalDate x=LocalDate.now();
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String insertquery = "INSERT INTO monthlyreportsnew (month_number, year, amountSold) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE amountSold = amountSold + ?";
            PreparedStatement pstmt = null;
            pstmt = c.prepareStatement(insertquery);
            pstmt.setInt(1,x.getMonthValue());
            pstmt.setInt(2, 2023);
            pstmt.setFloat(3,amount );
            pstmt.setFloat(4, amount);
            int r = pstmt.executeUpdate();
            if (r > 0) {
                System.out.println("operation  meraaa successfull");
            }
            String insertquery1 = "INSERT INTO dailyreports (day_number,month_number, year, amountSold) VALUES (?, ?, ?,?) ON DUPLICATE KEY UPDATE amountSold = amountSold + ?";
            PreparedStatement pstmt1 = null;
            pstmt1 = c.prepareStatement(insertquery1);
            pstmt1.setInt(1,x.getDayOfMonth());
            pstmt1.setInt(2,x.getMonthValue());
            pstmt1.setInt(3, 2023);
            pstmt1.setFloat(4,amount );
            pstmt1.setFloat(5, amount);
            int r1 = pstmt1.executeUpdate();
            if (r1 > 0) {
                System.out.println("operation  meraaa successfull");
            }
            //c.commit();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteproduct(int primarykey) {
        try {
            String deleteQuery = "DELETE FROM products WHERE product_id = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            // Create a PreparedStatement with the DELETE query
            PreparedStatement p = null;
            p = c.prepareStatement(deleteQuery);

            // Set value for the parameter
            p.setInt(1,primarykey);  // Set the value for employee_id

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
   
    public void updateproductquantity(int primarykey,int q) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String updateQuery = "UPDATE products SET quantity = ? WHERE product_id = ?";
             String updateQuery2 = "UPDATE inventory SET stock_quantity = ? WHERE product_id = ?";
            PreparedStatement p = null;
            PreparedStatement p1=null;
            // Create a PreparedStatement with the UPDATE query
            p = c.prepareStatement(updateQuery);
            p1=c.prepareStatement(updateQuery2);
            // Set values for the parameters
            p.setInt(1, q); // Set the new value for employee_name
            p.setInt(2, primarykey);                 // Set the value for employee_id
             p1.setInt(1, q); // Set the new value for employee_name
            p1.setInt(2, primarykey); 
            // Execute the UPDATE query
            int rowsAffected = p.executeUpdate();
            int rowsAffected1 = p1.executeUpdate();
            // Check the number of rows affected
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void updateproductprice(int primarykey,Float m) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String updateQuery = "UPDATE products SET price = ? WHERE product_id = ?";
            // String updateQuery2 = "UPDATE inventory SET stock_quantity = ? WHERE product_id = ?";
            PreparedStatement p = null;
            //PreparedStatement p1=null;
            // Create a PreparedStatement with the UPDATE query
            p = c.prepareStatement(updateQuery);
           // p1=c.prepareStatement(updateQuery2);
            // Set values for the parameters
            p.setFloat(1, m); // Set the new value for employee_name
            p.setInt(2, primarykey);                 // Set the value for employee_id
            // p1.setInt(1, q); // Set the new value for employee_name
           // p1.setInt(2, primarykey); 
            // Execute the UPDATE query
            int rowsAffected = p.executeUpdate();
            //int rowsAffected1 = p1.executeUpdate();
            // Check the number of rows affected
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void updateproductname(int primarykey,String m) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_management_system", "root", "123");
            if (c != null) {
                System.out.println("connection is successful");
            }
            String updateQuery = "UPDATE products SET product_name = ? WHERE product_id = ?";
             //String updateQuery2 = "UPDATE inventory SET stock_quantity = ? WHERE product_id = ?";
            PreparedStatement p = null;
           // PreparedStatement p1=null;
            // Create a PreparedStatement with the UPDATE query
            p = c.prepareStatement(updateQuery);
           // p1=c.prepareStatement(updateQuery2);
            // Set values for the parameters
            p.setString(1, m); // Set the new value for employee_name
            p.setInt(2, primarykey);                 // Set the value for employee_id
           //  p1.setInt(1, q); // Set the new value for employee_name
           // p1.setInt(2, primarykey); 
            // Execute the UPDATE query
            int rowsAffected = p.executeUpdate();
            //int rowsAffected1 = p1.executeUpdate();
            // Check the number of rows affected
            if (rowsAffected > 0) {
                System.out.println("Update successful. Rows affected: " + rowsAffected);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Mysqldb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
