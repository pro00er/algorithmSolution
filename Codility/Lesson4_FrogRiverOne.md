# Problem Link
- [link](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)

## 접근 방법
1. range사이의 모든 숫자가 다 나타날 경우 frog는 강을 건널 수 있다
```sudo
Set<number> rangeNumbers = range(1, N);

for( i=0 ; i<A.length && rangeNumbers.size() > 0 ; i++ ) {
	rangeNumbers.remove( A[i] );
} 
```

## 풀이
```java

```