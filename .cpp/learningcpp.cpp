#include <iostream>
#include <string>
#include <cmath>
using namespace std;
//int main() { std::cout << "Hello World" << std::endl; }
//int main() { cout << "Hello World!"; return 0;} 
//int main() {cout << "\"Hello World!\"" << endl; cout << "\t\"I am learning C++\""; return 0;}
/* int main() {int myNum = 5; double myFloatNum = 3.1415; 
char myLetter = 'A'; string myText = "Hello"; bool myBoolean = true; 
cout << myNum << endl << myFloatNum << "\n" << myLetter << "\n" << myText << "\n" << myBoolean;}
*/
//int main() {int x = 5; int y = 6; int z = 50; cout << x+y+z;}
//int main() {int x, y, z; x = y = z = 50; cout << x + y + z;}
//int main () { const int minutesPerHour = 60; const float PI = 3.1415;}
//int main() { int x; cout << "Type a number: "; cin >> x; cout << "Your number is: " << x;}
//int main() {int x, y; int sum; cout << "Type a number: "; cin >> x; cout << "Type another number: "; cin >> y; sum = x+y; cout << "The sum is: " << sum;}
//int main() {float f1 = 35e3; double d1 = 12E4; cout << f1 << endl << d1;}
//int main() {bool isCodingFun = true; bool isFishTasty = false; cout << isCodingFun << endl << isFishTasty;}
//int main() {char myGrade = 'A'; cout << myGrade << endl; char a = 65, b = 66, c = 67; cout << a << b << c;}
//int main() {string greeting = "Hello"; cout << greeting;}
//int main() {string firstName = "John"; string lastName = "Doe"; string fullName = firstName + " " + lastName; cout << fullName;}
//int main() {string firstName = "John"; string lastName = "Doe"; string fullName = firstName.append(" " + lastName); cout << fullName;}
//int main() {string txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; cout << "The length of the string \"txt\" is: " << txt.length();} or, txt.size();
//int main() {string myString = "Hello"; cout << myString[0];}
//int main() {string myString = "Hello"; cout << myString[1];}
//int main() {string myString = "Hello"; myString[0] = 'J'; cout << myString;}
//int main() {string fullName; cout <<"Type your full name: "; getline(cin, fullName); cout << "Your name is: " << fullName;}
//int main() { std::string greeting = "Hello"; std::cout << greeting; return 0;}
//int main() { cout << max(5, 10) << endl << min(5, 10) << endl << sqrt(64) << endl << round(2.6) << endl << log(2);}
/*int main() {
    int myAge = 25; int votingAge = 18; 
    if (myAge >= votingAge) { 
        cout << "Old enough to vote!";
    } else {
        cout << "Not old enough to vote.";
    }
}
int main() {
    if (20 > 18){
        cout << "20 is greater than 18" << endl;
    }
    int x = 20;
    int y = 18;
    if (x > y){
        cout << "x is greater than y";
    }
}
int main(){
    int time = 20;
    if (time < 12) {
        cout << "Good morning!\n";
    } else if (time > 12 && time < 18) {
        cout << "Good afternoon!\n";
    } else {
        cout << "Good evening!\n";
    }
} */
//int main() {int time = 20; cout << ((time<18) ? "Good day!" : "Good evening!");}
/*int main () {
    int day = 4;
    switch (day) {
    case 1:
        cout << "Monday";
        break;
    case 2:
        cout << "Tuesday";
        break;
    case 3:
        cout << "Wednesday";
        break;
    case 4:
        cout << "Thursday";
        break;
    case 5:
        cout << "Friday";
        break;
    case 6:
        cout << "Saturday";
        break;
    case 7:
        cout << "Sunday";
        break;
    }
}*/
/*int main (){
    int day = 4;
    switch (day) {
    case 6:
        cout << "Today is Saturday";
        break;
    case 7:
        cout << "Today is Sunday";
        break;
    default:
        cout << "Looking forward to the Weekend";
    }
}*/
/*int main (){
    int i = 0;
    while (i < 5) {
        cout << i << "\n";
        i++;
    }
}*/
/*int main() {
    int i = 0;
    do {
        cout << i << "\n";
        i++;
    }
    while (i <= 5);
}*/
/*int main() {
    // Outer loop
    for (int i = 1; i <= 2; ++i) {
        cout << "Outer: " << i << "\n"; // Executes 2 times

        // Inner loop
        for (int j = 1; j <= 3; ++j) {
            cout << " Inner: " << j << "\n"; // Executes 6 times (2 * 3)
        }
    }
}*/
/*int main() {
    int myNumbers[5] = {10, 20, 30, 40, 50};
    for (int i : myNumbers) {
        cout << i << "\n";
    }
}*/
/*int main() {
    for (int i = 0; i < 10; i++){
        if (i ==4){
            //break; stops the code at this point
            continue; // skips the point it is currently at
        }
        cout << i << "\n";
    }
    cout << "While loops: " << endl;
    int i = 0;
    while (i < 10) {
        cout << i << "\n";
        i++;
        if (i == 4) {
            break;
        }
    }
    cout << endl;
    int j = 0;
    while (j < 10) {
        if (j == 4) {
            j++;
            continue;
        }
        cout << j << "\n";
        j++;
    }  
}*/
/*int main() {
    string carsEmpty[4];
    string carsFull[4] {"Volvo", "BMW", "Ford", "Mazda"};
    int myNum[3] {10, 20, 30};
    cout << "Cars: \n";
    for (int i = 0; i < 5; i++) {
        cout << carsFull[i] << "\n";
    }
    int myNumbers[5] = {10, 20, 30, 40, 50};
    for (int i = 0; i < 5; i++) {
        cout << myNumbers[i] << "\n";
    }
    cout << "\n" << "For-each loop: " << "\n";
    for (int i : myNumbers) {
        cout << i << "\n";
    }
}*/
int main() {
    int myNumbers[5] = {10, 20, 30, 40, 50};
    cout << (sizeof(myNumbers) / sizeof(int));
}