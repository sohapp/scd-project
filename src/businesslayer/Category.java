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
public class Category {
    public  String name;
    public int code;
    public LinkedList<Category> getcategorydata(){
       Dao a=new Mysqldb();
       return a.getCategory();
   }
    public boolean validatecategoryid(int i)
    {
        Dao a=new Mysqldb();
        for(Category x:a.getCategory())
        {
            if(x.code==i) return true;
        }
        return false;
    }
    public Category(int b,String a)
    {
        name=a;
        code=b;
    }
    public void addcategory()
    {
        
        
    }
    public void removecategory()
    {
        
        
    }
    public void addproduct(Product a)
    {
        
    }
    public void removeproduct(Product a)
    {
       
    }
    public int getcode(){
        return code;
    }
}
