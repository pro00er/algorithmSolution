# Problem Link
- [link](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)

## 접근 방법
### 1차
- zero의 수를 기준으로 생각하자
	- index = 0 부터, 처음 '0' 방향이 나오기 전의 모든 1은 의미가 없다
	- 첫번째 기준을 생각할 경우
- 0을 만날때 마다 남아있는 '1'방향의 개수를 누적합 시킨다

```sudo
zerocount = count(cars)
nonzerocount = cars.length - zerocount
befor_one_count_sum(cars)
```

#### 코드
```python

def solution(cars):
    nonzero_count = 0
    for direction in cars: 
        if direction == 1:
            nonzero_count += 1
    ''' 코드 대체 가능
	import numpy as np
	nonzero_count  = np.count_nonzero(cars)	
	'''
    zero_count = len(cars) - nonzero_count
    
    number_of_cases = 0
    for direction in cars:
        if direction == 0:
            number_of_cases += nonzero_count
            zero_count -= 1
        else:
            nonzero_count -= 1
        
        if zero_count == 0:
            break
        
    return number_of_cases
```

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 70% | 100% | 40% |