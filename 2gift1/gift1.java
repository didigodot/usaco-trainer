/*
ID: cellofo1
PROG: gift1
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class gift1
{
    public static void main(String[] args) throws IOException
    {
        int large = -99999999;
        BufferedReader fin = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int N = Integer.parseInt(fin.readLine());
        String[] names = new String[N];
        Map<String, Integer> foo = new HashMap<String, Integer>();
        Map<String, Integer> foo1 = new HashMap<String, Integer>();
        for(int i = 0; i<N; i++)
        {
            names[i]=fin.readLine();
            foo.put(names[i],large);
            foo1.put(names[i],large);
        }
        for(int i = 0; i<N; i++)
        {
            String name = fin.readLine();
            StringTokenizer st = new StringTokenizer(fin.readLine());
            int initial = Integer.parseInt(st.nextToken());
            int div = Integer.parseInt(st.nextToken());
            if(foo.get(name)==large)
            {
                foo.put(name,initial);
                foo1.put(name,initial);
            }
            int give;
            if(div==0)
                give = 0;
            else
                give = initial/div;
            for(int k = 0; k<div; k++)
            {
                String dn = fin.readLine();
                if(foo.get(dn)==large)
                {
                    foo.put(dn,give);
                    foo1.put(dn,give);
                }
                if(foo1.get(dn)==large)
                    foo1.put(dn,give);
                else
                    foo1.put(dn,foo1.get(dn)+give);
            }
            foo1.put(name, foo1.get(name)-give*div);
        }
        for(int j = 0; j<N; j++)
        {
            int d = foo1.get(names[j])-foo.get(names[j]);
            out.println(names[j]+" "+d);
        }
        out.close();
        System.exit(0);        
    }
}
