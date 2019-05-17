/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdp_version_2;

/**
 *
 * @author Asus
 */
public class log {
    
    String s;
    log(String s)
    {
        this.s=s;
    }
    
    String f()
    {
        if(s.equals("x"))
        {
            return "1/x";
        }
        return "1/"+s+"*d("+s+")/dx";
    }
}
