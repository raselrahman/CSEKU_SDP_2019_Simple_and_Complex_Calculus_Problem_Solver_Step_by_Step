/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdp_version_2;

import java.util.Vector;
import java.util.Stack;
/**
 *
 * @author Asus
 */
public class Parting {
     StringBuffer sbr;
     Vector <String> v=new Vector();
     Stack bracket_capturing=new Stack();
     boolean uv=false,b=false;
     Parting(StringBuffer sbr)
     {
         this.sbr=sbr;
     }
     String portioning()
     {
         char c = '0';
         String s1="",s2="",s3="",ans="",constant1="",constant2="";
         int i,j;
         for( i=0;i<sbr.length();i++)
         {
             if(sbr.charAt(i)!='+' && sbr.charAt(i)!='-')
             {        
                 if(sbr.charAt(i)== 'x' && c=='0')
                 {
                     c = 'x';
                 }
                 else if(sbr.charAt(i) == 'c' && c=='0')
                 {
                     c = 'c';
                 }
                 else if(sbr.charAt(i) == 's' && c== '0')
                 {
                     c = 's';
                 }
                 else if(sbr.charAt(i) == 't' && c=='0')
                 {
                     c = 't';
                 }
                 else if(sbr.charAt(i) == 's' && c=='0')
                 {
                     c='s';
                 }
                 else if(sbr.charAt(i) == 'l' && c=='0')
                 {
                     c='l';
                 }
                 s1+=sbr.charAt(i);
             }
             else if((sbr.charAt(i)=='+' || sbr.charAt(i)=='-') && bracket_capturing.empty()== false)
             {
                 s1+=sbr.charAt(i);
             }
              if(sbr.charAt(i)=='(' || sbr.charAt(i)=='{' || sbr.charAt(i)=='[')
             {
                 bracket_capturing.push(sbr.charAt(i));
                 b=true;
             }
             else if((sbr.charAt(i) =='+' || sbr.charAt(i) == '-') && (bracket_capturing.empty()== true )) 
             {
                  
                 if(s1.contains("x")==false)
                 {
                     //ans=ans+"0";
                     s1=s2=s3="";
                     if(sbr.charAt(i) == '-')
                     {
                         ans+='-';
                     }
                     continue;
                 }
                    if(  s1.contains("^(")==true  && uv == false  )
                 {  
                    int k;
                     for( k=0;k<s1.length();k++)
                     {
                         if(s1.charAt(k) == '(' || s1.charAt(k) == '{' || s1.charAt(k) == '[')
                         {
                             bracket_capturing.push(s1.charAt(k));
                         }
                         else if(s1.charAt(k) == ')' || s1.charAt(k) == '}' || s1.charAt(k) == ']')
                         {
                             bracket_capturing.pop();
                         }
                         if(s1.charAt(k)=='^' && bracket_capturing.empty() == true)
                         {
                            break;   
                         }
                         else
                         {
                             s2+=s1.charAt(k);
                         }
                     }
                     for(k=k+2;k<s1.length();k++)
                     {
                         if(s1.charAt(k) != ')')
                         {
                             s3+=s1.charAt(k);
                         }
                         
                     }
                     if(k>=s1.length() && s3=="")
                     {
                         s3="1";
                     }
                     x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
                     ans=ans+obj.f()+sbr.charAt(i);
                    
                    s1=s2=s3="";
                    
                 }

                else if(b==false && s1.contains("log")==false && s1.contains("sin")==false && s1.contains("cos")==false && s1.contains("tan")==false && s1.contains("cosec")==false && s1.contains("sec")==false && s1.contains("cot")==false)
                 {
                     int k;
                     for( k=0;k<s1.length();k++)
                     {
                         if(s1.charAt(k)!='^')
                         {
                             s2+=s1.charAt(k);
                         }
                         else
                         {
                             break;
                         }
                     }
                     for(k=k+1;k<s1.length();k++)
                     {
                         s3+=s1.charAt(k);
                     }
                     if( s3=="")
                     {
                         s3="1";//when power is one
                     }
                     x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
                     ans=ans+obj.f()+""+sbr.charAt(i);
                     c='0';
                    s1=s2=s3="";
                 }
                 else if(uv==false)
                 {
                     // for log
                    /* if(s1.contains("l["))
                     { 
                         for(j =1 ;j<s1.length();j++)
                         {
                             if(s1.charAt(j)=='[' && bracket_capturing.empty()==true)
                             {
                                 bracket_capturing.push(s1.charAt(j));
                                 continue;
                             }
                             if(s1.charAt(j)=='(' || s1.charAt(j)=='{' || s1.charAt(j)=='[')
                             {
                                 bracket_capturing.push(s1.charAt(j));
                             }
                             else if(s1.charAt(j)==')' || s1.charAt(j) == '}' || s1.charAt(j) == ']')
                             {
                                 bracket_capturing.pop();
                                 if(bracket_capturing.empty()==true)
                                 {
                                     break;
                                 }
                             }
      
                             s2+=s1.charAt(j);
                             
                         }
                         log l = new log(s2);
                         ans=ans+ l.f();
                         continue;
                     } */  
                     // for log 
                    /*           //// --------------- must be checked ------------------------------------
                     int a= 0;
                    for( a = 0 ; a< s1.length() ; a++)
                    {
                        if(s1.charAt(a) >= '0' && s1.charAt(a) <= '9')
                        {
                            constant1 += s1.charAt(a);
                        }
                        else
                        {
                            break;
                        }
                    }
                    for( ; a < s1.length() ; a++)
                    {
                        constant2 += s1.charAt(a);
                    }
                    s1 = constant2;
                    
                    
                    ///// -----------------must be checked ----------------------------------
                    */
             
                     if(c=='l' && s1.contains("log") && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'l')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         log l = new log(s2);
                         ans =   ans + constant1+l.f()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     } 
                     if(c=='s' && s1.contains("sin" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 's')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.sin()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     }
                     if(c=='c' && s1.contains("cosec" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                          int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+5;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cosec()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;  
                     }
                     if(c=='t' && s1.contains("tan" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                          int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 't')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.tan()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     }
                     if(c=='c' && s1.contains("cos" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                          int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cos()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     }
                     if(c== 's' &&s1.contains("sec" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                           int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 's')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.sec()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     }
                     if( c=='c' && s1.contains("cot" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
             
                                                 int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cot()+sbr.charAt(i);
                         s1=s2=s3="";
                         b= false;
                         continue;
                     }
                    // different function hbe x^n e x ar n sense kora
                     b=false;
                     for( j=s1.length()-1;j>0;j--)
                     {
                         if(s1.charAt(j)=='^' && (s1.charAt(j-1)==')' || s1.charAt(j-1)=='}' || s1.charAt(j-1)==']')) // positive power
                         {
                              break;
                         }
                         else if(s1.charAt(j)==')' || s1.charAt(j) == '}' || s1.charAt(j) == ']') // power 1
                         {
                             break;
                         }
                     }
                     for( j=0;j<s1.length();j++) // power positive or 1
                     {
                         if (s1.charAt(j)=='(' || s1.charAt(j)=='{' || s1.charAt(j)== '[') // condition of opening bracket
                         {
                             if(bracket_capturing.empty() == false)
                             {
                                 s2+=s1.charAt(j);
                             }
                             bracket_capturing.push(s1.charAt(j));
                             continue;
                         }
                         else if(s1.charAt(j)==')' || s1.charAt(j) == '}' || s1.charAt(j) == ']') // condition of closing bracket
                         {
                             bracket_capturing.pop();
                             if(bracket_capturing.empty() == false)
                             {
                                 s2+=s1.charAt(j);
                                 continue;
                             }
                             else
                             {
                                 break;
                             }
                         }
                             s2+=s1.charAt(j);   
                     }
                   
                       if(j<s1.length())
                     {
                         if(s1.charAt(j)==')' || s1.charAt(j)=='}' || s1.charAt(j)==']')
                         {
                             j++;
                         }
                       
                     }
                       
                     for( ;j < s1.length();j++)
                     {
                         if(s1.charAt(j) != '^')
                         {
                             s3+=s1.charAt(j);
                         }
                     }
                     if(s3=="")
                     {
                         s3+="1";
                     }
                      x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
                     ans=ans+obj.f()+""+sbr.charAt(i);
                     //System.out.println("s2="+s2+"\ns3="+s3);
                     s1=s2=s3="";
                     
                    
                 }
                // for uv
                else
                 {
                     UV uv=new UV(s1);
                     ans=ans+uv.f()+sbr.charAt(i);
                     this.uv = false;
                     s1=s2=s3="";
                     //return ans;
                 }
             }
             else if(sbr.charAt(i) == ')' || sbr.charAt(i) == '}' || sbr.charAt(i) == ']'  ) 
             {
                 bracket_capturing.pop();
                 if(i==sbr.length()-1 )
                 {
                     //uv=false;
                 }
                 
                 else if(sbr.charAt(i+1) == '*' || sbr.charAt(i+1)=='(' || sbr.charAt(i+1)=='{' || sbr.charAt(i+1)=='[')  // uv
                 {
                     uv=true;   
                 }
                 //s1+=sbr.charAt(i);
                // System.out.println("s1="+s1);
             }
         }
         if(i==sbr.length())
         {
              if(s1.contains("x")==false)
                 {
                     ans=ans+"0";
                     s1=s2=s3="";
                     
                 }

              else if( b==false && s1.contains("log")==false && s1.contains("sin")==false && s1.contains("cos")==false && s1.contains("tan")==false && s1.contains("cosec")==false && s1.contains("sec")==false && s1.contains("cot")==false)
                 {
                     int k;
                     for( k=0;k<s1.length();k++)
                     {
                         if(s1.charAt(k)!='^')
                         {
                             s2+=s1.charAt(k);
                         }
                         else
                         {
                             break;
                         }
                     }
                     for(k=k+1;k<s1.length();k++)
                     {
                         s3+=s1.charAt(k);
                     }
                     if(k>=s1.length() && s3=="")
                     {
                         s3="1";
                     }
                     x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
                     ans=ans+obj.f();
                     
                    s1=s2=s3="";
                 }

                else if(uv==false)
               {
                   // for log
                    if(c=='l' && s1.contains("log") && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                       int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'l')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         log l = new log(s2);
                         ans =   ans + constant1+l.f();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }  
                     if(c=='s' && s1.contains("sin" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 's')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.sin();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                     if(c=='c' && s1.contains("cosec" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                                                  int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+5;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cosec();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                      if(c=='t' && s1.contains("tan" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                       int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 't')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.tan();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                     if(c=='c' &&  s1.contains("cos" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cos();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                      if(c=='s' && s1.contains("sec" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 's')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.sec();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                       if(s1.charAt(0)=='c' && s1.contains("cot" ) && !(s1.charAt(0)=='(' || s1.charAt(0)=='{' || s1.charAt(0)=='['))
                     {
                         int a;
                         for( a =0; a<s1.length();a++)
                         {
                             if(s1.charAt(a) == 'c')
                             {
                                 break;
                             }
                             else
                             {
                                 constant1+=s1.charAt(a);
                             }
                         }
                         s2="";
                         for(j=a+3;j<s1.length();j++)
                         {
                             s2+=s1.charAt(j);
                         }
                         Trigonometry t = new Trigonometry(s2);
                         ans =   ans + constant1+t.cot();
                         s1=s2=s3="";
                         b= false;
                         return ans;
                     }
                    if(  s1.contains("^(")==true  && uv == false && !(s1.charAt(0) == '(' || s1.charAt(0) == '{' || s1.charAt(0) == '[') )
                 {  
                    int k;
                     for( k=0;k<s1.length();k++)
                     {
                         if(s1.charAt(k) == '(' || s1.charAt(k) == '{' || s1.charAt(k) == '[')
                         {
                             bracket_capturing.push(s1.charAt(k));
                         }
                         else if(s1.charAt(k) == ')' || s1.charAt(k) == '}' || s1.charAt(k) == ']')
                         {
                             bracket_capturing.pop();
                         }
                         if(s1.charAt(k)=='^' && bracket_capturing.empty() == true)
                         {
                            break;   
                         }
                         else
                         {
                             s2+=s1.charAt(k);
                         }
                     }
                     for(k=k+2;k<s1.length();k++)
                     {
                         if(s1.charAt(k) != ')')
                         {
                             s3+=s1.charAt(k);
                         }
                         
                     }
                     if(k>=s1.length() && s3=="")
                     {
                         s3="1";
                     }
                     x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
                     ans=ans+obj.f();
                    
                    s1=s2=s3="";
                     return ans;
                 }

             // different function hbe x^n e x ar n sense kora
                     
                     for( j=s1.length()-1;j>0;j--)
                     {
                         if(s1.charAt(j)=='^' && (s1.charAt(j-1)==')' || s1.charAt(j-1)=='}' || s1.charAt(j-1)==']')) // positive power
                         {
                              break;
                         }
                         else if(s1.charAt(j)==')' || s1.charAt(j) == '}' || s1.charAt(j) == ']') // power 1
                         {
                             break;
                         }
                     }
                     for( j=0;j<s1.length();j++) // power positive or 1
                     {
                        
                         if (s1.charAt(j)=='(' || s1.charAt(j)=='{' || s1.charAt(j)== '[') // condition of opening bracket
                         {
                             if(bracket_capturing.empty() == false)
                             {
                                 s2+=s1.charAt(j);
                             }
                             bracket_capturing.push(s1.charAt(j));
                             continue;
                         }
                         else if(s1.charAt(j)==')' || s1.charAt(j) == '}' || s1.charAt(j) == ']') // condition of closing bracket
                         {
                             bracket_capturing.pop();
                             if(bracket_capturing.empty() == false)
                             {
                                 s2+=s1.charAt(j);
                                 continue;
                             }
                             else
                             {
                                 break;
                             }
                         }
                             s2+=s1.charAt(j);  
                             
                     }
                     if(j<s1.length())
                     {
                         j++;
                     }
                     for( ;j < s1.length();j++)
                     {
                         if(s1.charAt(j) != '^')
                         {
                             s3+=s1.charAt(j);
                         }
                     }
                     if(j==s1.length() && s3=="")
                     {
                         s3="1";
                     }
                      x_to_the_power_n obj=new x_to_the_power_n(s2,s3);
           ans=ans+obj.f();
          s1=s2=s3="";
               }

                   else
                 {
                     UV uv=new UV(s1);
                     ans=uv.f();
                     return ans;
                 }
                    
         }
          
          return ans;
     }
}
