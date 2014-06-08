/*
ID: cellofo1
PROG: friday
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class date
{
    private int w; private int m; private int d; private int y;
    public date(int weekday, int month, int day, int year)
    {
        w = weekday; m = month; d = day; y = year;
    }
    public int getWeek()
    {
        return w;
    }
    public int getMonth()
    {
        return m;
    }
    public int getDay()
    {
        return d;
    }
    public int getYear()
    {
        return y;
    }
    public int compareTo(date D)
    {
        if(y-D.getYear()==0)
        {
            if(m-D.getMonth()==0)
                return d-D.getDay();
            else
                return m-D.getMonth();
        }
        else
            return y-D.getYear();
    }
    public boolean leapYear()
    {
        if(y%4==0)
        {
            if(y%100==0 && y%400!=0)
                return false;
            return true;
        }
        return false;
    }
    public String toString()
    {
        return w+" "+m+" "+d+" "+y;
    }
}
public class friday
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int N = Integer.parseInt(in.readLine());
        int[] count = new int[7];
        for(int i = 0; i<7; i++)
            count[i]=0;
        date d = new date(3,1,1,1900);//week mo day year
        int delta=12; 
        int newweek=(d.getWeek()+delta%7)%7;
        d=new date(newweek,1,13,1900);
        date end = new date(-1,12,31,1900+N-1);
        Set<Integer> thirties = new HashSet<Integer>();
        thirties.add(4);thirties.add(6);thirties.add(9);thirties.add(11);
        Set<Integer> thirtyones= new HashSet<Integer>();
        thirtyones.add(1);thirtyones.add(3);thirtyones.add(5);thirtyones.add(7);thirtyones.add(8); thirtyones.add(10); thirtyones.add(12);
        //start looping!
        while(d.compareTo(end)<0)
        {
            count[d.getWeek()-1]+=1;
            if(d.getMonth()==2)
            {
                if(d.leapYear())
                {
                    delta = 29;
                }
                else
                    delta = 28;
            }
            if(thirties.contains(d.getMonth()))
                delta = 30;
            else if(thirtyones.contains(d.getMonth()))
                delta = 31;
            newweek = (d.getWeek()+delta%7);
            if(newweek>7)
                newweek = newweek%7;
            int newyr;
            int newmonth;
            if(d.getMonth()==12)
            {
                newyr = d.getYear()+1;
                newmonth=1;
            }
            else
            {
                newyr = d.getYear();
                newmonth=d.getMonth()+1;
            }
            d = new date(newweek,newmonth,13,newyr);
           
        }
        for(int i = 0; i<6; i++)
            out.print(count[i]+" ");
        out.print(count[6]);
        out.println();
        out.close();
        System.exit(0);
    }
}

