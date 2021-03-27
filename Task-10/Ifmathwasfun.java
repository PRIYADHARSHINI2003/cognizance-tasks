import java.util.*;
import java.lang.*;
import java.io.*;


class Ifmathwasfun
{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(sc.readLine());
        double b=0.0,c=0.0;
        String s[];
		while(t-->0)
		{
		    s=sc.readLine().split(" ");
		    b=Double.parseDouble(s[0]);
		    c=Double.parseDouble(s[1]);
		    double low=0.0, high=Math.PI/2, x=(high+low)/2, rhs=(x*x+b*x+c), lhs=(2*x+b)*Math.tan(x);
		    while(Math.abs(lhs-rhs)>0.0000001)
		    {
		        if(lhs<rhs)
		        {
		            low = x;
		        }
		        else
		        {
		            high = x;
		        }
		        x=(high+low)/2;
		        rhs=(x*x+b*x+c);
		        lhs=(2*x+b)*Math.tan(x);
		    }
		    double res = (x*x + b*x + c)/Math.sin(x);
		    System.out.println(res);
		}
	}
}
