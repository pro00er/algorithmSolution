- [Nesting](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)

## 접근 방법
# 첫번 째 방법
    1. 열리는 괄호를 leftCnt로 체크
    2. 닫히는 괄호를 rightCnt로 체크
    3. 닫히는 괄호는 항상 열리는 괄호보다 작아야 한다.
    4. if문이 끝났을 때 열리는 괄호랑 닫히는 괄호 크기를 확인한다.
		

		
## 소스코드

~~~java
	public int solution(String s) {
		int leftCnt = 0;
		int rigthCnt = 0;
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i]=='('){
				leftCnt++;
			}else{
				rigthCnt++;
			}
			if(leftCnt < rigthCnt){
				return 0;
			}
			if(i == c.length-1){
				if(leftCnt != rigthCnt){
					return 0;
				}
			}
		}
		return 1;
	}
~~~

## 개선사항
    1. leftCnt와 rigthCnt를 for문이 끝나고 체크하는게 더 깔금할 듯 하다.
    2. 닫는 괄호가 나왔을 때 stack이나, list를 이용하여 element를 삭제하는 방식이 가속성은 좋을 듯 하다.

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점

## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
