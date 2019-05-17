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
public class Simplification {
    String s;
    Simplification(String s)
    {
        this.s=s;
    }
    
    int simplify(String temp)
    {
        String t="";
        int n=1;
        for(int i =0 ;i<temp.length() ; i++)
        {
            if(temp.charAt(i) >= '0' && temp.charAt(i) <= '9')
            {
                t+=temp.charAt(i);
            }
            else if(temp.charAt(i) == '*')
            {
                n= n* Integer.parseInt(t);
                t="";
            }
        }
        if(t.equals("") == false)
        {
            n = n * Integer.parseInt(t);
        }
        return n;
    }
    String f()
    {
        int i,j,k1=0,k2=0,tempint=0;
        String ans="",temp="",temp2="",temp3="";
        boolean b = false;
        for(i=0;i<s.length();i++)
        {
           if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
           {
               temp+=s.charAt(i);
           }
           else if(s.charAt(i) == '*' && temp.equals("") == false && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9' )
           {
               temp+=s.charAt(i);
           }
           else if(temp.equals("") )
           {
               ans+=s.charAt(i);
           } 
           else
           {
               ans = ans + ""+simplify(temp) + s.charAt(i);
               temp = "";
           }
           
        }
        if( i == s.length() && temp.equals("") == false )
        {
            ans = ans + ""+simplify(temp);
        }
        return ans;
        
    }
}
