/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package businesslayer;

/**
 *
 * @author it world
 */
public interface Itemcontainer {
    public void add(Item a);
    public void remove(Item a);
    public void  update(Item a,int quantity);
    public float total();
}
