- [Fish](https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/)

## 접근 방법
    - 0번째 물고기가 1번째 물고기보다 상류에 존재한다.
    - 0은 상류 1은 하류를 의미한다.
    - 기준 물고기를 정하자 ( 기준 물고기 : 다음 물고기랑 만날 물고기 )
    - 내려가는 물고기가 나올때까지 탐색을 한다    
    - 내려가는 물고기를 만나면 이 물고기가 기준 물고기가 된다.
    - 기준 물고기랑 다음 물고기를 비교한다.
    - 같은 방향일 경우 기준 물고기가 다음 물고기로 변경된다.
    - 다른 방향일 경우 한명이 잡혀 먹힌다. (올라가는 물고기)
	   1. 잡아먹었을 경우 : 기준 물고기가 고정
	   2. 잡혀먹혔을 경우 : 기준 물고기는 사라진다.
    - 다시 내려가는 물고기를 찾는다.
    - 찾으면 기준물고기로정하고 위 로직을 반복한다.

## 소스코드

~~~java
public int solution(int[] a, int[] b) {
		int liveCnt=0;
		int nowFish = 0;
		int nextFish = 0;
		int fixFish = 0;
		for(int i=0; i<a.length-1; i++){
			if(b[i]==1){
				nowFish = a[i];
				nextFish = a[i+1];
				if(b[i+1]==0){
					if(nextFish > nowFish){
						fixFish = nextFish;
					}else{
						fixFish = nowFish;
					}
				}else{
					liveCnt++;
				}
			}else{
				
			}
			
		}
        return 0;
    }
~~~

## 개선사항
    1. 아직 문제를 정확하게 이해 하지 못했다.

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 0% | 0% | 0% |
