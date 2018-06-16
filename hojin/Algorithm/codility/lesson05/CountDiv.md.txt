- [CountDiv](https:app.codility.com/programmers/lessons/5-prefix_sums/count_div/)

## 접근 방법
# 첫번 째 방법
	1. end와 start사이에 k가 몇번 들어가는지 구하자
	2. 그리고 start와  end가  k로 나누어 떨어진다면 +1씩 해주자.

# 두번 째 방법
	1. 0부터  end까지 k의 몇배수 까지 들어갈 수 있는지 구하자
	2. 0부터  start까지 k의 몇배수까지 들어갈 수 있는지 구하자
	3. start가 k의 배수일때는 +1를 추가한다, 이유 : 문제 제시가 start를 포함한 범위부터 구하기를 제시하기 때문
	4. (1)-(2)를 해주자

## 소스코드

~~~java
public int solution(int A, int B, int K) {
	
	return this.test(A, B, K);
}
public int test(int start, int end, int k){
	int temp = end/k - start/k;
	if(temp%k==0){
		temp+=1;
	}
	return temp;
}
~~~

## 개선사항

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
