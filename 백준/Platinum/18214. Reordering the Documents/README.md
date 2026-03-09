# [Platinum I] Reordering the Documents - 18214 

[문제 링크](https://www.acmicpc.net/problem/18214) 

### 성능 요약

메모리: 210608 KB, 시간: 676 ms

### 분류

수학, 다이나믹 프로그래밍, 그래프 이론, 조합론, 배낭 문제, 이분 그래프

### 제출 일자

2026년 3월 9일 19:59:53

### 문제 설명

<p>Susan is good at arranging her dining table for convenience, but not her office desk.</p>

<p>Susan has just finished the paperwork on a set of documents, which are still piled on her desk. They have serial numbers and were stacked in order when her boss brought them in. The ordering, however, is not perfect now, as she has been too lazy to put the documents slid out of the pile back to their proper positions. Hearing that she has finished, the boss wants her to return the documents immediately in the document box he is sending her. The documents should be stowed in the box, of course, in the order of their serial numbers.</p>

<p>The desk has room just enough for two more document piles where Susan plans to make two temporary piles. All the documents in the current pile are to be moved one by one from the top to either of the two temporary piles. As making these piles too tall in haste would make them tumble, not too many documents should be placed on them. After moving all the documents to the temporary piles and receiving the document box, documents in the two piles will be moved from their tops, one by one, into the box. Documents should be in reverse order of their serial numbers in the two piles to allow moving them to the box in order.</p>

<p>For example, assume that the pile has six documents #1, #3, #4, #2, #6, and #5, in this order from the top, and that the temporary piles can have no more than three documents. Then, she can form two temporary piles, one with documents #6, #4, and #3, from the top, and the other with #5, #2, and #1 (Figure E.1). Both of the temporary piles are reversely ordered. Then, comparing the serial numbers of documents on top of the two temporary piles, one with the larger number (#6, in this case) is to be removed and stowed into the document box first. Repeating this, all the documents will be perfectly ordered in the document box.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/615bf0d9-4f43-4562-b11f-f4e09fc4f106/-/preview/" style="width: 590px; height: 149px;"></p>

<p style="text-align: center;">Figure E.1. Making two temporary piles</p>

<p>Susan is wondering whether the plan is actually feasible with the documents in the current pile and, if so, how many different ways of stacking them to two temporary piles would do. You are asked to help Susan by writing a program to compute the number of different ways, which should be zero if the plan is not feasible.</p>

<p>As each of the documents in the pile can be moved to either of the two temporary piles, for n documents, there are 2<sup>n</sup> different choice combinations in total, but some of them may disturb the reverse order of the temporary piles and are thus inappropriate.</p>

<p>The example described above corresponds to the first case of the sample input. In this case, the last two documents, #5 and #6, can be swapped their destinations. Also, exchanging the roles of two temporary piles totally will be OK. As any other move sequences would make one of the piles higher than three and/or make them out of order, the total number of different ways of stacking documents to temporary piles in this example is 2 × 2 = 4</p>

### 입력 

 <p>The input consists of a single test case of the following format.</p>

<pre>n m
s<sub>1</sub> . . . s<sub>n</sub></pre>

<p>Here, n is the number of documents in the pile (1 ≤ n ≤ 5000), and m is the number of documents that can be stacked in one temporary pile without committing risks of making it tumble down (n/2 ≤ m ≤ n). Numbers s<sub>1</sub> through s<sub>n</sub> are the serial numbers of the documents in the document pile, from its top to its bottom. It is guaranteed that all the numbers 1 through n appear exactly once.</p>

### 출력 

 <p>Output a single integer in a line which is the number of ways to form two temporary piles suited for the objective. When no choice will do, the number of ways is 0, of course.</p>

<p>If the number of possible ways is greater than or equal to 10<sup>9</sup> + 7, output the number of ways modulo 10<sup>9</sup> + 7.</p>

