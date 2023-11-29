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
public class order {
    private String customername;
    private String  timestamp;
    LinkedList<Item> A=new LinkedList<>();
    public void add(Item a){
        A.add(a);
    }
    public void remove(Item a){
        A.remove(a);
    }
    
}
