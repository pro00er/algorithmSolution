# Problem Link
- [link](https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/)

## 접근 방법
### 1차
1. 입력받은 문자열을 영향도 값으로 변경
2. 시작 인덱스(P) 부터 시작하여 끝 인덱스(Q) 까지 중 가장 영향값이 낮은 것을 리턴한다
```sudo
function solution() {
	int[] weights;
	idx = 0
	for(char alpha:S) {
		weights[idx++] = findAlphaWeight(alpha)
	}

	for(idx=0;idx<P.length;idx++) {
		minWeight = weights[Q[idx]]
		for(searchingIdx=P[idx], endIdx=Q[idx];searchingIdx < endIdx;searchingIdx++) {
			if( minWeight > weights[searchingIdx])
				minWeight = weights[searchingIdx]
		}
		
		sysout.print(minWeight)
	}
}

function findAlphaWeight(alpha) {
	switch alpha:
		case 'C' : return 2;
		case 'A' : return 1;
		case 'G' : return 3;
		case 'T' : return 4;
}
```

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 62% | 100% | 0% |

### 문제상황
- TimeOut
- 시간복잡도가 O(N*M)