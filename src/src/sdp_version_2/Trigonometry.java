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
public class Trigonometry {
    String s;
    Trigonometry(String s)
    {
        this.s=s;
    }
    String sin()
    {
        if(s.equals("x"))
        {
            return "cosx";
        }
        return "[cos"+s+"]*[d("+s+")/dx]";
    }
      String cos()
    {
        if(s.equals("x"))
        {
            return "(-sinx)";
        }
        return "[-sin"+s+"]*[d("+s+")/dx]";
    }
      String tan()
    {
        if(s.equals("x"))
        {
            return "(secx)^2";
        }
        return "[[sec"+s+"]^2]*[d("+s+")/dx]";
    }
         String cosec()
    {
        if(s.equals("x"))
        {
            return "[-cosecx.cotx]";
        }
        return "[-cosec"+s+"].[cot"+s+"].[d("+s+")/dx]";
    }
       String sec()
    {
        if(s.equals("x"))
        {
            return "secx.tanx";
        }
        return "[sec["+s+"]].[tan["+s+"]].[d("+s+")/dx]";
    }
          String cot()
    {
        if(s.equals("x"))
        {
            return "[-[cosecx]^2]";
        }
        return "[-[cosec"+s+"]^2]*[d("+s+")/dx]";
    }   
}
