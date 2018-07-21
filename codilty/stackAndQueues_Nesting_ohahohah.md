# Problem Link
- [Codility-Lesson06-Nesting](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)

## 접근 방법
### 1차
- stack 을 사용해서 열린 괄호와 닫힌 괄호가 매칭되는지 확인

```sudo
input string to charArray
for c in char[i]:
  if c is open bracket:
    put stack
  else c is close bracket:
    if stack is empty : return wrong
    pop stack
if stack is empty :
  return RIGHT
return WRONG       
```

#### 코드 (테스트케이스를 제외한)
```java
class Solution {

  final static int RIGHT_FORMAT = 1;
  final static int WRONG_FORMAT = 0;
  final static char OPEN_BRACKET = '(';
  final static char CLOSE_BRACKET = ')';

  public int checkBracketFormat(String S) {
    char[] inputs = S.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char c : inputs) {
      if (c == OPEN_BRACKET) {
        stack.push(c);
      } else if (c == CLOSE_BRACKET) {
        if (stack.empty()) {
          return WRONG_FORMAT;
        }
      }
    }
    if (stack.isEmpty()) {
      return RIGHT_FORMAT;
    }
    return WRONG_FORMAT;
  }
}  
```

## 채점 결과
- [채점결과링크](https://app.codility.com/demo/results/trainingK9EBHQ-YQ8/)
  
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
