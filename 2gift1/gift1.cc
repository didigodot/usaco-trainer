/*
ID: cellofo1
PROG: gift1
LANG: C++
*/
#include <fstream>
#include <iostream>
#include <map>
#include<sstream>
#include<stdio.h>
#include<stdlib.h>
#include<string>
#include<vector>
using namespace std;

ifstream fin("gift1.in");
ofstream fout("gift1.out");

int main() {
    //put all the names in the map
    map<string,int> friends;
    map<string,int> ufriends;
    string nu; getline(fin,nu);
    int n = atoi(nu.c_str());
    vector<string> nombre;
    nombre.resize(n);
    nombre.insert(2,"d");
    for(int i = 0; i<n; i++)
        {
            string name; getline(fin, name);
            friends.insert(std::pair<string,int>(name,-9999));
            //nombre.push_back(name);
        }
    ufriends = friends; //ufriends is a copy of friends which will be updated later
    for(int i = 0; i<n; i++)
    {
        string name; getline(fin, name);
        string initial; getline(fin, initial, ' ');
        if(friends.at(name)== -9999)
        {
            int val = atoi(initial.c_str());
            friends.at(name)=val;
            ufriends.at(name)=val;
        }
        string div; getline(fin, div); //number of people to give money to
        int ii = atoi(initial.c_str());
        int di = atoi(div.c_str());
        float give = (float)ii/di; //amount for each person
        int giv = give; //integer division
        for(int i = 0; i<di;i++)  //distribute the monies
        {
            string asdf; getline(fin, asdf); //name of person to give to
            if(friends.at(asdf) == -9999)
            {
                friends.at(asdf) = giv;
                ufriends.at(asdf)= giv;
            }
            if(ufriends.at(asdf)==-9999)
                ufriends.at(asdf)=giv;
            else
                ufriends.at(asdf)=ufriends.at(asdf)+giv;
        }
        ufriends.at(name)=ufriends.at(name)-giv*atoi(div.c_str());
    }
    for(int j = 0; j<n;j++)
    {
//       fout<< nombre.at(j) <<" "<< ufriends.at(nombre.at(j))-friends.at(nombre.at(j))<< '\n';
    }
    return 0;
}

