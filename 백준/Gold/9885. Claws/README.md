# [Gold IV] Claws - 9885 

[문제 링크](https://www.acmicpc.net/problem/9885) 

### 성능 요약

메모리: 19492 KB, 시간: 156 ms

### 분류

그래프 이론, 그래프 탐색, 트리, 깊이 우선 탐색

### 제출 일자

2026년 1월 22일 18:04:39

### 문제 설명

<p>Consider a heavy machinery in the form of a binary tree (i.e., every non-leaf node has <em>at most two</em> child nodes) as shown in Figure 1. The edges of the tree are metal bars, which are connected by hinges, denoted by nodes (labelled ‘1’ through ‘5’) in the tree. The leaf nodes of the tree in Figure 1(a) are essentially the claws used by the heavy machinery to perform heavy-duty tasks. The claws are also connected to metal bars by hinges.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 363px; height: 214px;"></p>

<p style="text-align: center;">Figure 1: (a) A tree and (b) the corresponding tree of claws.</p>

<p>As the machinery is load-bearing, the hinges used to connect metal bars must be of the correct <em>grade</em>. For a particular node, say v, in the tree, the grade of the hinge used at that node is determined by the sum of (i) the total weight of the metal bars in the subtree rooted at v and (ii) the total weight of the metal bars from v to the tree root.</p>

<p>The weights of the metal bars are shown beside the corresponding edges in Figure 1. The claws and hinges used in the machinery are made of superlight materials that they can be considered weightless. Hence, the grades of the hinges used at leaf nodes ‘1’, ‘2’, and ‘3’ in Figure 1 to connect the claws to metal bars are 50, 30, and 50, respectively. The grade of the hinge used at node ‘4’ is 60, and the grade of the hinge used at the root node, ‘5’, is 110.</p>

<p>The <em>unladen load</em> of a claw is the sum of the grades of the hinges along the path from the claw to the root node. The unladen loads of the claws in this example are 220 (at ‘1’), 200 (at ‘2’), and 160 (at ‘3’). In this task, you have to output the maximum unladen load among all the claws of a given heavy machinery.</p>

### 입력 

 <p>Let n (1 ≤ n ≤ 12000) be the total number of nodes in the given binary tree. The input contains n lines. The first line contains the integer n. Each of the next (n − 1) lines contains three integers separated by spaces:</p>

<ul>
	<li><code>thisnode</code>, which specifies the node number of the current node.</li>
	<li><code>parnode</code>, which specifies the node number of the parent of the current node.</li>
	<li><code>weight</code>, which specifies the weight, a positive integer ≤ 100, of the metal bar connecting the current node and its parent node.</li>
</ul>

<p>The nodes are labelled 1 through n. The root node is the node without a parent.</p>

### 출력 

 <p>The output file contains an integer, which is the maximum unladen load among all the claws of a given heavy machinery.</p>

