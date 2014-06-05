/*
ID: cellofo1
PROG: gift1
LANG: C++
*/
#include <fstream>
#include <iostream>
#include <map>
#include<vector>
using namespace std;

ifstream fin("gift1.in");
ofstream fout("gift1.out");

int main() {
    //put all the names in the map
    map<string,vector<int> > friends;
    string n;
    getline(fin,n);
    for(int i = 0; i<std::stoi(n); i++)
        {
            string name;
            getline(fin, name);
            vector<int> empty(0,0);
            friends.insert(std::pair<string,vector<int> >(name,empty));
        }
    //start adding and subtracting values
    string s;
    getline(fin, s); //name
    string initial; //inital value
    getline(fin, initial,' ');
    vector<int> init(std::stoi(initial),std::stoi(initial));
    friends.at(s)= init;//assign 
    string div; //number of people to divide into
    getline(fin, div, ' ');
    int give = std::stoi(initial)/std::stoi(div);
    for(int i = 0; i<std::stoi(div);i++)
    {
        string asdf;
        getline(fin, asdf);
        friends.at(asdf).at(1)=friends.at(asdf).at(1)+give;
    }
    friends.at(s).at(1)-=give*std::stoi(div);
    fout<<friends.at("dave").at(0);
    return 0;
}

