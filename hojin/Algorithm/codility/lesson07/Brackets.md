- [Brackets](https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)

## 접근 방법


# 첫번 째 방법
    1. 아스키코드값으로는 규칙이 안보여서 임의로 규칙을 생성한다.
    2. 같은 쌍 (ex: ']', '[')은 서로 값이 1차이 나도록 한다.
    3. 최근에 열린 괄호를 저장해두는 배열을 만든다.(openArray[])
    4. 닫는 기호 " ']','}',')' "가 나왔을 경우 본인의 짝이 나온 값을 -1을 해준다.
    5. 최근의 연 기호가 본인의 짝인지 확인 한다.

## 소스코드

~~~java
public int solution(String s) {
		int[] cntArray = new int[6];
		int index = 0;
		char[] c = s.toCharArray();
		int[] openArray = new int[c.length];
		int charCnt=0;
		int recentIndex = 0;
		int openIndex = 0;
		for(int i=0; i< c.length ;i++ ){
			index = this.changeCharToTempInt(c[i]);
			if(c[i] == '}' || c[i] == ']' || c[i] == ')'){
				//짝궁의 값을 -1 시킨다.
				index--;
				cntArray[index] += -1;
				charCnt--;
				if(cntArray[index] < 0){
					return 0;
				}
				//최근의 연 기호가 본인의 짝인지 확인한다.
				openIndex--;
				if(openArray[openIndex] == index){
				}else{
					//짝궁이 아니다
					return 0;
				}
			}else{
				cntArray[index] += 1;
				charCnt++;
				openArray[openIndex++] = index;
			}
		}
		if(charCnt == 0) return 1;
		return 0;
	}
	
	public int changeCharToTempInt(char c){
		switch(c){
			case '{' : return 0;
			case '}' : return 1;
			case '[' : return 2;
			case ']' : return 3;
			case '(' : return 4;
			case ')' : return 5;
			default : new Exception(); return -1;
		}
	}
~~~

## 개선필요한 사항
 1. 웬지 짝궁의 값을 -1시키는 부분은 필요가 없어보이는 듯 하다.
 

## 시간복잡도를 주링기 위해 생각한 점, 반영한 점
 
 
## 채점 결과
| Task Score | Correctness | Performance | 
| ------------ | ------------- | ------------- |
| 100% | 100% | 100% |
