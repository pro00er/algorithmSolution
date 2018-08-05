- [Distinct](https://app.codility.com/programmers/lessons/6-sorting/distinct/)

## 접근 방법
# 첫번 째 방법
	1. 입력 배열값 중 값이 0인 인덱스를 값으로 저장되는 배열을 만든다 int zero[]
	2. 입력 배열값 중 값이 1인 인덱스를 값으로 저장되는 배열을 만든다 int one[]
	3. 이슈사항
		1. (P,Q)를 쌍으로 지정할 때 P < Q라는 조건이 있다
		2. 이를 해결하기 위해서 (1),(2)를 작업함
		3. if(zero[i] > one[j]) 일 경우 탐색을 종료하고 i++를 진행 함 (반복문). ( 각 배열의 값은 입력 배열의 인덱스를 저장하고 있다. )
		

# 두번 째 방법
 첫번째 방법은 2중 for문이 들어가기 때문에 개선이 필요함
 `P < Q 해결하기`
 1. 한 쌍의 기준을 (P,Q)로 정한다
	1. P는 값이 0인 입력 배열의 인덱스
	2. Q는 값이 1인 입력 배열의 인덱스
 2. Q의 개수를 n개로 정한다.
	1. 현재 P의 인덱스보다 작은 Q값을 다 빼야 된다. ( P < Q 조건 때문 ) --> n = n-1
		
## 소스코드

~~~java
	public int solution(int[] A) {
        // write your code in Java SE 8
		return this.test(A);
	}
	
	public int test(int[] a){
		int zeroCnt = 0;
		int oneCnt = 0;
		int total = 0;
		for(int i=0; i<a.length;i++){
			if(a[i]==0){
				zeroCnt++;
			}else{
				oneCnt++;
			}
		}
		for(int i=0;i<a.length;i++){
			if(total >1000000000){
				return -1;
			}
			if(a[i]==0){
				total += oneCnt;
			}else{
				oneCnt--;
			}
		}
//		System.out.println(total);
		return total;
	}
~~~

## 개선사항

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
