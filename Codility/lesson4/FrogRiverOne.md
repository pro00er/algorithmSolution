## 문제
  - [Codility](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)
  
## 접근
 1. 임시 배열을 만든다.
 2. 임시 배열은, 입력받은 배열의 값을 인덱스로 맵핑하여, 맵핑되면 1, 안되면 0을 적용한다.
 
 ## 신경쓴 점
  1. 탐색을 조금이라도 덜 하기 위해서, 임시배열 탐색의 마지막 인덱스를 기억한다.
 
 
 ## 코드
 ~~~java
 public int solution(int X, int[] A) {
		return this.test(X, A);
	}

	public int test(int goal, int[] array) {
		int resutlInt = 0;
		int lastIndex = 0;
		int[] checkAr = new int[array.length];
		checkAr[0] = 1;
		for (int i = 0; i < array.length; i++) {
			checkAr[array[i]] = 1;
			lastIndex = this.check(checkAr, i, lastIndex);
			if (lastIndex == goal) {
				return i;
			}
		}
		return resutlInt;
	}

	public int check(int[] checkAr, int i, int lastIndex) {
		if (lastIndex != 0) {
			for (int j = lastIndex; j < i; j++) {
				if (checkAr[j] != 0) {
					lastIndex = j;
				} else {
					break;
				}
			}
		} else {
			for (int j = 0; j < i; j++) {
				if (checkAr[j] != 0) {
					lastIndex = j;
				} else {
					break;
				}
			}
		}
		return lastIndex;
	}
  ~~~

## 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 63% | 50% | 80% |

 1. Correctness 결과
 
 | TestCase |  Result | 
| ------------ |------------ |
| simple | Ok |
| single | -1 |
| extreme_frog | No |
| small_random1 | Ok |
| small_random2 | Ok |
| extreme_leaves | No |
