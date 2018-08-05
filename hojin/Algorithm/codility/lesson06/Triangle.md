- [Triangle](https://app.codility.com/programmers/lessons/6-sorting/triangle/)

## 접근 방법
    1. 정렬이 된 상태면 아래 조건을 항상 만족 함
        1. Q + R > P
        2. P + R > Q
    2. 그래서 추가적으로 P + Q > R 조건만 확인 하면 됨
    3. long 형변환 이유는 Max int value일 경우 연산을 위하여 처리 함

## 소스코드

~~~java
public int solution(int[] a) {
		Arrays.sort(a);
		if(a.length >100000){
			return 0;
		}
		for (int i = 0; i < a.length - 2; i++) {
			if ((long)a[i] + (long)a[i + 1] > (long)a[i + 2]) {
				return 1;
			}
		}
		return 0;
	}
~~~

## 개선사항

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
