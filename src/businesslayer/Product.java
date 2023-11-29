/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import java.util.LinkedList;

/**
 *
 * @author it world
 */
public class Product {
    private int code;
    private float price;
    private int quantity;
    private String name;
     private int categorycode;
    public Product(int u,float a,String c,int b,int pp){
       price=a;
       quantity=b;
       name=c;
       code=u;
       categorycode=pp;
    }
    public int getcategorycode(){
       return categorycode; 
    }
    public float getprice(){
       return price; 
    }
    public int getcode(){
        
       return code;
    }
    public int getstock(){
       return  quantity; 
    }
    public String getname()
    {
        return name;
    }
    public float getcurrentprice(){
        
        return price;
    }
    public void updatestock(int a)
    {
        quantity=quantity+a;
    }
    
}
