# [Gold V] 달력 - 20207 

[문제 링크](https://www.acmicpc.net/problem/20207) 

### 성능 요약

메모리: 15556 KB, 시간: 156 ms

### 분류

그리디 알고리즘, 구현, 정렬

### 제출 일자

2025년 7월 30일 14:26:26

### 문제 설명

<p> 수현이는 일년의 날짜가 1일부터 365일로 표시되어있는 달력을 가지고있다. 수현이는 너무나도 계획적인 사람이라 올 해 일정을 모두 계획해서 달력에 표시해놨다. </p>

<p>여름이 거의 끝나가자 장마가 시작되었고, 습기로 인해 달력에 표시한 일정이 지워지려고 한다. 지워지는 것을 막고자 수현이는 일정이 있는 곳에만 코팅지를 달력에 붙이려고 한다. 하지만 너무 귀찮았던 나머지, 다음과 같은 규칙을 따르기로 한다.</p>

<ul>
	<li>연속된 두 일자에 각각 일정이 1개 이상 있다면 이를 일정이 연속되었다고 표현한다.</li>
	<li>연속된 모든 일정은 하나의 직사각형에 포함되어야 한다. </li>
	<li>연속된 일정을 모두 감싸는 가장 작은 직사각형의 크기만큼 코팅지를 오린다.</li>
</ul>

<p>달력은 다음과 같은 규칙을 따른다.</p>

<ul>
	<li>일정은 시작날짜와 종료날짜를 포함한다.</li>
	<li>시작일이 가장 앞선 일정부터 차례대로 채워진다.</li>
	<li>시작일이 같을 경우 일정의 기간이 긴 것이 먼저 채워진다.</li>
	<li>일정은 가능한 최 상단에 배치된다.</li>
	<li>일정 하나의 세로의 길이는 1이다. </li>
	<li>하루의 폭은 1이다. </li>
</ul>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/1a820e79-e5fc-4e4a-b7ad-efe42cfd7cdd/" style="width: 720px; height: 225px;"></p>

<p>위의 그림에서와 같이 일정이 주어졌다고 하자. 여기서 코팅지의 면적은 아래의 파란색 영역과 같다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/680c1b8a-7ae1-4b00-ba41-e1c61cd64846/" style="width: 720px; height: 224px;"></p>

<p>이때 코팅지의 크기의 합은 3 x 8 + 2 x 2 = 28이다. </p>

<p>일정의 개수와 각 일정의 시작날짜, 종료날짜가 주어질 때 수현이가 자르는 코팅지의 면적을 구해보자.</p>

### 입력 

 <p>첫째 줄에 일정의 개수 N이 주어진다. (1 ≤ N ≤ 1000)</p>

<p>둘째 줄부터 일정의 개수만큼 시작 날짜 S와 종료 날짜 E가 주어진다. (1 ≤ S ≤ E ≤ 365)</p>

### 출력 

 <p>코팅지의 면적을 출력한다.</p>

