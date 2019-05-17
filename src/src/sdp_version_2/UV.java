/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdp_version_2;

import java.util.Stack;

/**
 *
 * @author Asus
 */
public class UV {
      String s;
      UV(String s)
      {
          this.s=s;
         
      }
      
      String f()
      {
          Stack st=new Stack();
          int i,j;
          String u="",v="";
          for(i=0;i<s.length();i++)
          {
              if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i) == '[')
              {
                  st.push(s.charAt(i));
              }
              if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
              {
                  st.pop();
              }
              if(s.charAt(i)=='*' && s.contains("x")==true && st.empty()==true)
              {
                  i++;
                  break;
              }
              u+=s.charAt(i);
          }
          for( ; i< s.length() ;i++)
          {
              v+=s.charAt(i);
          }
          return "["+u+"]*d("+v+")/dx"+"+["+v+"]*d("+u+")/dx";
      }
}
