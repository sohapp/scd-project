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
public class Cart implements Itemcontainer{
    LinkedList<Item> CArt;
    public Cart(){
        CArt=new LinkedList<>();
    }
    public LinkedList<Item> retr(){
        
        return CArt;
    }
    public void add(Item a){
        
        CArt.add(a);
    }
    public void remove(Item a){
        CArt.remove();
    }
    public boolean  update(String Itemname){
        boolean flag=false;
        for(Item b:CArt){
           if(b.getname().equals(Itemname))
           {
             b.updateprice();
             b.updatequantityordered(1);
             flag=true;
           }
        }
        return flag;
    }
    public float total(){
        float sum=0;
        for(Item b:CArt){
           sum=sum+(b.getprice());
        }
        return sum;
    }

    
    
}
