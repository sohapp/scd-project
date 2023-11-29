/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package businesslayer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author it world
 */
public class UserTest {
    
   
    @Test
    public void testValidatesa() {
        User a=new User("x","x","x");
       boolean flag= a.validatesa("sohaib", "f848884");
       assertEquals("false",flag);
    }
    
}
