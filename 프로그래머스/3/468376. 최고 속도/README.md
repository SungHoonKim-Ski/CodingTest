# [level 3] 최고 속도 - 468376 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/468376?language=java) 

### 성능 요약

메모리: 224 MB, 시간: 572.59 ms

### 구분

코딩테스트 연습 > 2025 카카오 하반기 1차

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 03월 13일 00:23:07

### 문제 설명

<p>2차원 좌표 평면 위에 1 ~ <code>n</code>의 번호가 있는 도시가 있습니다. 각 도시는 2차원 좌표 평면에서 점으로 나타냅니다. 또한 도시 사이를 이동하기 위한 자동차 도로가 있습니다. 각 도로는 2차원 좌표 평면에서 x축 혹은 y축에 평행한 선분으로 나타냅니다. 좌표 평면상에서 교차하거나 만나는 서로 다른 도로는 해당 지점에서 연결됩니다. 도로가 연결된 지점을 활용해 여러 도로를 경유할 수 있습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/7af4858b-b2e9-4d66-bd1e-7fcac145d82e/ex1-1.png" title="" alt="ex1-1.png"></p>

<ul>
<li>위 그림에서 파란색 마름모는 도시를 나타냅니다. 각 도시는 1 ~ 4의 번호가 있습니다.</li>
<li>굵은 회색 선분은 도로를 나타냅니다. </li>
<li>모든 도시는 도로가 지나가는 위치에 있습니다.</li>
</ul>

<p>모든 도로의 정중앙에는 과속 단속 카메라가 있습니다. 과속 단속 카메라가 있는 지점을 지나갈 때는 해당 카메라의 지정된 <code>제한 속도</code>이하로 주행해야 합니다. 만약 한 지점에 카메라가 여러 개 있다면, 그중 제한 속도가 가장 낮은 카메라의 제한을 따릅니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/0a764532-847d-444b-83ec-509d1071ae5d/ex1-2.png" title="" alt="ex1-2.png"></p>

<ul>
<li>각 도로의 정중앙에 있는 원은 해당 위치에 있는 단속 카메라의 제한 속도를 나타냅니다.</li>
</ul>

<p>당신은 1번 도시에서 출발하며, 출발 직전에 단 하나의 속도 <code>v</code>를 정하고 도착할 때까지 일정한 속도를 유지합니다. 2 ~ <code>n</code>번 도시 중 한 곳으로 갈 때, 각 도시마다 카메라 제한 속도를 지키면서 이동 가능한 최고 속도를 구해야 합니다.</p>

<p>다음은 위 예시에서 2, 3, 4번 도시로 갈 때, 일정한 최고 속도를 내기 위한 경로입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/3b5151d4-c10e-4aff-8dd3-1f8dc44e3e46/ex1-3.png" title="" alt="ex1-3.png"></p>

<ul>
<li>위와 같은 경로로 이동하면 최고 70까지 속도를 낼 수 있습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/f625fb25-1812-4811-a7c6-3a9cd908d191/ex1-4.png" title="" alt="ex1-4.png"></p>

<ul>
<li>위와 같은 경로로 이동하면 최고 50까지 속도를 낼 수 있습니다.</li>
</ul>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/8c7c8cc8-3172-45d2-aa43-adb99b0cef0a/ex1-5.png" title="" alt="ex1-5.png"></p>

<ul>
<li>위와 같은 경로로 이동하면 카메라를 지나치지 않으므로 제한 없이 속도를 낼 수 있습니다.</li>
</ul>

<p>각 도시의 위치를 담은 2차원 정수 배열 <code>city</code>와 도로의 정보를 담은 2차원 정수 배열 <code>road</code>가 매개변수로 주어집니다. 이때 1번 도시에서 출발해 각 2번 ~ <code>n</code>번 도시로 갈 때, 가능한 최고 속도를 도시 번호 순서대로 길이가 <code>n-1</code>인 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요. <strong>카메라를 지나치지 않고 갈 수 있는 도시는 최고 속도 대신 0을 담습니다.</strong></p>

