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
    private Product product;
    public Item(int a,float b,Product c){
        quantityordered=a;
        price=b;
        product=c;
    }
    
}
