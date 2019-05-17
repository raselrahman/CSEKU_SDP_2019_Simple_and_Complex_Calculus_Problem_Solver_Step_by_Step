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
public class x_to_the_power_n {
    String s2,s3;
    x_to_the_power_n (String s2, String s3)
    {
        this.s2=s2;
        if(s3.contains("("))
        {
            for(int i = 1 ; i< s3.length() - 1 ; i++)
            {
                
                this.s3+= s3.charAt(i);
            }
        }
        this.s3=s3;
    }
    String f()
    {
        int n=Integer.parseInt(s3);
        if(s2.contains("+")==false && s2.contains("-")==false && s2.contains("^")==false && s2.contains("sin")==false && s2.contains("cos")==false && s2.contains("tan")==false && s2.contains("sec")==false && s2.contains("cot")==false && s2.contains("log")==false)
        {   
        if(n==1 )
        {
            String temp="";
            for(int i=0;i<s2.length();i++)
            {
                if((s2.charAt(i)!='x') && !(s2.charAt(i)=='*' && s2.charAt(i+1)=='x'))
                {
                    temp+=s2.charAt(i);
                }
            }
        
           if(temp=="")
            {
                return "1";
            }
            return temp;
        }
        else if(n==2)
        {
            return s3+"*"+s2;
        }
        else if(n < 0)
        {
              return s3+"*"+s2+"^"+"("+(n-1)+")";
        }
        return s3+"*"+s2+"^"+""+(n-1);
        }
        if(n==1)
        {
            return "d("+s2+")/dx";
        }
        else if(n==2)
        {
            return "["+s3+"*("+s2+")]*d("+s2+")/dx";
        }
        else if(n < 0)
        {
               return "["+s3+"*("+s2+")^("+(n-1)+")]*d("+s2+")/dx";
        }
        return "["+s3+"*("+s2+")^"+(n-1)+"]*d("+s2+")/dx";
    }
}
