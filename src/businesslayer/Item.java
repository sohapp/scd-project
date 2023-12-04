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
public class Item {

    private int quantityordered;
    private float price;
    private String product;

    public Item(int a, float b, String c) {
        quantityordered = a;
        price = b;
        product = c;
    }

    public String getname() {

        return product;
    }

    public int getquantityordered() {

        return quantityordered;
    }
    public void updateprice()
    {
        price=price+price;
    }
    public void updatequantityordered(int a){
        
        quantityordered=quantityordered+a;
    }
    public void updatestock(int a){
        ///needs to be updated
        //product.updatestock(a);
    }
    public float getprice() {
        return price;
    }
}
