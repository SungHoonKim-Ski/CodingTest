# [Gold I] RoboThieves - 16023 

[문제 링크](https://www.acmicpc.net/problem/16023) 

### 성능 요약

메모리: 18684 KB, 시간: 220 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색

### 제출 일자

2025년 10월 22일 17:25:34

### 문제 설명

<p>A robot has stolen treasure from a factory and needs to escape without getting caught. The factory can be modelled by an N by M grid, where the robot can move up, down, left, or right.</p>

<p>Each cell of the grid is either empty, a wall, a camera, a conveyor, or the robot’s initial position. The robot can only walk on empty cells (denoted by .) or conveyors. The first row, last row, first column and last column of the grid consists of walls (denoted by W), and there may be walls in other cells.</p>

<p>Conveyors cause the robot to move in a specific direction, denoted by L, R, U, D for left, right, up, down respectively. The robot is unable to move on its own while on a conveyor. It is possible that the robot can become stuck forever on conveyors.</p>

<p>Cameras (denoted by C) can see in all four directions up, down, left, and right, but cannot see through walls. The robot will be caught if it is in the same cell as a camera or is seen by a camera while on an empty cell. Conveyors are slightly elevated, so the robot cannot be caught while on a conveyor, but cameras can see empty cells on the other side of conveyors.</p>

<p>The robot is initially at the cell denoted by S. The exit could be at any of the empty cells. For each empty cell, determine the minimum number of steps needed for the robot to move there without being caught, or determine that it is impossible to move there. A step consists of moving once up, down, left or right. Being moved by a conveyor does not count as a step.</p>

### 입력 

 <p>The first line of input contains two integers N and M (4 ≤ N, M ≤ 100). The next N lines of input will each contain M characters, each of which is one of the eight characters W, ., C, S, L, R, U, or D.</p>

<p>There will be exactly one S character and at least one . character. The first and last character of every row and column will be W.</p>

<p>For 5 of the 15 marks available, there are no cameras or conveyors.</p>

<p>For an additional 5 of the 15 marks available, there are no conveyors.</p>

### 출력 

 <p>For each empty cell, print one line with one integer, the minimum number of steps for the robot to move to this empty cell without being caught or −1 if it is impossible to move to this empty cell.</p>

<p>The output should be in row major order; the order of empty cells seen if the input is scanned line by line top-to-bottom and then left-to-right on each line. See the sample outputs for examples of row major order output.</p>

