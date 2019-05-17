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
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

public class Sdp_version_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f = new JFrame();
        JLabel l;
        String s,s1,s2="",s3,temp="",temp2="",temp3="";
        int i;
        boolean b2=false;
        StringBuffer sbr=new StringBuffer();
            String str3="";
        Stack bracket_capturing = new Stack();
        Stack <String> st = new Stack();
        int d = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 if you want result of differentiation.Enter 2 if you want result of integration. "));
        int begin=0, finish=0;
        if(d==1)
        {
           s=JOptionPane.showInputDialog("dy/dx will be determined. Enter y");
            System.out.println(""+s);
            sbr=new StringBuffer(s);
            str3=str3+"y="+s;
                   /// f() is for 2x=2*x  
        String ans=new String();
        boolean b=true;
        for( i=0;i<sbr.length();i++)
        {
            
            if(i>=2 )
            {
                if(sbr.charAt(i)=='g' && sbr.charAt(i-1)=='o' && sbr.charAt(i-2)=='l')
                {
                    continue;
                }
                if(sbr.charAt(i)=='n' && sbr.charAt(i-1)=='i' && sbr.charAt(i-2)=='s')
                {
                    continue;
                }
                if(!(sbr.charAt(i)==')' || sbr.charAt(i)=='}' || sbr.charAt(i)==']' || sbr.charAt(i)=='+' || sbr.charAt(i)=='-' || sbr.charAt(i)=='*' || sbr.charAt(i)=='^') && (sbr.charAt(i-1)==')' || sbr.charAt(i-1)=='}' || sbr.charAt(i-1)==']') ) 
                {
                    sbr.replace(i-1, i, sbr.charAt(i-1)+"*");
                    i++;
                    continue;
                }
            }
            if(i!=0 &&  !(sbr.charAt(i)>='0' && sbr.charAt(i)<='9') && (sbr.charAt(i-1)>='0' && sbr.charAt(i-1)<='9' ) && sbr.charAt(i)!='^'  && (sbr.charAt(i)!='+' && sbr.charAt(i)!='-' && sbr.charAt(i)!='*' &&sbr.charAt(i)!='/')  && sbr.charAt(i)!='^' && !(sbr.charAt(i)==')' || sbr.charAt(i)=='}' || sbr.charAt(i)==']'))//3* && !(sbr.charAt(i-1)=='+' || sbr.charAt(i-1)=='-' && sbr.charAt(i-1)=='*' &&sbr.charAt(i-1)=='/')  )
            {
               sbr.replace(i-1, i, sbr.charAt(i-1)+"*");
               i++;
            }
            else if(i!=0 && (sbr.charAt(i)=='(' || sbr.charAt(i)=='{' || sbr.charAt(i)=='[') && (sbr.charAt(i-1)!='+' && sbr.charAt(i-1)!='-' && sbr.charAt(i-1)!='*' && sbr.charAt(i)!='/' && sbr.charAt(i-1)!='^') && sbr.charAt(i)!='^' && (sbr.charAt(i-1)!='(' && sbr.charAt(i-1)!='{' && sbr.charAt(i-1)!='[') && !(sbr.charAt(i-1)=='g' && sbr.charAt(i-2)=='o' && sbr.charAt(i-3)=='l') )
            {
                if(!(sbr.charAt(i-1)=='n' && sbr.charAt(i-2)=='i' && sbr.charAt(i-3)=='s'))
                {
                if(!(sbr.charAt(i-1)=='s' && sbr.charAt(i-2)=='o' && sbr.charAt(i-3)=='c'))
                {
                if(!(sbr.charAt(i-1)=='n' && sbr.charAt(i-2)=='a' && sbr.charAt(i-3)=='t'))
                {
                if((i>=5 && !(sbr.charAt(i-1)=='c' && sbr.charAt(i-2)=='e' && sbr.charAt(i-3)=='s' && sbr.charAt(i-4)!='o' && sbr.charAt(i-5)!='c')) || i < 5)
                {
                if(!(sbr.charAt(i-1)=='c' && sbr.charAt(i-2)=='e' && sbr.charAt(i-3)=='s'))
                {
                if(!(sbr.charAt(i-1)=='t' && sbr.charAt(i-2)=='o' && sbr.charAt(i-3)=='c'))
                {
               sbr.replace(i-1, i, sbr.charAt(i-1)+"*");
               i++;
                }
                }
                }
                }
                }
                }
            }
           /* else if(i!=0 && (sbr.charAt(i)=='(' || sbr.charAt(i)=='{' || sbr.charAt(i)=='[') && (sbr.charAt(i-1)==')' || sbr.charAt(i-1)=='}' || sbr.charAt(i-1)==']') )
            {
               sbr.replace(i-1, i, sbr.charAt(i-1)+"*");
               i++;
            } 
            else if(i!=0 && (sbr.charAt(i)!='+' && sbr.charAt(i)!='-' && sbr.charAt(i)!='*' && sbr.charAt(i)!='/' && sbr.charAt(i)!='^') && (sbr.charAt(i-1)==')' || sbr.charAt(i-1)=='}' || sbr.charAt(i-1)==']'))
            {
                sbr.replace(i-1, i, sbr.charAt(i-1)+"*");
               i++;
            } */
        }
         l = new JLabel("y="+sbr);
         l.setBounds(50, 0, 10000, 50);
          l.setFont(new Font("Serif", Font.PLAIN, 25));
         f.add(l);
         System.out.println("y="+sbr);
         l = new JLabel("dy/dx=d("+sbr+")"+"/dx");
            l.setBounds(50,1*50,10000,50);
             l.setFont(new Font("Serif", Font.PLAIN, 25));
            f.add(l);
         
            System.out.println("dy/dx=d("+sbr+")"+"/dx");
            str3=str3+"\ndy/dx=d("+sbr+")"+"/dx";
        /* for( i=0;i<sbr.length();i++)
        {
            
             if((sbr.charAt(i)=='+' || sbr.charAt(i)=='-') && st.empty()== false)
            {
                String t=st.peek();
                if(t == "l[")
                {
                s2+="]";
                st.pop();
                }
            }
             if(i+2<sbr.length())  
             {
             if(sbr.charAt(i)=='l' && sbr.charAt(i+1)=='o' || sbr.charAt(i+2)=='g')
            {
                b2=true;
                s2+="l[";
                i+=2;
                st.push("l[");
            }
            } 
              if(b2==false)
            {
                b2=false;
                s2+=sbr.charAt(i);
            }
            if(sbr.charAt(i)=='(' || sbr.charAt(i)=='{' || sbr.charAt(i)== '[')
            {
                st.push(""+sbr.charAt(i));
            }
            else if(sbr.charAt(i)==')' || sbr.charAt(i)== '}' || sbr.charAt(i)== ']')
            {
                st.pop();
            }
           b2=false;
        } 
        if(st.empty()==false)
        {
            s2+="]";
        } 
           // System.out.println(""+s2);
            sbr=new StringBuffer(s2);
            s2="";*/
            Parting p=new Parting(sbr);
             ans=ans+p.portioning();
             StringBuffer str2=new StringBuffer(ans);
            /*  for(int k=0;k<str2.length();k++)
                 {
                     if(k!=0 && (str2.charAt(k)=='[' && str2.charAt(k-1)=='l'))
                     {
                         
                          str2.replace(k-1, k, str2.charAt(k-1)+"og");
                          k++;
                     }
                 } */
             int a=2;
             System.out.println("="+str2);
             l = new JLabel("="+str2);
             l.setBounds(50, a*50, 10000, 50);
             l.setFont(new Font("Serif", Font.PLAIN, 25));
             f.add(l);
             a++;
             str3+="="+str2;
             while(ans.contains("d("))
             {
                 b=false;
                 for( i=0;i<ans.length();i++)
                 {
                     if(!(ans.charAt(i)=='d' && ans.charAt(i+1)=='('))
                     {
                         temp2+=ans.charAt(i);
                     }
                     else
                     {
                         begin=i;
                         for(int j=i+1; ;j++)
                         {
                             if(!(ans.charAt(j)=='(' || ans.charAt(j)=='{' || ans.charAt(j)=='[') && !(ans.charAt(j)==')' || ans.charAt(j)=='}' || ans.charAt(j)==']')) // not bracketing condition
                             {
                                 temp+=ans.charAt(j);
                             }
                             if(ans.charAt(j)=='(' || ans.charAt(j)=='{' || ans.charAt(j)=='[')
                             {
                                 if(bracket_capturing.empty()==false)
                                 {
                                     temp+=ans.charAt(j);
                                 }
                                 bracket_capturing.push(ans.charAt(j));
                             }
                             if(ans.charAt(j)==')' || ans.charAt(j)=='}' || ans.charAt(j)==']')
                             {
                                 bracket_capturing.pop();
                                 if(bracket_capturing.empty()==false)
                                 {
                                     temp+=ans.charAt(j);
                                 }
                                 else
                                 {
                                     finish=j+1;
                                     i=finish+3;
                                     break;
                                 }
                             }
                             
                         }
                         StringBuffer sbr2=new StringBuffer(temp);
                             p=new Parting(sbr2);
                         temp3=temp3+temp2+"("+p.portioning()+")";
                         if(i<ans.length())
                         {
                             temp3+=ans.charAt(i);
                         }
                        // ans=temp3;
                         temp2=temp="";
                         
                     }
                 }
                 ans=temp3+temp2;
                 str2= new StringBuffer(ans);
                /* for(int k=0;k<str2.length();k++)
                 {
                     if(k!=0 && (str2.charAt(k)=='[' && str2.charAt(k-1)=='l'))
                     {
                         
                          str2.replace(k-1, k, str2.charAt(k-1)+"og");
                          k++;
                     }
                 } */
                 temp3="";
                 temp2="";
                 System.out.println("="+str2);
                 l= new JLabel("="+str2+" ");
                 l.setBounds(50, a*50, 10000, 50);
                 l.setFont(new Font("Serif", Font.PLAIN, 25));
                 f.add(l);
                 a++;
                 str3+=str3+"\n="+str2;
             }
             Simplification simple = new Simplification(str2+""); 
             int ragib = a+1;
             ans=simple.f();
             sbr = new StringBuffer(ans);
             for( i=1; i< sbr.length();i++ )
             {
                 if(sbr.charAt(i) == '-' && sbr.charAt(i-1) == '-')
                 {
                     sbr.replace(i-1, i+1, "+");
                 }
                 else if(sbr.charAt(i) == '+' && sbr.charAt(i-1) == '-')
                 {
                     sbr.replace(i-1, i+1, "-");
                 }
                 else if(sbr.charAt(i) == '-' && sbr.charAt(i-1) == '+')
                 {
                     sbr.replace(i-1, i+1, "-");
                 }
                 else if(sbr.charAt(i) == '+' && sbr.charAt(i-1) == '+')
                 {
                     sbr.replace(i-1, i+1, "+");
                 }
             }
                 l= new JLabel("Ans = "+sbr+"  ");
                 
                 l.setBounds(100, 50*ragib, 10000, 50);
                 l.setForeground(Color.MAGENTA);
                 l.setFont(new Font("Serif", Font.PLAIN, 30));
                
                 f.add(l);
                 a++;
                 str3+=str3+"\n="+str2;
             System.out.println("="+sbr);
            /*if(b==false)
            {
                System.out.println("="+ans);
            } */
            
             temp2="";
             f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             f.setBounds(100, 100, 100, 100);
             f.setVisible(true);
             
            
           
        }
        
                 /// 2x=2*x
                // JOptionPane.showMessageDialog(null, str3);
        
    }
    
}
