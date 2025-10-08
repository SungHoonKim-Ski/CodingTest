# [Gold II] 룩의 이동 - 34513 

[문제 링크](https://www.acmicpc.net/problem/34513) 

### 성능 요약

메모리: 77976 KB, 시간: 884 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 최단 경로, 데이크스트라, 0-1 너비 우선 탐색

### 제출 일자

2025년 10월 8일 17:57:43

### 문제 설명

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>×</mo><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N \times N$</span></mjx-container> 크기의 체스판 위에 흑 룩, 백 킹, 그리고 그 외의 흑/백 기물들이 놓여 있다. 여러분은 흑 플레이어이며, 목표는 흑 룩을 이동하여 백 킹을 잡는 것이다.</p>

<p>룩의 이동 규칙은 다음과 같다.</p>

<ul>
<li>한 번의 이동에서 가로 또는 세로 방향으로 원하는 만큼 직선으로 이동할 수 있다. 단, 체스판 밖으로 이동할 수 없다.</li>
<li>이동 경로 중 같은 색 기물이 있는 칸은 뛰어넘을 수 없으며, 해당 칸에 멈출 수도 없다.</li>
<li>이동 경로 중 다른 색 기물이 있는 칸은 뛰어넘을 수 없지만, 그 칸에 멈춰 해당 기물을 잡을 수 있다.</li>
</ul>

<p>백 킹 또한 다른 색 기물로 취급된다. 흑 룩이 백 킹을 잡는 데 필요한 최소 이동 횟수를 구해보자.</p>

### 입력 

 <p>첫 번째 줄에 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다.</p>

<p>그다음 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 걸쳐 체스판의 상태가 주어지며, 각 줄은 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>의 문자열로 이루어진다. 입력으로 주어지는 문자는 다음과 같다.</p>

<ul>
<li><span style="color:#e74c3c;"><code>R</code></span>: 흑 룩</li>
<li><span style="color:#e74c3c;"><code>K</code></span>: 백 킹</li>
<li><span style="color:#e74c3c;"><code>B</code></span>: 다른 흑 기물</li>
<li><span style="color:#e74c3c;"><code>W</code></span>: 다른 백 기물</li>
<li><span style="color:#e74c3c;"><code>.</code></span>: 빈 칸</li>
</ul>

<p>체스판에서 흑 룩과 백 킹은 각각 하나만 주어진다. 다른 흑/백 기물은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>0</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$0$</span></mjx-container>개 이상 주어지며, 일반적인 체스와 달리 개수에 제한이 없다. 같은 칸에 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2$</span></mjx-container>개 이상의 기물이 있는 경우는 존재하지 않는다.</p>

### 출력 

 <p>만약 흑 룩이 백 킹을 잡을 수 있다면 첫 번째 줄에 필요한 최소 이동 횟수를 출력한다.</p>

<p>만약 흑 룩이 백 킹을 잡을 수 없다면 첫 번째 줄에 <span style="color:#e74c3c;"><code>-1</code></span>을 출력한다.</p>

