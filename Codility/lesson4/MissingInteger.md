## 문제
  - [Codility](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)
  
## 접근
 1. 임시 배열을 만든다.
 2. 임시 배열을 완전 탐색한다....;
 
 ## 고쳐야 되는 부분
  1. 임시배열의 크기가 너무비약적으로 커진다.
  2. 탐색의 속도가 너무 느리다.
 
 ## 코드
 ~~~java
 public int solution(int[] A) {
		return this.test1(A);
    }
	
	public int test1(int[] array){
		int length = array.length;
		int[] checkAr = new int[1000000];
		checkAr[0]= array[0];
		for(int i=0; i< length; i++){
			if(array[i]<0)	return 1;
			checkAr[array[i]] = 1;
		}
		for(int i=0; i<1000000; i++){
			if(checkAr[i]==0)	return i;
		}
		return length+1;
	}
  ~~~

## 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 66% | 80% | 50% |


 1. Correctness 결과
 
 | TestCase |  Result | 
| ------------ |------------ |
| extreme_min_max_value | No |

