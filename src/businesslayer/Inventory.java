/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DAO.Dao;
import DAO.Mysqldb;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author it world
 */
public class Inventory {
    public int a,b,c;
    public String d;
    public String getnameofproduct(int primarykey) throws ClassNotFoundException, SQLException
    {
        for(Product p:new Mysqldb().retrive())
        {
            if(p.getcode()==primarykey)
            {
                return p.getname();
            }
        }
        return "";
    }
     public int getkeyofproduct(String n) throws ClassNotFoundException, SQLException
    {
        for(Product p:new Mysqldb().retrive())
        {
            if(p.getname().equals(n))
            {
                return p.getcode();
            }
        }
        return 0;
    }
     public int getstockofproduct(String n) throws ClassNotFoundException, SQLException
    {
        for(Product p:new Mysqldb().retrive())
        {
            if(p.getname().equals(n))
            {
                return p.getstock();
            }
        }
        return 0;
    }
    public void updatequantity(String n,int q) throws ClassNotFoundException, SQLException{
        
        int pk=getkeyofproduct(n);
        Dao a=new Mysqldb();
        a.updateproductquantity(pk,q);
        
    }
     public void updatequantity2(String n,int q) throws ClassNotFoundException, SQLException{
        
        int pk=getkeyofproduct(n);
        int stock=getstockofproduct(n);
        Dao a=new Mysqldb();
        a.updateproductquantity(pk,stock+q);
        
    }
    public Inventory(int e,int g,int h,String i)
    {
        a=e;
        b=g;
        c=h;
        d=i;
    }

    public LinkedList<Inventory> retrive() throws ClassNotFoundException, SQLException{
        Dao a=new Mysqldb();
        return a.retriveinventory();
    }
}
