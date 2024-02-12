#include<bits/stdc++.h>
using namespace std;

#define int long long
#define endl '\n'

signed main(){
    ios_base::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    
    for (int testcase = 1; testcase <= 10; testcase++) {
        // Generate the input file name with zero-padding
        string input_file = "0" + to_string(testcase) + ".in";
        if (testcase >= 10) {
            input_file = to_string(testcase) + ".in";
        }

        // Replace the following line to read input from the generated input file
        ifstream input(input_file);
        cin.rdbuf(input.rdbuf());

        int n; cin >> n;
        int l = 1;

        // Dynamically allocate an array based on n
        int* ind = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ind[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int x; cin >> x;
            ind[x] = i;
        }
        int c = 1;

        for (int i = 1; i <= n; i++) {
            if (l > ind[i])
                c++;
            l = ind[i];
        }

        // Output the result to the terminal with zero-padding
        cout << "Test Case " << setw(2) << setfill('0') << testcase << ": " << c << endl;

        // Deallocate the dynamically allocated array
        delete[] ind;
    }
}
