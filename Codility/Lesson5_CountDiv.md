# Problem Link
- [link](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)

## 접근 방법
### 1차
- K의 배수의 갯수를 구하라고 파악됨
- B/K - A/K + 1이라고 생각
	- K가 B보다 큰경우 무조건 0을 return
	- A/K가 counting 범위에 포함될 경우를 생각해야함
	- B==A일 경우도 생각해야함
```sudo
if K > B:
	return 0

if K == B :
	return 1

return B/K - A/K + 1
```

#### 코드
```python
def solution(A, B, K):
    if K > B :
        return 0
    elif K == B:
        return 1
    elif A == B:
        return 1 if B%K == 0 else 0
    
    return int(B/K) - int(A/K) + ( 0 if A%K > 0 else 1 )
```
-
##### WRONG ANSWER
- case1. A=B in {0,1}, K=11, got 0 expected 1
- case2. A = 0, B = MAXINT, K in {1,MAXINT}, got 1 expected 2

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 75% | 75% | 75% |