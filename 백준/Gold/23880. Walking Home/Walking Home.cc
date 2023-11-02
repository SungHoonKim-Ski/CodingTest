#include <iostream>
#include <string>
#include <vector>

using namespace std;

void solve() {
  int n, k;
  cin >> n >> k;
  vector<string> g(n);
  for(int i = 0; i < n; i++) cin >> g[i];
  int ret = 0;
  if(k >= 1) {
    bool urcorner = true;
    bool dlcorner = true;
    for(int i = 0; i < n; i++) {
      if(g[0][i] == 'H' || g[i][n-1] == 'H') urcorner = false;
      if(g[i][0] == 'H' || g[n-1][i] == 'H') dlcorner = false;
    }
    ret += urcorner;
    ret += dlcorner;
  }
  if(k >= 2) {
    // use column j
    for(int j = 1; j < n-1; j++) {
      bool valid = true;
      for(int i = 0; i < n; i++) {
        if(g[i][j] == 'H') valid = false;
        if(i < j && g[0][i] == 'H') valid = false;
        if(i > j && g[n-1][i] == 'H') valid = false;
      }
      ret += valid;
    }
    // use row i
    for(int i = 1; i < n-1; i++) {
      bool valid = true;
      for(int j = 0; j < n; j++) {
        if(g[i][j] == 'H') valid = false;
        if(j < i && g[j][0] == 'H') valid = false;
        if(j > i && g[j][n-1] == 'H') valid = false;
      }
      ret += valid;
    }
  }
  if(k >= 3) {
    for(int i = 1; i < n-1; i++) {
      for(int j = 1; j < n-1; j++) {
        // RDRD
        bool valid = g[i][j] == '.';
        for(int a = 0; a < n; a++) {
          if(a <= i && g[a][j] == 'H') valid = false;
          if(a >= i && g[a][n-1] == 'H') valid = false;
          if(a <= j && g[0][a] == 'H') valid = false;
          if(a >= j && g[i][a] == 'H') valid = false;
        }
        ret += valid;
        valid = g[i][j] == '.';
        // DRDR
        for(int a = 0; a < n; a++) {
          if(a <= i && g[a][0] == 'H') valid = false;
          if(a >= i && g[a][j] == 'H') valid = false;
          if(a <= j && g[i][a] == 'H') valid = false;
          if(a >= j && g[n-1][a] == 'H') valid = false;
        }
        ret += valid;
      }
    }
  }
  cout << ret << "\n";
}
int main() {
  int t;
  cin >> t;
  while(t--) solve();
}