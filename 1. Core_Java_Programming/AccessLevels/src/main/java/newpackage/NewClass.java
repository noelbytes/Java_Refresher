/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import com.corejava.accesslevels.AccessLevels;
/**
 *
 * @author noelbytes
 */
public class NewClass extends AccessLevels {
//    void test(AccessLevels m) {
//        m.myPublic = 0;     // allowed
        // m.myProtected = 0;  // inaccessible
        // m.myPackagePrivate = 0; // inaccessible
        // m.myPrivate = 0;    // inaccessible
//    }
    
    void test() {
        myPublic = 0;   // allowed
        myProtected = 0;    // allowed
        // myPackagePrivate = 0;   // inaccessible
        // myPrivate = 0;  // inaccessible
    }
}
