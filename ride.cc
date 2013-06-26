/*
ID: cellofo1
PROG: ride
LANG: C++
*/
#include <fstream>
using namespace std;

ifstream fin("ride.in");
ofstream fout("ride.out");

long num(string s)
{
    long prod = 1;
    for(int i = 0; i<s.length(); i++)
        prod *= ( (int)(s[i]-'A')) + 1;
    return prod;
}
int main() {
    string comet, group;
    fin >> comet >> group;
    if (num(group)%47==num(comet)%47)
    {
        fout << "GO\n";
    }
    else
        fout<<"STAY\n";
    return 0;
}   
