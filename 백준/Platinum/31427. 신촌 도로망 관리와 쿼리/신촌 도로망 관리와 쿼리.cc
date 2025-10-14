#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int idx, school;
    Edge(int idx=0, int school=0) : idx(idx), school(school) {}
};

struct Info {
    int idx, school;
    long long cost;
    Info(int idx=0, int school=0, long long cost=0) : idx(idx), school(school), cost(cost) {}
};
struct Cmp {
    bool operator()(const Info& a, const Info& b) const {
        return a.cost > b.cost; // min-heap
    }
};

static const int MAX = 5;

int n, m, q;
vector<vector<Edge>> graph_;
array<int,5> used[MAX][MAX][MAX][MAX][MAX];

bool schoolVisit[MAX];

void input() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m >> q;

    graph_.assign(n + 1, {});
    for (int i = 0; i < m; i++) {
        int x, y; char zc;
        cin >> x >> y >> zc;
        int z = zc - 'A';
        graph_[x].push_back(Edge(y, z));
        graph_[y].push_back(Edge(x, z));
    }
}

void mst(int order[MAX]) {
    array<int,5> curUsed{}; // 0으로 초기화

    vector<char> visit(n + 1, 0);
    priority_queue<Info, vector<Info>, Cmp> que;

    int visitCount = 1;
    visit[1] = 1;
    for (const auto& next : graph_[1]) {
        que.emplace(next.idx, next.school, order[next.school]);
    }

    while (!que.empty()) {
        Info cur = que.top(); que.pop();
        if (visit[cur.idx]) continue;

        visit[cur.idx] = 1;
        curUsed[cur.school]++;
        visitCount++;

        if (visitCount == n) {
            while (!que.empty()) que.pop();
            break;
        }

        for (const auto& nxt : graph_[cur.idx]) {
            if (visit[nxt.idx]) continue;
            que.emplace(nxt.idx, nxt.school, order[nxt.school]);
        }
    }

    used[order[0]][order[1]][order[2]][order[3]][order[4]] = curUsed;
}

void recur(int depth, int order[MAX]) {
    if (depth == MAX) {
        mst(order);
        return;
    }
    for (int i = 0; i < MAX; i++) {
        if (schoolVisit[i]) continue;
        schoolVisit[i] = true;
        order[depth] = i;
        recur(depth + 1, order);
        schoolVisit[i] = false;
    }
}

void init() {
    memset(schoolVisit, 0, sizeof(schoolVisit));
    int order[MAX] = {0,0,0,0,0};
    recur(0, order);
}

void pro() {
    ostringstream sb;
    while (q-- > 0) {
        int realCost[MAX];
        vector<array<int,2>> orderArr; orderArr.reserve(5);

        for (int i = 0; i < 5; i++) {
            cin >> realCost[i];
            orderArr.push_back({i, realCost[i]}); // (school, cost)
        }

        sort(orderArr.begin(), orderArr.end(), [](const array<int,2>& a, const array<int,2>& b){
            return a[1] < b[1];
        });

        int rank_[5];
        for (int i = 0; i < 5; i++) {
            int school = orderArr[i][0];
            rank_[school] = i;
        }

        const array<int,5>& eachUsed = used[rank_[0]][rank_[1]][rank_[2]][rank_[3]][rank_[4]];
        long long sum = 0;
        for (int i = 0; i < MAX; i++) {
            sum += 1LL * eachUsed[i] * realCost[i];
        }
        sb << sum << '\n';
    }
    cout << sb.str();
}

int main() {
    input();
    init();
    pro();
    return 0;
}