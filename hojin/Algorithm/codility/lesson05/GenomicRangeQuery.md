- [GenomicRangeQuery](https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/)

## 접근 방법


# 첫번 째 방법
	1. 비교를 쉽게 하기 위해서 String[]을 int[]로 변환 한다.
  2. 변환시 for문을 최대한 적게 돌기 위하여 탐색에 필요한 부분만 변환한다. 
  3. p값과 q값에서 최소 값을 찾는다.
# 두번 째 방법

## 소스코드

~~~java
public int[] solution(String s, int[] p, int[] q){
		int intS[] = new int[s.length()];
		int result[] = new int[p.length];
		
		for(int i=0;i<p.length;i++){
			result[i] = this.getMinOfArray(s, p[i], q[i]);
//			System.out.println(result[i]);
		}
		return result;
	}
	
	public int parserStringToInt(char str){
		switch(str){
		case 'A' : return 1;
		case 'C' : return 2;
		case 'G' : return 3;
		case 'T' : return 4;
		default : System.out.println("잘못된 문자열 값이 들어왔습니다.");
			return -1;
		}
	}
	public int getMinOfArray(String str, int start, int end){
		int min = 5;
		int parserInt = 0;
		for(int i=start;i<=end;i++){
			parserInt = this.parserStringToInt(str.charAt(i));
			if(min > parserInt){
				min = parserInt;
				if(parserInt == 1){
					return 1;
				}
			}
		}
		return min;
	}
~~~

## 개선필요한 사항
 1. String[] ->int[] parser를 미리 하는게 좋을 것 같다. ( 중복되서 parser를 하는 듯 하다. )
 2. 시간복잡도가 N*M이므로 줄여야 된다.
 

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점
 1. 탐색해야되는 길이(M)만큼 for문을 돌면 안되고, 바로 값을 알 수 있는 연산이 필요하다. 즉, 2~4라고 가정했을 때 탐색없이 답을 찾아야 한다.

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 62% | 100% | 0% |
