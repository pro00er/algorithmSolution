# Problem Link
- [link](https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)

## 접근 방법
### 1차
- array로 for문을 돌며 Set에 하나씩 insert 만약 이미 있는 숫자면 return 0
- n으로 for문을 돌며 Set에 숫자가 없으면 return 0
- n 탐색이 끝났는데 Set에 숫자가 남아있으면 return 0
```sudo
for( i = 0 ; i<array.length ; i ++ ) {
    if( set.has( array[i] ) )
		return 0;
	set.add( array[i] );
}

for( i = 1 ; i <= N ; i++ ) {
	if( !set.has( i ) )
		return 0;
	set.remove( i );
}

if( set.size > 0 )
	return 0;
return 1;
```

#### 코드
```java
public int solution(int[] nums ) {
	int length = nums.length;
	
	Set<Integer> numSet = new HashSet<Integer>();
	for( int i = 0 ; i < nums.length ; i ++ ) {
		if( numSet.contains( nums[i] ) )
			return 0;
		numSet.add( nums[i] );
	}

	for( int i = 1 ; i <= length ; i++ ) {
		if( !numSet.contains( i ) )
			return 0;
		numSet.remove( i );
	}

	if( numSet.size() > 0 )
		return 0;
	return 1;
}
```

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |