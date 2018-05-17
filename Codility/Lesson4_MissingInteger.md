# Problem Link
- [link](https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)

## 접근 방법
### 1차
- 입력받은 array에서 중복되는 숫자를 제거하고
- 중복숫자가 없는 array를 정렬해서 처리해야 겠다
	- 정렬된 array를 탐색하며 중간수가 없는 경우 그 수를 출력
```sudo
Set intSet = new Set( array );
List ints = new List( intSet );
if( ints.lastnum < 1 )
	return 1;

if( ints.fitstnum > 1 )
	return 1;
	
for(i=1 ; i < ints.length ; i++)
	if( ints[i-1]+1 < ints[i])
		return inst[i-1]+1;

return int.lastnum + 1;
```

#### 코드
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public int solution(int[] ints) {
	Set<Integer> intSet = new HashSet<Integer>();
	
	int maxnum = 0;
	int minnum = Integer.MAX_VALUE;
	for (int number : ints) {
		intSet.add( number );
		if( number < minnum )
			minnum = number;
		if( number > maxnum )
			maxnum = number;
	}
	
	if( maxnum < 0 || minnum > 1 )
		return 1;
	List<Integer> intList = new ArrayList<Integer>();
	intList.addAll( intSet );
	
	Collections.sort( intList );
	
	int listSize = intList.size();
	for (int idx = 1; idx < listSize; idx++) {
		if( intList.get(idx-1) + 1 != intList.get(idx) ) {
			return getReturnNum( intList.get(idx-1) );
		}
	}
	
	return maxnum + 1;
}

public int getReturnNum(int startnum) {
	if( startnum < 1 )
		return 1;
	return startnum + 1;
}
```

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 66% | 80% | 50% |