<hr>

<h5>제한사항</h5>

<ul>
<li>2 ≤ <code>city</code>의 길이 = <code>n</code> ≤ 100

<ul>
<li><code>city[i]</code>는 <code>[x, y]</code> 형태이며, <code>i+1</code>번 도시의 위치가 <code>(x, y)</code>임을 의미합니다.</li>
<li>모든 도시는 도로가 지나가는 위치에 있으며, 각 도시의 위치가 서로 겹치지 않습니다.</li>
</ul></li>
<li>1 ≤ <code>road</code>의 길이 = <code>m</code> ≤ 1,000

<ul>
<li><code>road</code>의 원소는 <code>[x1, y1, x2, y2, limit]</code> 형태이며, 정중앙에 있는 카메라의 제한 속도가 <code>limit</code>인 <code>(x1, y1)</code>과 <code>(x2, y2)</code>를 잇는 선분 형태의 도로를 나타냅니다. 카메라의 위치는 도시의 위치와 겹치지 않습니다.</li>
<li>모든 도로는 x축 혹은 y축에 평행하며, 길이가 짝수입니다.</li>
<li><code>x1</code> ≤ <code>x2</code></li>
<li><code>y1</code> ≤ <code>y2</code></li>
<li>1 ≤ <code>limit</code> ≤ 1,000,000</li>
<li>서로 다른 두 도로는 최대 한 점에서만 만납니다. </li>
</ul></li>
<li>주어지는 모든 좌표의 절댓값은 10<sup>9</sup> 이하의 정수입니다.</li>
<li>모든 도시와 도로는 서로 연결되어 있습니다.</li>
</ul>

<hr>

<h5>테스트 케이스 구성 안내</h5>

<p>아래는 테스트 케이스 구성을 나타냅니다. 각 그룹은 하나 이상의 하위 그룹으로 이루어져 있으며, 하위 그룹의 모든 테스트 케이스를 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.</p>
<table class="table">
        <thead><tr>
<th>그룹</th>
<th>총점</th>
<th>추가 제한 사항</th>
</tr>
</thead>
        <tbody><tr>
<td>#1</td>
<td>15%</td>
<td>모든 도로는 x축에 평행합니다. 즉, <code>y1</code> = <code>y2</code>입니다.</td>
</tr>
<tr>
<td>#2</td>
<td>30%</td>
<td>주어지는 모든 좌표의 절댓값은 40 이하의 정수입니다.</td>
</tr>
<tr>
<td>#3</td>
<td>55%</td>
<td>추가 제한 사항 없음</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>city</th>
<th>road</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[-1, 3], [7, 3], [1, -1], [-2, 6]]</td>
<td>[[-1, 7, 7, 7, 80], [-3, 3, 9, 3, 45], [-2, -4, -2, 6, 60], [1, -4, 1, 8, 50], [5, 1, 5, 7, 70]]</td>
<td>[70, 50, 0]</td>
</tr>
<tr>
<td>[[3, 5], [3, 3], [2, 1], [9, 1], [7, -1]]</td>
<td>[[3, -2, 3, 4, 30], [5, 1, 9, 1, 29], [3, 4, 3, 8, 99], [1, 1, 5, 1, 99], [7, -3, 7, 5, 99]]</td>
<td>[0, 30, 29, 29]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>한 지점에 카메라가 여러 개 있는 경우, 그중 제한 속도가 가장 낮은 카메라의 제한을 따르므로 전체 그림은 아래와 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/43ea4102-bab4-408b-8b8d-eae4ece96c1a/ex2-1.png" title="" alt="ex2-1.png"></p>

<ul>
<li>2번 도시는 카메라를 지나치지 않고 갈 수 있습니다.</li>
<li>3번 도시는 최고 30까지 속도를 낼 수 있습니다.</li>
<li>4, 5번 도시는 최고 29까지 속도를 낼 수 있습니다.</li>
</ul>

<p>따라서 [0, 30, 29, 29]를 return 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges